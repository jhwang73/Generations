package main.model.generation.ecosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.organisms.INaturalOrganism;

/**
 * The base class of natural ecosystems, where organisms dynamically interact, or in other words generations are not static.
 * This is meant to mimic natural generations, where the best-suited organisms survive and reproduce.
 * 
 * @author jhwang73
 * @param <Species> The species in the ecosystem
 */
public abstract class ANaturalEcosystem<Species extends INaturalOrganism> implements IEcosystem<Species> {
	
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
	protected final AOrganismFactory _organismFactory;
	
	/**
	 * The name of the species in the ecosystem.
	 */
	protected final String _speciesName;
	
	/**
	 * The constructor for natural ecosystems.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param organismFactory The factory for an organism of species Species
	 */
	public ANaturalEcosystem(int generationSize, AOrganismFactory organismFactory) {
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
			this._currentGeneration.add((Species)this._organismFactory.makeOrganism());
		}
		
		return new GenerationInfo<Species>(this._generationNumber, info, this._currentGeneration);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final GenerationInfo<Species> nextGeneration() {
		// Template Design. All concrete natural ecosystems will follow this template.
		if (this._generationNumber < 0) {
			System.out.println("initialGeneration must be called before calling this method!");
			return GenerationInfo.errorGI;
		}
		
		this._generationNumber++;
		
		String analysis = analyzeCurrentGeneration();
		
		String newGenerationInfo = produceNextGeneration();
		
		String mutationInfo = mutateGeneration();
		
		String info = "Information about the old generation: " + analysis +
				"\nInformation about the new generation: " + newGenerationInfo +
				"\nInformation about the mutation: " + mutationInfo;
		
		return new GenerationInfo<Species>(this._generationNumber, info, this._currentGeneration);
	}
	
	/**
	 * Analyze the current generation and get any information needed to produce the next generation
	 * @return Info about the analysis
	 */
	protected abstract String analyzeCurrentGeneration();
	
	/**
	 * Produce the next generation. This should update the new generation to the current generation of this ecosystem.
	 * @return Info about the generation
	 */
	protected abstract String produceNextGeneration();
	
	/**
	 * Mutate the generation before returning it.
	 * @return Info about the mutation
	 */
	private final String mutateGeneration() {
		String mutationInfo = "";
		for (int i = 0; i < this._currentGeneration.size(); i++) {
			mutationInfo += this._currentGeneration.get(i).mutate() + "\n";
		}
		return mutationInfo;
	}
	
}
