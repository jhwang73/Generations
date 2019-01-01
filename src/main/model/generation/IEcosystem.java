package main.model.generation;

/**
 * The interface that describes ecosystems.
 * 
 * @author jhwang73
 */
public interface IEcosystem {
	
	/**
	 * Get the name of this ecosystem.
	 * @return The name
	 */
	public String getEcosystemName();
	
	/**
	 * Get the rules on how generations are made & advanced in this ecosystem.
	 * @return The rules 
	 */
	public String getEcosystemRules();
	
	/**
	 * Initialize and return the 0th generation and info regarding the construction of that generation.
	 * @return The 0th generation
	 */
	public GenerationInfo initialGeneration();
	
	/**
	 * Simulate and return the next generation and info regarding the construction of that generation.
	 * initialGeneration() must be called before this is called.
	 * @return The next generation.
	 */
	public GenerationInfo nextGeneration();

}
