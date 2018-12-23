package main.model.generation.concreteOrganisms;

import main.model.generation.IOrganism;

/**
 * Fighter type organisms.
 * 
 * @author jhwang73
 * @param <Species> The species of the opponent organism
 */
public interface IFighter<Species> extends IOrganism {
	
	/**
	 * Fight the opponent. Return true for a victory, false for a loss
	 * @param opponent The opponent to fight
	 * @return The outcome of the fight
	 */
	public boolean fight(Species opponent);

}
