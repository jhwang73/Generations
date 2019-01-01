package main.model.generation;

/**
 * The abstract class for an organism factory. Specify the type when you are constructing the factory
 * 
 * @author jhwang73
 * @param <Species> The species of the organism
 */
public abstract class AOrganismFactory<Species extends IOrganism> {
	
	@Override
	public String toString() {
		return getSpeciesName();
	}
	
	/**
	 * Get the name of the species of the organism.
	 * @return The name
	 */
	public abstract String getSpeciesName();
	
	/**
	 * Generate an organism of the type Species
	 * @return An Organism
	 */
	public abstract Species makeOrganism();
	
	/**
	 * Get the class of the organism
	 * @return The class
	 */
	public abstract Class<Species> getOrganismClass();
	
}
