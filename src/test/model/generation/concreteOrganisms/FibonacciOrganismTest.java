package test.model.generation.concreteOrganisms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.organisms.FibonacciOrganism;

/**
 * Unit tests for FibonacciOrganism
 * 
 * @author jhwang73
 */
class FibonacciOrganismTest {
	
	/**
	 * The 1st Fibonacci Organism of value 1
	 */
	private final FibonacciOrganism fo1_1 = new FibonacciOrganism(1, 1);

	/**
	 * Test displayAsString
	 */
	@Test
	void testDisplayAsString() {
		assertEquals("1th Fibonacci Number\nIndex: 1\nValue: 1", fo1_1.toString());
	}
}