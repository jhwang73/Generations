package main.model.generation.concreteOrganisms;

import main.model.generation.IOrganism;

/**
 * A fighting type organism.
 * 
 * @author jhwang73
 * @param <Species> The type of opponent that this fighting organism can fight
 */
public abstract class AFightingOrganism<Species> implements IOrganism {
	
	/**
	 * The constructor for the fighting organism
	 */
	public AFightingOrganism() {
		
	}
	
	@Override
	public String displayAsString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Fight the opponent. Return true for a victory, false for a loss
	 * @param opponent The opponent to fight
	 * @return The outcome of the fight
	 */
	public abstract boolean fight(Species opponent);
	
}
