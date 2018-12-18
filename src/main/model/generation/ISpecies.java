package main.model.generation;

import java.util.List;

/**
 * The interface that describes the species which are used in the Generations application.
 * 
 * @author jhwang73
 * @param <Organism> The type of organism
 */
public interface ISpecies<Organism> {
	
	/**
	 * Initialize and return the 0th generation.
	 * @return The 0th generation.
	 */
	public List<Organism> initialGeneration();
}
