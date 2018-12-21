package main.model.generation.concreteEcosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.concreteOrganisms.FibonacciOrganism;

/**
 * An ecosystem which simulates a generation of the fibonacci sequence. This ecosystem does not need a factory.
 * 
 * @author jhwang73
 */
public class FibonacciEcosystem implements IEcosystem<FibonacciOrganism> {
	
	/**
	 * The iteration of the current generation.
	 */
	private int _generationNumber;
	
	/**
	 * The size of the generation.
	 */
	private int _generationSize;
	
	/**
	 * The current generation.
	 */
	private List<FibonacciOrganism> _currentGeneration;
	
	/**
	 * The Constructor for the fibonacci ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2
	 */
	public FibonacciEcosystem(int generationSize) {
		if (generationSize < 2) {
			System.out.println("The size must be >= 2");
		}
		this._generationSize = generationSize;
		this._generationNumber = 0;
	}
	
	@Override
	public String getEcosystemInfo() {
		return "This Ecosystem generates a fibonacci number sequence. Simply watch the sequence advance!";
	}

	@Override
	public GenerationInfo<FibonacciOrganism> initialGeneration() {
		
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
		
		return new GenerationInfo<FibonacciOrganism>(this._generationNumber, "The first " + this._generationSize + 
				"numbers have been generated.", this._currentGeneration);
	}
	
	@Override
	public GenerationInfo<FibonacciOrganism> nextGeneration() {
		this._generationNumber++;
		
		this._currentGeneration.add(new FibonacciOrganism(this._generationNumber + this._generationSize - 1, this.computeAddition()));
		this._currentGeneration.remove(0);
		
		return new GenerationInfo<FibonacciOrganism>(this._generationNumber, "The next number has been generated",
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
