package main.model.generation.concreteEcosystems;

import java.util.List;

import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.concreteOrganisms.FibonacciOrganism;

/**
 * An ecosystem which simulates a generation of the fibonacci sequence.
 * 
 * @author jhwang73
 */
public class FibonacciEcosystem implements IEcosystem {
	
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
	 * @param generationSize The size of the generation
	 */
	public FibonacciEcosystem(int generationSize) {
		this._generationSize = generationSize;
		this._generationNumber = 0;
	}

	@Override
	public String getEcosystemInfo() {
		return "This Ecosystem generates a fibonacci number sequence. Simply watch the sequence advance!";
	}

	@Override
	public GenerationInfo initialGeneration() {
		
		return new GenerationInfo(this._generationNumber, "The first " + this._generationSize + 
				"numbers have been generated.", null);
	}

	@Override
	public GenerationInfo nextGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
