package test.model.generation.concreteEcosystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.organisms.FibonacciOrganism;
import main.model.generation.*;
import main.model.generation.ecosystems.FibonacciEcosystem;

/**
 * Unit tests for FibonacciEcosystem
 * 
 * @author jhwang73
 */
class FibonacciEcosystemTest {
	
	@Test
	void testInitialGeneration() {
		FibonacciEcosystem fe = new FibonacciEcosystem(2, new AOrganismFactory() {
			@Override
			public String getSpeciesName() {
				return "Fibonacci";
			}

			@Override
			public FibonacciOrganism makeRandomOrganism() {
				return new FibonacciOrganism(0, 0);
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return FibonacciOrganism.class;
			}
		});
		
		GenerationInfo gi = fe.initialGeneration();
		
		assertEquals(0, gi.getGenerationNumber());
		assertEquals("2 Fibonacci(s) have been generated.", gi.getInfo());
		assertEquals(2, gi.getGeneration().size());
		
		FibonacciOrganism fo0 = (FibonacciOrganism) gi.getGeneration().get(0);
		assertEquals(0, fo0.getIndex());
		assertEquals(0, fo0.getValue());
		
		FibonacciOrganism fo1 = (FibonacciOrganism) gi.getGeneration().get(1);
		assertEquals(1, fo1.getIndex());
		assertEquals(1, fo1.getValue());
	}

	@Test
	void testNextGeneration() {
		FibonacciEcosystem fe = new FibonacciEcosystem(4, new AOrganismFactory() {
			@Override
			public String getSpeciesName() {
				return "Fibonacci";
			}

			@Override
			public FibonacciOrganism makeRandomOrganism() {
				return new FibonacciOrganism(0, 0);
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return FibonacciOrganism.class;
			}
		});
		
		fe.initialGeneration();
		GenerationInfo gi = fe.nextGeneration();
		
		assertEquals(1, gi.getGenerationNumber());
		assertEquals("The next number has been generated.", gi.getInfo());
		assertEquals(4, gi.getGeneration().size());
		
		FibonacciOrganism fo1 = (FibonacciOrganism)gi.getGeneration().get(0);
		assertEquals(1, fo1.getIndex());
		assertEquals(1, fo1.getValue());
		
		FibonacciOrganism fo2 = (FibonacciOrganism)gi.getGeneration().get(1);
		assertEquals(2, fo2.getIndex());
		assertEquals(1, fo2.getValue());
		
		FibonacciOrganism fo3 = (FibonacciOrganism)gi.getGeneration().get(2);
		assertEquals(3, fo3.getIndex());
		assertEquals(2, fo3.getValue());
		
		FibonacciOrganism fo4 = (FibonacciOrganism)gi.getGeneration().get(3);
		assertEquals(4, fo4.getIndex());
		assertEquals(3, fo4.getValue());
	}
	
}
