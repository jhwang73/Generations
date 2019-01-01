package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * Natural organisms. These organisms can either aseuxally or sexually reproduce. 
 * These organisms can also mutate.
 * 
 * @author jhwang73
 */
public interface INaturalOrganism extends IOrganism {
	
	/**
	 * Mutate the natural organism
	 * @return Info about the mutation
	 */
	public String mutate();
	
}
