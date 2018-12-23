package main.model.generation;

/**
 * The abstract class for an organism factory. Specify the type when you are constructing the factory
 * 
 * @author jhwang73
 * @param <Species> The species of the organism
 */
public abstract class AOrganismFactory<Species> {
	
	/**
	 * Get the name of the species of the organism.
	 * @return The name
	 */
	public abstract String getSpeciesName();
	
	/**
	 * Generate a random organism of the type Species
	 * @return A random Organism
	 */
	public abstract Species makeRandomOrganism();
	
	// TODO: this will be created as anon inner class in the model. the view picks a species factory & an ecosystem
	// construct the ecosystem with factory as argument. DONE.
	
}
