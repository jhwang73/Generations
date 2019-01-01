package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * Organisms which can sexually reproduce.
 * 
 * @author jhwang73
 */
public interface ISexualOrganism extends INaturalOrganism {

	/**
	 * Reproduce sexually
	 * @param mate The mate
	 * @return A new organism, the child of this organism and its mate
	 */
	public IOrganism reproduce(IOrganism mate);
	
}
