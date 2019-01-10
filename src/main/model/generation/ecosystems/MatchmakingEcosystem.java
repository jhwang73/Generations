package main.model.generation.ecosystems;

import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.organisms.AMatchupOrganism;

/**
 * The matchmaking ecosystem. In this ecosystem, matchup organisms are graded in their fairness and
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
	private final static String _ecosystemRules = "This Ecosystem generates matchups. The best matchups advance and breed to make the new set of matchups.";
	
	/**
	 * The class of the species required by this ecosystem.
	 */
	@SuppressWarnings("rawtypes")
	public final static Class<AMatchupOrganism> _requiredOrganismClass = AMatchupOrganism.class;
	
	/**
	 * The score of every organism in the current generation, sorted in descending order.
	 */
	@SuppressWarnings("rawtypes")
	private List<Entry<AMatchupOrganism, Integer>> _rankings;
	
	/**
	 * The custom sorter which sorts a list of Entry elements.
	 * Smaller values are "greater" than bigger values.
	 */
	@SuppressWarnings("rawtypes")
	private Comparator<Entry<AMatchupOrganism, Integer>> _entrySorter;
	
	/**
	 * The constructor for the matchmaking ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param organismFactory The factory for a matchup type organism
	 */
	public MatchmakingEcosystem(int generationSize, AOrganismFactory organismFactory) {
		super(generationSize, organismFactory);
	}
	
	@Override
	public String getEcosystemName() {
		return _ecosystemName;
	}

	@Override
	public String getEcosystemRules() {
		return _ecosystemRules;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void setUp() {
		this._entrySorter = new Comparator<Entry<AMatchupOrganism, Integer>>() {
			@Override
			public int compare(Entry<AMatchupOrganism, Integer> o1, Entry<AMatchupOrganism, Integer> o2) {
				if (o1.getValue() > o2.getValue()) {
					return 1;
				} else if (o1.getValue() == o2.getValue()) {
					return 0;
				} else {
					return -1;
				}
			}
		};
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected String analyzeCurrentGeneration() {
		String analysis = "";
		this._rankings = new ArrayList<>();
		
		this._currentGeneration.forEach((organism) -> {
			AMatchupOrganism muorganism = (AMatchupOrganism)organism;
			this._rankings.add(Map.entry(muorganism, muorganism.score()));
		});
		
		this._rankings.sort(this._entrySorter);
		
		for (int i = 0; i < this._generationSize; i++) {
			Entry<AMatchupOrganism, Integer> entry = this._rankings.get(i);
			analysis += entry.getKey().getName() + " - Difference between teams: " + this._rankings.get(i).getValue() + "\n";
		}
		
		return analysis;
	}
	
	@Override
	protected String produceNextGeneration() {
		this._currentGeneration = new ArrayList<>();
		this._rankings.forEach((e) -> {
			this._currentGeneration.add(e.getKey());
		});
		
		return "Produce Test";
	}
}
