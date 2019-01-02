package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * The Fibonacci organism. Holds the index in the sequence as well that value.
 * 
 * @author jhwang73
 */
public class FibonacciOrganism implements IOrganism {
	
	/**
	 * The index in the sequence.
	 */
	private final int _index;
	/**
	 * The integer value.
	 */
	private final int _value;
	/**
	 * The name of the species of this organism.
	 */
	public final static String _speciesName = "FibonacciOrganism";
	/**
	 * The name of the organism
	 */
	private String _name;
	
	/**
	 * The constructor of the Fibonacci organism. Starts at 0, 1. 0 is the 0th number, 1 is the 1st number.
	 * @param index the index
	 * @param value the value
	 */
	public FibonacciOrganism(int index, int value) {
		this._index = index;
		this._value = value;
		this._name = index + "th Fibonacci Number";
	}
	
	@Override
	public String getSpeciesName() {
		return _speciesName;
	}

	@Override
	public String getName() {
		return this._name;
	}
	
	@Override
	public String toString() {
		return this.getName() + "\nIndex: " + this._index + "\nValue: " + this._value;
	}
	
	/**
	 * Get the index
	 * @return The index
	 */
	public final int getIndex() {
		return _index;
	}
	
	/**
	 * Get the value
	 * @return The value
	 */
	public final int getValue() {
		return _value;
	}
	
}
