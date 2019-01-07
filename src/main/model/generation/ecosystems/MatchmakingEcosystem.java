package main.model.generation.ecosystems;

import main.model.generation.AOrganismFactory;

/**
 * The matchmaking ecosystem. In this ecosystem, organisms are graded in their fairness and
 * the fairest matchups will breed and advance the generations.
 * 
 * @author jasonhwang
 */
public class MatchmakingEcosystem extends ANaturalEcosystem {

	/**
	 * The name of this ecosystem.
	 */
	public final static String _ecosystemName = "MatchmakingEcosystem";
	
	/**
	 * The rules of this ecosystem.
	 */
	private final static String _ecosystemRules = "This Ecosystem generates matches. The best matches advance and breed to make the new set of matches.";
	
	/**
	 * The constructor for the matchmaking ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param organismFactory The factory for a match type organism
	 */
	public MatchmakingEcosystem(int generationSize, AOrganismFactory organismFactory) {
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
	protected void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String analyzeCurrentGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String produceNextGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
