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
	 * @param opponent The opponent to fight
	 */
	public boolean fight(IOrganism opponent);
	
}
