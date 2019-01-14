package test.model.generation.concreteOrganisms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.organisms.NinjaOrganism;

/**
 * Unit tests for NinjaOrganism
 * 
 * @author jhwang73
 */
class NinjaOrganismTest {
	
	NinjaOrganism naruto = new NinjaOrganism(NinjaOrganism.Ninja.NARUTO);
	NinjaOrganism sasuke = new NinjaOrganism(NinjaOrganism.Ninja.SASUKE);
	NinjaOrganism hashirama = new NinjaOrganism(NinjaOrganism.Ninja.HASHIRAMA);

	@Test
	void testToString() {
		assertEquals("NARUTO\n50", naruto.toString());
		assertEquals("SASUKE\n50", sasuke.toString());
	}

	@Test
	void testReproduce() {
		assertEquals("NARUTO\n50", naruto.reproduce().toString());
	}

	@Test
	void testGetName() {
		assertEquals("NARUTO", naruto.getName());
	}

	@Test
	void testFight() {
		assertEquals(-1, naruto.fight(hashirama));
	}

	@Test
	void testGetChakraLevel() {
		assertEquals(50, naruto.getChakraLevel());
	}

}
