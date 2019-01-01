package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * Organisms which can asexually reproduce.
 * 
 * @author jhwang73
 */
public interface IAsexualOrganism extends INaturalOrganism {
	
	/**
	 * Reproduce asexually
	 * @return A new organism, the child of this organism
	 */
	public IOrganism reproduce();

}
