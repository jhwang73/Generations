package main.model.generation;

/**
 * The interface that describes ecosystems.
 * 
 * @author jhwang73
 * @param <Species> The species in the ecosystem
 */
public interface IEcosystem<Species extends IOrganism> {
	
	/**
	 * Get information about this ecosystem.
	 * This should return the name, the rules on how generations are made & advance in this ecosystem,
	 * and any other relevant information.
	 * @return The ecosystem info
	 */
	public String getEcosystemInfo();
	
	/**
	 * Initialize and return the 0th generation and info regarding the construction of that generation.
	 * @return The 0th generation
	 */
	public GenerationInfo<Species> initialGeneration();
	
	/**
	 * Simulate and return the next generation and info regarding the construction of that generation.
	 * @return The next generation.
	 */
	public GenerationInfo<Species> nextGeneration();

}
