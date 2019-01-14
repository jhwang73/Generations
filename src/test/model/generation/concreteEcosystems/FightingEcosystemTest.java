package test.model.generation.concreteEcosystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.AOrganismFactory;
import main.model.generation.IOrganism;
import main.model.generation.ecosystems.FightingEcosystem;

/**
 * Unit tests for FightingEcosystem
 * 
 * @author jhwang73
 */
class FightingEcosystemTest {

	FightingEcosystem feco = new FightingEcosystem(2, new AOrganismFactory() {

		@Override
		public String getSpeciesName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IOrganism makeRandomOrganism() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Class<? extends IOrganism> getOrganismClass() {
			// TODO Auto-generated method stub
			return null;
		}
		
	});
	
	@Test
	void testGetEcosystemName() {
		assertEquals("FightingEcosystem", feco.getEcosystemName());
	}

	@Test
	void testGetEcosystemRules() {
		assertEquals("This Ecosystem simulates fights. The strongest organisms advance and breed to make the new generation.", feco.getEcosystemRules());
	}

}
