package main.model.generation;

/**
 * The interface that describes ecosystems.
 * 
 * @author jhwang73
 */
public interface IEcosystem {

	/**
	 * Initialize and return the 0th generation.
	 * @return The 0th generation
	 */
	public GenerationInfo initialGeneration();
	
	/**
	 * Simulate and return the next generation.
	 * @return The next generation.
	 */
	public GenerationInfo nextGeneration();
	
}
