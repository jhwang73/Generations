package main.model.generation.ecosystems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import main.model.generation.AOrganismFactory;
import main.model.generation.organisms.AMatchupOrganism;
import main.model.generation.organisms.INaturalOrganism;

/**
 * The matchmaking ecosystem. In this ecosystem, matchup organisms are graded in their fairness and
 * the fairest matchups will breed and advance the generations.
 * 
 * @author jasonhwang
 */
public class MatchmakingEcosystem extends ANaturalEcosystem {
	
	/**
	 * A generic typed Pair class
	 * @author jasonhwang
	 *
	 * @param <K> The type of key
	 * @param <V> The type of Value
	 */
	public class Pair<K, V> {
		private K _key;
		
		private V _value;
		
		public Pair(K key, V value) {
			this._key = key;
			this._value = value;
		}
		
		public K getKey() {
			return this._key;
		}
		
		public V getValue() {
			return this._value;
		}
	}
	
	public interface Player {
		/**
		 * Get the skill level of the player
		 * @return The skill level of the player
		 */
		public int getSkillLevel();
	}

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
	private List<Pair<AMatchupOrganism, Integer>> _rankings;
	
	/**
	 * The custom sorter which sorts a list of Pair elements.
	 * Smaller values are "greater" than bigger values.
	 */
	@SuppressWarnings("rawtypes")
	private Comparator<Pair<AMatchupOrganism, Integer>> _PairSorter;
	
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
		this._PairSorter = new Comparator<Pair<AMatchupOrganism, Integer>>() {
			@Override
			public int compare(Pair<AMatchupOrganism, Integer> o1, Pair<AMatchupOrganism, Integer> o2) {
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
			this._rankings.add(new Pair<AMatchupOrganism, Integer>(muorganism, muorganism.score()));
		});
		
		this._rankings.sort(this._PairSorter);
		
		for (int i = 0; i < this._generationSize; i++) {
			Pair<AMatchupOrganism, Integer> Pair = this._rankings.get(i);
			analysis += Pair.getKey().getName() + " - Difference between teams: " + this._rankings.get(i).getValue() + "\n";
		}
		
		return analysis;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected String produceNextGeneration() {
		this._currentGeneration = new ArrayList<>();
		int numParents = (this._generationSize / 4) + 2;
		String production = "";
		
		for (int i = 0; i < this._generationSize; i++) {
			AMatchupOrganism parent1 = this._rankings.get((int)(Math.random() * numParents)).getKey();
			AMatchupOrganism parent2 = this._rankings.get((int)(Math.random() * numParents)).getKey();
			INaturalOrganism child = (INaturalOrganism)parent1.reproduce(parent2);
			production += parent1.getName() + " and " + parent2.getName() + " produced " + child.getName() + "\n";
			this._currentGeneration.add(child);
		}
		
		return production;
	}
}
