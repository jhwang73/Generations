package main.model.generation;

/**
 * The factory for an ecosystem.
 * 
 * @author jhwang73
 * @param <RequiredSpecies> The species required by the ecosystem
 */
public abstract class AEcosystemFactory<RequiredSpecies extends IOrganism> {
	
	/**
	 * Make an organism with the given generation size and organism factory.
	 * @param generationSize The size of the generation
	 * @param organismFactory The organism factory
	 * @return The ecosystem
	 */
	public abstract IEcosystem<RequiredSpecies> makeEcosystem(int generationSize, AOrganismFactory<RequiredSpecies> organismFactory);
	
	/**
	 * Get the class of the type of organism required by the ecosystem
	 * @return The class
	 */
	public abstract Class<RequiredSpecies> getRequiredOrganismClass();
}
