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
			public FibonacciOrganism makeRandomOrganism() {
				return new FibonacciOrganism(0, 0);
			}
		});
		
		GenerationInfo<FibonacciOrganism> gi = fe.initialGeneration();
		
		assertEquals(0, gi.getGenerationNumber());
		assertEquals("2 Fibonacci Organism(s) have been generated.", gi.getInfo());
		assertEquals(2, gi.getGeneration().size());
		
		assertEquals(0, gi.getGeneration().get(0).getIndex());
		assertEquals(0, gi.getGeneration().get(0).getValue());
		
		assertEquals(1, gi.getGeneration().get(1).getIndex());
		assertEquals(1, gi.getGeneration().get(1).getValue());
	}

	/**
	 * Test nextGeneration
	 */
	@Test
	void testNextGeneration() {
		FibonacciEcosystem fe = new FibonacciEcosystem(4, new AOrganismFactory<FibonacciOrganism>() {
			@Override
			public String getSpeciesName() {
				return "Fibonacci Organism";
			}

			@Override
			public FibonacciOrganism makeRandomOrganism() {
				return new FibonacciOrganism(0, 0);
			}
		});
		
		fe.initialGeneration();
		GenerationInfo<FibonacciOrganism> gi = fe.nextGeneration();
		
		assertEquals(1, gi.getGenerationNumber());
		assertEquals("The next number has been generated.", gi.getInfo());
		assertEquals(4, gi.getGeneration().size());
		
		System.out.println(gi.getGeneration().get(0).getIndex());
		
		assertEquals(1, gi.getGeneration().get(0).getIndex());
		assertEquals(1, gi.getGeneration().get(0).getValue());
		
		assertEquals(2, gi.getGeneration().get(1).getIndex());
		assertEquals(1, gi.getGeneration().get(1).getValue());
		
		assertEquals(3, gi.getGeneration().get(2).getIndex());
		assertEquals(2, gi.getGeneration().get(2).getValue());
		
		assertEquals(4, gi.getGeneration().get(3).getIndex());
		assertEquals(3, gi.getGeneration().get(3).getValue());
	}
	
}
