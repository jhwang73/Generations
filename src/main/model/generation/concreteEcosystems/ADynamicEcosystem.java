package main.model.generation.concreteEcosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.AOrganismFactory;
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
	 * The name of the ecosystem.
	 */
	protected String _ecosystemName;
	
	/**
	 * The rules of the ecosystem.
	 */
	protected String _ecosystemRules;
	
	/**
	 * Other information about the ecosystem.
	 */
	protected String _ecosystemOtherInfo;
	
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
		this._generationSize = generationSize;
		this._organismFactory = organismFactory;
		this._speciesName = organismFactory.getSpeciesName();
	}
	
	@Override
	public final String getEcosystemInfo() {
		return "Ecosystem Name: " + this._ecosystemName +
			   "\nRules: " + this._ecosystemRules +
			   "\nOther Info" + this._ecosystemOtherInfo;
	}
	
}
