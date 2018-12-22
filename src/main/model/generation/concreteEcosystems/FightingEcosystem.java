package main.model.generation.concreteEcosystems;

import main.model.generation.AOrganismFactory;
import main.model.generation.concreteOrganisms.AFightingOrganism;

/**
 * The fighting ecosystem. In this ecosystem, organisms battle and the strongest organisms determine
 * the makeup of the following generation.
 * 
 * @author jhwang73
 * @param <Fighter> The species of the fighting type organism
 */
public class FightingEcosystem<Fighter extends AFightingOrganism<Fighter>> extends ADynamicEcosystem<Fighter> {

	/**
	 * The constructor for the fighting ecosystem.
	 * @param generationSize
	 * @param organismFactory
	 */
	public FightingEcosystem(int generationSize, AOrganismFactory<Fighter> organismFactory) {
		super(generationSize, organismFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getEcosystemName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEcosystemRules() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String analyzeCurrentGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String productNextGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
