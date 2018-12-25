package main.model.generation.ecosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.organisms.FibonacciOrganism;

/**
 * An ecosystem which simulates a generation of the fibonacci sequence. This ecosystem does not need a factory.
 * 
 * @author jhwang73
 */
public class FibonacciEcosystem implements IEcosystem<FibonacciOrganism> {
	
	/**
	 * The name of this ecosystem.
	 */
	private static String _ecosystemName = "FibonacciEcosystem";
	
	/**
	 * The rules of this ecosystem.
	 */
	private static String _ecosystemRules = "This Ecosystem generates a fibonacci number sequence. Simply watch the sequence advance!";
	
	/**
	 * The iteration of the current generation.
	 */
	private int _generationNumber = -1;
	
	/**
	 * The size of the generation.
	 */
	private final int _generationSize;
	
	/**
	 * The current generation.
	 */
	private List<FibonacciOrganism> _currentGeneration;
	
	/**
	 * The factory for an organism of the species.
	 */
	private final AOrganismFactory<FibonacciOrganism> _foFactory;
	
	/**
	 * The name of the species in the ecosystem.
	 */
	private final String _speciesName;
	
	/**
	 * The Constructor for the fibonacci ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param foFactory The factory for a fibonacci organism
	 */
	public FibonacciEcosystem(int generationSize, AOrganismFactory<FibonacciOrganism> foFactory) {
		if (generationSize < 2)
			System.out.println("generation size must be at least 2!");
		this._generationSize = generationSize;
		this._foFactory = foFactory;
		this._speciesName = foFactory.getSpeciesName();
	}
	
	@Override
	public String getEcosystemName() {
		return _ecosystemName;
	}

	@Override
	public String getEcosystemRules() {
		return _ecosystemRules;
	}
	
	@Override
	public GenerationInfo<FibonacciOrganism> initialGeneration() {
		// Reset the variables
		this._generationNumber = 0;
		this._currentGeneration = new ArrayList<FibonacciOrganism>();
		
		for (int i = 0; i < this._generationSize; i++) {
			int value = 0;
			if (i == 0)
				value = 0;
			else if (i == 1)
				value = 1;
			else
				value = this.computeAddition();
			this._currentGeneration.add(new FibonacciOrganism(i, value));
		}
		
		return new GenerationInfo<FibonacciOrganism>(this._generationNumber, this._generationSize + 
				" " + this._speciesName + "(s) have been generated.", this._currentGeneration);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GenerationInfo<FibonacciOrganism> nextGeneration() {
		if (this._generationNumber < 0) {
			System.out.println("initialGeneration must be called before calling this method!");
			return GenerationInfo.errorGI;
		}
		this._generationNumber++;
		
		this._currentGeneration.add(new FibonacciOrganism(this._generationNumber + this._generationSize - 1, this.computeAddition()));
		this._currentGeneration.remove(0);
		
		return new GenerationInfo<FibonacciOrganism>(this._generationNumber, "The next number has been generated.",
				this._currentGeneration);
	}
	
	/**
	 * Compute f(n - 1) + f(n - 2)
	 * @return The value
	 */
	private int computeAddition() {
		int currentSize = this._currentGeneration.size();
		return this._currentGeneration.get(currentSize - 1).getValue() + this._currentGeneration.get(currentSize - 2).getValue();
	}

}
