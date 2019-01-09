package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.model.generation.IOrganism;

/**
 * Matchup organisms. 
 * 
 * @author jasonhwang
 */
public abstract class AMatchupOrganism<Player> implements ISexualOrganism {

	/**
	 * The list of available players
	 */
	protected List<Player> _availablePlayers;
	
	/**
	 * The size of the teams
	 */
	private final int _teamSize;
	
	/**
	 * The first team
	 */
	private List<Player> _team1;
	
	/**
	 * The second team
	 */
	private List<Player> _team2;
	
	/**
	 * The constructor for the matchup organism
	 * @param teamSize The size of each team
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public AMatchupOrganism(int teamSize, List<Player> team1, List<Player> team2) {
		this._teamSize = teamSize;
		this._team1 = team1;
		this._team2 = team2;
	}
	
	public AMatchupOrganism(int teamSize) {
		this._teamSize = teamSize;
		Collections.shuffle(this._availablePlayers);
		this._team1 = new ArrayList<>();
		this._team2 = new ArrayList<>();
		this.addPlayersToTeam(0, this._teamSize, this._team1);
		this.addPlayersToTeam(this._teamSize, this._teamSize, this._team2);
	}
	
	/**
	 * Add consecutive numAdditions players to the given team, starting at
	 * startingIdx in the list of players
	 * @param startingIdx The starting index in the list of players
	 * @param numAdditions The number of players to add
	 * @param team The team to add to
	 */
	private void addPlayersToTeam(int startingIdx, int numAdditions, List<Player> team) {
		for (int i = 0; i < this._teamSize; i++) {
			team.add(this._availablePlayers.get(startingIdx + i));
		}
	}
	
	@Override
	public String toString() {
		
	}
	
	@Override
	public String mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "Team " + this._team1.get(0) + " VS Team" + this._team2.get(0);
	}

	@Override
	public IOrganism reproduce(IOrganism mate) {
		// TODO Auto-generated method stub
		return null;
	}

}
