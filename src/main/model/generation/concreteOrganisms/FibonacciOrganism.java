package main.model.generation.concreteOrganisms;

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
	private int _index;
	
	/**
	 * The integer value.
	 */
	private int _value;
	
	/**
	 * The constructor of the Fibonacci organism. Starts at 0, 1. 0 is the 0th number, 1 is the 1st number.
	 * @param index the index
	 * @param value the value
	 */
	public FibonacciOrganism(int index, int value) {
		this._index = index;
		this._value = value;
	}
	
	@Override
	public String displayAsString() {
		return "Index: " + this._index + "\nValue: " + this._value;
	}
	
}
