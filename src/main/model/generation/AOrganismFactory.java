package main.model.generation;

/**
 * The abstract class for an organism factory.
 * 
 * @author jhwang73
 */
public abstract class AOrganismFactory {
	
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
	public abstract IOrganism makeOrganism();
	
	/**
	 * Get the class of the organism
	 * @return The class
	 */
	public abstract Class<? extends IOrganism> getOrganismClass();
	
}
