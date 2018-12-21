package main.model.generation.concreteEcosystems;

import java.util.ArrayList;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.GenerationInfo;
import main.model.generation.IEcosystem;
import main.model.generation.IOrganism;
import main.model.generation.concreteOrganisms.FibonacciOrganism;

/**
 * An ecosystem which simulates a generation of the fibonacci sequence.
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
	 * @param generationSize The size of the generation
	 * @param fibonacciFactory The factory for a Fibonacci organism
	 */
	public FibonacciEcosystem(int generationSize, AOrganismFactory<FibonacciOrganism> fibonacciFactory) {
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
		
		
		return new GenerationInfo<FibonacciOrganism>(this._generationNumber, "The first " + this._generationSize + 
				"numbers have been generated.", this._currentGeneration);
	}

	@Override
	public GenerationInfo nextGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
