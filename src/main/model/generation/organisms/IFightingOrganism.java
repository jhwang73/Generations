package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * Organisms which can fight.
 * 
 * @author jhwang73
 */
public interface IFightingOrganism extends IAsexualOrganism {
	
	/**
	 * Fight the opponent.
	 * -1 Lose
	 * 0  Tie
	 * 1  Win
	 * @param opponent The opponent to fight
	 */
	public int fight(IOrganism opponent);
	
}
