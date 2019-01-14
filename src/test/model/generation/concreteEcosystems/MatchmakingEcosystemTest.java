package test.model.generation.concreteEcosystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.AOrganismFactory;
import main.model.generation.IOrganism;
import main.model.generation.ecosystems.MatchmakingEcosystem;

/**
 * Unit tests for MatchmakingEcosystem
 * 
 * @author jhwang73
 */
class MatchmakingEcosystemTest {
	
	MatchmakingEcosystem mmeco = new MatchmakingEcosystem(2, new AOrganismFactory() {

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
		assertEquals("MatchmakingEcosystem", mmeco.getEcosystemName());
	}

	@Test
	void testGetEcosystemRules() {
		assertEquals("This Ecosystem generates matchups. The best matchups advance and breed to make the new set of matchups.", mmeco.getEcosystemRules());
	}

}
