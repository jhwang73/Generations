package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The NBA matchup organism. Matches 5 NBA players against 5 more NBA players. 
 * 
 * @author jasonhwang
 */
public class NBAOrganism extends AMatchupOrganism<NBAOrganism.NBAPlayer> {
	
	public enum NBAPlayer {
		
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
		
		/**
		 * Get the skill level of the player
		 * @return The int of the skill level
		 */
		public int getSkillLevel() {
			return this._skillLevel;
		}
	}
	
	/**
	 * The name of the species of this organism.
	 */
	public final static String _speciesName = "NBAPlayers";
	
	/**
	 * The list of available NBA Players.
	 */
	private final static List<NBAPlayer> _availableNBAPlayers = new ArrayList<>(Arrays.asList(NBAPlayer.values()));
	
	/**
	 * The Constructor for the NBA Organism
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public NBAOrganism(List<NBAOrganism.NBAPlayer> team1, List<NBAOrganism.NBAPlayer> team2) {
		super(5, team1, team2);
	}
	
	/**
	 * Add five consecutive players to a team from the list of available players.
	 * @param startingIdx The starting index
	 * @param team The team
	 */
	private static void addPlayersToTeam(int startingIdx, List<NBAOrganism.NBAPlayer> team) {
		for (int i = 0; i < 5; i++) {
			team.add(_availableNBAPlayers.get(startingIdx + i));
		}
	}
	
	/**
	 * Get a random team matchup
	 * @return An NBA Organism.
	 */
	public static NBAOrganism getRandomNBAOrganism() {
		Collections.shuffle(_availableNBAPlayers);
		List<NBAOrganism.NBAPlayer> team1 = new ArrayList<>();
		List<NBAOrganism.NBAPlayer> team2 = new ArrayList<>();
		addPlayersToTeam(0, team1);
		addPlayersToTeam(5, team2);
		return new NBAOrganism(team1, team2);	
	}
	
}