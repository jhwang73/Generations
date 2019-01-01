package main.model.generation.ecosystems;

import main.model.generation.AOrganismFactory;
import main.model.generation.organisms.IFightingOrganism;

/**
 * The fighting ecosystem. In this ecosystem, organisms battle and the strongest organisms determine
 * the makeup of the following generation.
 * 
 * @author jhwang73
 * @param <Fighter> The species of the fighting type organism
 */
public class FightingEcosystem<Fighter extends IFightingOrganism> extends ANaturalEcosystem<Fighter> {
	
	/**
	 * The name of this ecosystem.
	 */
	private static String _ecosystemName = "FightingEcosystem";
	
	/**
	 * The rules of this ecosystem.
	 */
	private static String _ecosystemRules = "This Ecosystem simulates fights. The strongest organisms advance and breed to make the new generation.";
	
	/**
	 * The constructor for the fighting ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2.
	 * @param organismFactory The factory for a fighter type organism
	 */
	public FightingEcosystem(int generationSize, AOrganismFactory<Fighter> organismFactory) {
		super(generationSize, organismFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getEcosystemName() {
		return _ecosystemName;
	}
	
	@Override
	public String getEcosystemRules() {
		return _ecosystemRules;
	}
	
	@Override
	public String analyzeCurrentGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String produceNextGeneration() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
