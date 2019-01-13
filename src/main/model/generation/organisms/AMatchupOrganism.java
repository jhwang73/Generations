package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import main.model.generation.ecosystems.MatchmakingEcosystem.Player;

import main.model.generation.IOrganism;

/**
 * Matchup organisms. 
 * 
 * @author jasonhwang
 * @param P The specific type of player
 */
public abstract class AMatchupOrganism<P extends Player> implements ISexualOrganism {

	/**
	 * The list of available players
	 */
	protected List<P> _availablePlayers;
	
	/**
	 * The size of the teams
	 */
	private final int _teamSize;
	
	/**
	 * The first team
	 */
	protected List<P> _team1;
	
	/**
	 * The second team
	 */
	protected List<P> _team2;
	
	/**
	 * The constructor for the matchup organism
	 * @param teamSize The size of each team
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public AMatchupOrganism(int teamSize, List<P> team1, List<P> team2) {
		this._teamSize = teamSize;
		this._team1 = team1;
		this._team2 = team2;
	}
	
	/**
	 * Add consecutive numAdditions players to the given team, starting at
	 * startingIdx in the list of players
	 * @param startingIdx The starting index in the list of players
	 * @param numAdditions The number of players to add
	 * @param team The team to add to
	 */
	private void addPlayersToTeam(int startingIdx, int numAdditions, List<P> team) {
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
	protected abstract List<P> getAvailablePlayers();
	
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
		int mutationIdx1 = (int) (Math.random() * this._teamSize);
		int mutationIdx2 = (int) (Math.random() * this._teamSize);
		P player1 = this._team1.get(mutationIdx1);
		P player2 = this._team2.get(mutationIdx2);
		this._team1.add(player2);
		this._team2.add(player1);
		this._team1.remove(player1);
		this._team2.remove(player2);
		return player1.toString() + " traded with " + player2.toString();
	}

	@Override
	public String getName() {
		return "Team " + this._team1.get(0) + " VS Team " + this._team2.get(0);
	}
	
	/**
	 * Count how many times each player has been on the same team as each other players.
	 * @return A mapping of the counts
	 */
	private Map<P, Map<P, Integer>> makeCounts() {
//		Map<String, Map<String, Integer>> counts = new IdentityHashMap<>();
	    // // For every player
	    // for (String player:players) {
	    //   Map<String, Integer> map1 = new IdentityHashMap<>();
	    //   for (String teammate:players) {
	    //     map1.put(teammate, 0);
	    //   }
	    //   counts.put(player, map1);
	    // }
	    // for (int parent:parents) {
	    //   for (String teammate:matchUps.get(parent).getTeam1()) {
	    //     for (String teammate2:matchUps.get(parent).getTeam1()) {
	    //       counts.get(teammate).put(teammate2, counts.get(teammate).get(teammate2) + 1);
	    //       counts.get(teammate2).put(teammate, counts.get(teammate2).get(teammate) + 1);
	    //     }
	    //   }
	    //   for (String teammate:matchUps.get(parent).getTeam2()) {
	    //     for (String teammate2:matchUps.get(parent).getTeam2()) {
	    //       counts.get(teammate).put(teammate2, counts.get(teammate).get(teammate2) + 1);
	    //       counts.get(teammate2).put(teammate, counts.get(teammate2).get(teammate) + 1);
	    //     }
	    //   }
	    // }
		return null;
	}
	
	/**
	 * Fill the two given teams according to the counts
	 * @param counts The mapping of counts of the frequency of players being on the same team
	 * @param team1 The first team to fill
	 * @param team2 The second team to fill
	 */
	private void fillTeams(Map<P, Map<P, Integer>> counts, List<P> team1, List<P> team2) {
		
	}
	
	@Override
	public IOrganism reproduce(IOrganism mate) {
		List<P> childTeam1 = new ArrayList<>();
		List<P> childTeam2 = new ArrayList<>();
		Map<P, Map<P, Integer>> counts = this.makeCounts();
		this.fillTeams(counts, childTeam1, childTeam2);
		return this.produceOrganism(childTeam1, childTeam2);
	}
	
	/**
	 * Produce the organism with the given teams
	 * @param team1 Team 1
	 * @param team2 Team 2
	 * @return The new AMatchupOrganism of type P.
	 */
	protected abstract AMatchupOrganism<P> produceOrganism(List<P> team1, List<P> team2);
	
	/**
	 * Get the total score of the team
	 * @param team The team
	 * @return The total score of the team
	 */
	private int teamScore(List<P> team) {
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
