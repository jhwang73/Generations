package main.model.generation;

/**
 * The interface that describes generationizable species(plural).
 * 
 * @author jhwang73
 * @param <Species> The species(singular)
 */
public interface IGenerationizable<Species> {

	/**
	 * Initialize and return the 0th generation.
	 * @return The 0th generation
	 */
	public GenerationInfo<Species> initialGeneration();
	
	/**
	 * Simulate and return the next generation.
	 * @return The next generation.
	 */
	public GenerationInfo<Species> nextGeneration();
	
}
