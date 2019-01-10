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
	
	public interface Player {
		/**
		 * Get the skill level of the player
		 * @return The skill level of the player
		 */
		public int getSkillLevel();
	}

	/**
	 * The list of available players
	 */
	protected List<? extends Player> _availablePlayers;
	
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
	public AMatchupOrganism(int teamSize, List<? extends Player> team1, List<? extends Player> team2) {
		this._teamSize = teamSize;
		this._team1 = new ArrayList<>();
		team1.forEach((player) -> this._team1.add(player));
		this._team2 = new ArrayList<>();
		team2.forEach((player) -> this._team2.add(player));
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
	
	/**
	 * The constructor for the random matchup organism
	 * @param teamSize The size of each team
	 */
	public AMatchupOrganism(int teamSize) {
		this._teamSize = teamSize;
		this._availablePlayers = this.getAvailablePlayers();
		Collections.shuffle(this._availablePlayers);
		this._team1 = new ArrayList<>();
		this._team2 = new ArrayList<>();
		this.addPlayersToTeam(0, this._teamSize, this._team1);
		this.addPlayersToTeam(this._teamSize, this._teamSize, this._team2);
	}
	
	/**
	 * Get the list of available players to be placed into teams
	 * @return The list of available players
	 */
	protected abstract List<? extends Player> getAvailablePlayers();
	
	/**
	 * A method used to build a space string
	 * @param length The number of spaces
	 * @return A string which is a number of spaces
	 */
	private String buildSpaces(int length) {
		String output = "";
		for (int i = 0; i < length; i++) {
			output += " ";
		}
		return output;
	}
	
	@Override
	public String toString() {
		String output = "";
		int spaceLen = 16;
		for (int i = 0; i < this._teamSize; i++) {
			int playerLen = this._team1.get(i).toString().length();
			output += this._team1.get(i).toString() + this.buildSpaces(spaceLen - playerLen) + this._team2.get(i) + "\n";
		}
		return output;
	}
	
	@Override
	public String mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "Team " + this._team1.get(0) + " VS Team " + this._team2.get(0);
	}

	@Override
	public IOrganism reproduce(IOrganism mate) {
		// TODO: implement
		return this;
	}
	
	/**
	 * Get the total score of the team
	 * @param team The team
	 * @return The total score of the team
	 */
	private int teamScore(List<Player> team) {
		int res = 0;
		for (int i = 0; i < team.size(); i ++) {
			res += team.get(0).getSkillLevel();
		}
		return res;
	}
	
	/**
	 * Score the team matchup in terms of fairness.
	 * @return
	 */
	public int score() {
		int team1Score = this.teamScore(this._team1);
		int team2Score = this.teamScore(this._team2);
		return Math.abs(team1Score - team2Score);
	}

}
