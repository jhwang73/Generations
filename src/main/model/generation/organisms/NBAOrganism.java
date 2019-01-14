package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.model.generation.ecosystems.MatchmakingEcosystem.Player;

/**
 * The NBA matchup organism. Matches 5 NBA players against 5 more NBA players. 
 * 
 * @author jasonhwang
 */
public class NBAOrganism extends AMatchupOrganism<NBAOrganism.NBAPlayer> {
	
	public enum NBAPlayer implements Player{
		// TEST WORKS WITH 11 PLAYERS
		MICHAEL_JORDAN(99),
		LEBRON_JAMES(98),
		STEPHEN_CURRY(96),
		PAUL_GEORGE(90),
		JOHN_WALL(89),
		VICTOR_OLADIPO(88),
		BRADLEY_BEAL(87),
		DEVIN_BOOKER(86),
		STEVEN_ADAMS(85),
		KYLE_KUZMA(84),
		BRANDON_INGRAM(81);
		
		/**
		 * The skill rating of the player. Based off NBA 2K.
		 */
		private int _skillLevel;
		
		/**
		 * The constructor for the NBA Player
		 * @param skillLevel The skill level of the player
		 */
		private NBAPlayer(int skillLevel) {
			this._skillLevel = skillLevel;
		}
		
		@Override
		public int getSkillLevel() {
			return this._skillLevel;
		}
	}
	
	/**
	 * The name of the species of this organism.
	 */
	public final static String _speciesName = "NBAPlayers";
		
	/**
	 * The Constructor for the NBA Organism.
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public NBAOrganism(List<NBAOrganism.NBAPlayer> team1, List<NBAOrganism.NBAPlayer> team2) {
		super(5, team1, team2);
	}
	
	/**
	 * The Constructor for a random NBA Organism.
	 */
	public NBAOrganism() {
		super(5);
	}

	@Override
	protected List<NBAPlayer> getAvailablePlayers() {
		return new ArrayList<>(Arrays.asList(NBAPlayer.values()));
	}

	@Override
	protected AMatchupOrganism<NBAPlayer> produceOrganism(List<NBAPlayer> team1, List<NBAPlayer> team2) {
		return new NBAOrganism(team1, team2);
	}
	
}