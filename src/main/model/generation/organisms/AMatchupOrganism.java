package main.model.generation.organisms;

import java.util.List;

import main.model.generation.IOrganism;

/**
 * Matchup organisms. 
 * 
 * @author jasonhwang
 */
public abstract class AMatchupOrganism<Player> implements ISexualOrganism {

	/**
	 * The constructor for the matchup organism
	 * @param teamSize The size of each team
	 * @param team1 Team 1
	 * @param team2 Team 2
	 */
	public AMatchupOrganism(int teamSize, List<Player> team1, List<Player> team2) {
		
	}
	
	@Override
	public String mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOrganism reproduce(IOrganism mate) {
		// TODO Auto-generated method stub
		return null;
	}

}
