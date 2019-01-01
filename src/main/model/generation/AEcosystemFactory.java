package main.model.generation;

/**
 * The factory for an ecosystem.
 * 
 * @author jhwang73
 */
public abstract class AEcosystemFactory {
	
	@Override
	public String toString() {
		return getEcosystemName();
	}
	
	/**
	 * Get the name of the ecosystem.
	 * @return The name
	 */
	protected abstract String getEcosystemName();
	
	/**
	 * Make an organism with the given generation size and organism factory.
	 * @param generationSize The size of the generation
	 * @param organismFactory The organism factory
	 * @return The ecosystem
	 */
	public abstract IEcosystem makeEcosystem(int generationSize, AOrganismFactory organismFactory);
	
	/**
	 * Get the class of the type of organism required by the ecosystem
	 * @return The class
	 */
	public abstract Class<? extends IOrganism> getRequiredOrganismClass();
}
