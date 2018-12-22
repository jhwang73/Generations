package main.model.generation.concreteEcosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.IOrganism;

/**
 * The base class of dynamic ecosystems, where interaction is not fixed. All dynamic ecosystems extend this.
 * 
 * @author jhwang73
 * @param <Species> The species in the ecosystem
 */
public abstract class ADynamicEcosystem<Species extends IOrganism> implements IEcosystem<Species> {
		
	/**
	 * The iteration of the current generation.
	 */
	protected int _generationNumber = 0;
	
	/**
	 * The size of the generation.
	 */
	protected final int _generationSize;
	
	/**
	 * The current generation.
	 */
	protected List<Species> _currentGeneration;
	
	/**
	 * The factory for an organism of the species.
	 */
	protected final AOrganismFactory<Species> _organismFactory;
	
	/**
	 * The name of the species in the ecosystem.
	 */
	protected final String _speciesName;
	
	/**
	 * The constructor for dynamic ecosystems.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param organismFactory The factory for an organism of species Species
	 */
	public ADynamicEcosystem(int generationSize, AOrganismFactory<Species> organismFactory) {
		if (generationSize < 2)
			System.out.println("generation size must be at least 2!");
		this._generationSize = generationSize;
		this._organismFactory = organismFactory;
		this._speciesName = organismFactory.getSpeciesName();
	}
	
	@Override
	public final GenerationInfo<Species> initialGeneration() {
		// Reset the variables
		this._generationNumber = 0;
		this._currentGeneration = new ArrayList<Species>();
		
		String info = this._generationSize + " " + this._speciesName + "(s) have been randomly generated to make the initial generation!";
		
		for (int i = 0; i < this._generationSize; i++) {
			this._currentGeneration.add(this._organismFactory.makeRandomOrganism());
		}
		
		return new GenerationInfo<Species>(this._generationNumber, info, this._currentGeneration);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final GenerationInfo<Species> nextGeneration() {
		// Template Design. All concrete dynamic ecosystems will follow this template.
		if (this._generationNumber < 0) {
			System.out.println("initialGeneration must be called before calling this method!");
			return GenerationInfo.errorGI;
		}
		
		this._generationNumber++;
		
		String analysis = analyzeCurrentGeneration();
		
		String newGenerationInfo = productNextGeneration();
		
		String info = "Information about the old generation: " + analysis +
				"\nInformation about the new generation: " + newGenerationInfo;
		
		return new GenerationInfo<Species>(this._generationNumber, info, this._currentGeneration);
	}
	
	/**
	 * Analyze the current generation and get any information needed to produce the next generation
	 * @return A report of the analysis
	 */
	public abstract String analyzeCurrentGeneration();
	
	/**
	 * Produce the next generation. This should update the new generation to the current generation of this ecosystem.
	 * @return A report of the generation
	 */
	public abstract String productNextGeneration();
	
	
}
