package main.model.generation;

/**
 * The interface that describes an an organism of some species.
 * 
 * @author jhwang73
 */
public interface IOrganism {
	
	/**
	 * Get the name of the species.
	 * @return The name of the species
	 */
	public String getSpeciesName();
	
	/**
	 * Get the name of the organism.
	 * @return The name of the organism
	 */
	public String getName();
	
}