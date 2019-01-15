package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
	 * Get the first team
	 * @return The list of players on the first team
	 */
	public List<P> getTeam1() {
		return this._team1;
	}
	
	/**
	 * Get the second team
	 * @return The list of players on the second team
	 */
	public List<P> getTeam2() {
		return this._team2;
	}
	
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
	 * Get the list of active players.
	 * @return The list of active players
	 */
	public List<P> getActivePlayers() {
		List<P> activePlayers = new ArrayList<>();
		activePlayers.addAll(this._team1);
		activePlayers.addAll(this._team2);
		return activePlayers;
	}
	
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
	 * Get the active players between this organism and another parent organism
	 * @param parent2 The other parent
	 * @return The list of active players in this organism and the other parent organism
	 */
	public List<P> combinedActivePlayers(AMatchupOrganism<P> parent2) {
		List<P> activePlayers = new ArrayList<>();
		List<P> activePlayersP1 = this.getActivePlayers();
		List<P> activePlayersP2 = parent2.getActivePlayers();
		activePlayersP1.forEach((ap) -> {
			if (!activePlayers.contains(ap))
				activePlayers.add(ap);
		});
		activePlayersP2.forEach((ap) -> {
			if (!activePlayers.contains(ap))
				activePlayers.add(ap);
		});
		
		return activePlayers;
	}
	
	/**
	 * Map the active players to an index.
	 * @param activePlayers The list of active players
	 * @return The mapping from players to their indices
	 */
	private Map<P, Integer> indexActivePlayers(List<P> activePlayers) {
		Map<P, Integer> playerToIndex = new HashMap<>();
		for (int i = 0; i< activePlayers.size(); i++) {
			playerToIndex.put(activePlayers.get(i), i);
		}
		
		return playerToIndex;
	}
	
	/**
	 * Count how many times each active player has been on the same team as each other players.
	 * @param playerToIndex The mapping of players to their index in the counts array
	 * @param parent1 The first parent
	 * @param parent2 The second parent
	 * @return A matrix of the counts
	 */
	private int[][] makeCounts(Map<P, Integer> playerToIndex, AMatchupOrganism<P> parent1, AMatchupOrganism<P> parent2) {
		int numActivePlayers = playerToIndex.size();
		int[][] counts = new int[numActivePlayers][numActivePlayers];
				
		for (int i = 0; i < this._teamSize; i++) {
			int p1t1i = playerToIndex.get(parent1.getTeam1().get(i));
			int p1t2i = playerToIndex.get(parent1.getTeam2().get(i));
			int p2t1i = playerToIndex.get(parent2.getTeam1().get(i));
			int p2t2i = playerToIndex.get(parent2.getTeam2().get(i));
			for (int j = 0; j < i; j++) {
				int p1t1j = playerToIndex.get(parent1.getTeam1().get(j));
				int p1t2j = playerToIndex.get(parent1.getTeam2().get(j));
				int p2t1j = playerToIndex.get(parent2.getTeam1().get(j));
				int p2t2j = playerToIndex.get(parent2.getTeam2().get(j));
				
				counts[p1t1i][p1t1j]++;
				counts[p1t1j][p1t1i]++;
				
				counts[p1t2i][p1t2j]++;
				counts[p1t2j][p1t2i]++;
				
				counts[p2t1i][p2t1j]++;
				counts[p2t1j][p2t1i]++;
				
				counts[p2t2i][p2t2j]++;
				counts[p2t2j][p2t2i]++;
			}
		}
			
		return counts;
	}
	
	/**
	 * Fill the two given teams with players according to the counts
	 * @param activePlayers The list of active players to be candidates for children
	 * @param playerToIndex The mapping of players to their index in the counts array
	 * @param counts The mapping of counts of the frequency of players being on the same team
	 * @param team1 The first team to fill
	 * @param team2 The second team to fill
	 */
	private void fillTeams(List<P> activePlayers, Map<P, Integer> playerToIndex, int[][] counts, List<P> team1, List<P> team2) {
		while (team1.size() < this._teamSize && team2.size() < this._teamSize) {
			P nextPlayer = activePlayers.remove(0);
			int nextPlayerIndex = playerToIndex.get(nextPlayer);
			
			int team1TeammateCount = team1.stream().mapToInt((teammate) -> counts[nextPlayerIndex][playerToIndex.get(teammate)]).sum();
			int team2TeammateCount = team2.stream().mapToInt((teammate) -> counts[nextPlayerIndex][playerToIndex.get(teammate)]).sum();
			
			int totalCount = team1TeammateCount + team2TeammateCount;
			
			// Proportionally select which team to be added to
			if (Math.random() * totalCount < team1TeammateCount) {
				team1.add(nextPlayer);
			} else {
				team2.add(nextPlayer);
			}
		}
		
		while (team1.size() < this._teamSize) {
			team1.add(activePlayers.remove((int)(Math.random() * activePlayers.size())));
		}
		while (team2.size() < this._teamSize) {
			team2.add(activePlayers.remove((int)(Math.random() * activePlayers.size())));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IOrganism reproduce(IOrganism mate) {
		List<P> childTeam1 = new ArrayList<>();
		List<P> childTeam2 = new ArrayList<>();
		
		AMatchupOrganism<P> parent2 = (AMatchupOrganism<P>)mate;
		
		List<P> activePlayers = this.combinedActivePlayers(parent2);
		
		Map<P, Integer> playerToIndex = this.indexActivePlayers(activePlayers);
		
		int[][] counts = this.makeCounts(playerToIndex, this, parent2);
		
		this.fillTeams(activePlayers, playerToIndex, counts, childTeam1, childTeam2);
		
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
	 * @return The score of the team
	 */
	public int score() {
		int team1Score = this.teamScore(this._team1);
		int team2Score = this.teamScore(this._team2);
		return Math.abs(team1Score - team2Score);
	}

}
