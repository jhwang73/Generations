package test.model.generation.concreteEcosystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.ecosystems.ANaturalEcosystem;
import main.model.generation.*;

class ANaturalEcosystemTest {
	
	ANaturalEcosystem ne = new ANaturalEcosystem(3, new AOrganismFactory() {

		@Override
		public String getSpeciesName() {
			return "Test Species";
		}

		@Override
		public IOrganism makeRandomOrganism() {
			return new IOrganism() {

				@Override
				public String getSpeciesName() {
					return "Test Species";
				}

				@Override
				public String getName() {
					return "Test Organism";
				}
			};
		}

		@Override
		public Class<? extends IOrganism> getOrganismClass() {
			return null;
		}
		
	}) {

		@Override
		public String getEcosystemName() {
			return "Test Ecosystem";
		}

		@Override
		public String getEcosystemRules() {
			return "Test Ecosystem Rules";
		}

		@Override
		protected void setUp() {
			
		}

		@Override
		protected String analyzeCurrentGeneration() {
			return "Test analysis";
		}

		@Override
		protected String produceNextGeneration() {
			return "Test Production";
		}	
	};

	@Test
	void testANaturalEcosystem() {
		assertEquals("Test Ecosystem", ne.getEcosystemName());
		assertEquals("Test Ecosystem Rules", ne.getEcosystemRules());
	}

}
