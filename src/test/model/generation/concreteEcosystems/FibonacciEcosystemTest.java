package test.model.generation.concreteEcosystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.concreteEcosystems.FibonacciEcosystem;
import main.model.generation.concreteOrganisms.FibonacciOrganism;
import main.model.generation.*;

/**
 * Unit tests for FibonacciEcosystem
 * 
 * @author jhwang73
 */
class FibonacciEcosystemTest {

	/**
	 * Test getEcosystemInfo
	 */
	@Test
	void testGetEcosystemInfo() {
		FibonacciEcosystem fe = new FibonacciEcosystem(2, new AOrganismFactory<FibonacciOrganism>() {
			@Override
			public String getSpeciesName() {
				return "Fibonacci Organism";
			}

			@Override
			public FibonacciOrganism makeOrganism() {
				return new FibonacciOrganism(0, 0);
			}
		});
		assertEquals("This Ecosystem generates a fibonacci number sequence. Simply watch the sequence advance!", fe.getEcosystemInfo());
	}

	/**
	 * Test initialGeneration
	 */
	@Test
	void testInitialGeneration() {
		FibonacciEcosystem fe = new FibonacciEcosystem(2, new AOrganismFactory<FibonacciOrganism>() {
			@Override
			public String getSpeciesName() {
				return "Fibonacci Organism";
			}

			@Override
			public FibonacciOrganism makeOrganism() {
				return new FibonacciOrganism(0, 0);
			}
		});
//		fe.initialGeneration();
	}

	/**
	 * Test nextGeneration
	 */
	@Test
	void testNextGeneration() {
		fail("Not yet implemented");
	}

	/**
	 * Test computeAddition
	 */
	@Test
	void testComputeAddition() {
		fail("Not yet implemented");
	}

}
