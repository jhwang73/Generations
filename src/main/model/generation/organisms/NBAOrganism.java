package main.model.generation.organisms;

import java.util.List;

/**
 * The NBA matchup organism. Matches 5 NBA players against 5 more NBA players. 
 * 
 * @author jasonhwang
 */
public class NBAOrganism extends AMatchupOrganism<Object> {

	/**
	 * The Constructor for the NBA Organism
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public NBAOrganism(List<Object> team1, List<Object> team2) {
		super(5, team1, team2);
		// TODO Auto-generated constructor stub
	}
	
}