package main.model.generation.ecosystems;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import main.model.generation.AOrganismFactory;
import main.model.generation.organisms.IFightingOrganism;

/**
 * The fighting ecosystem. In this ecosystem, organisms battle and the strongest organisms determine
 * the makeup of the following generation.
 * 
 * @author jhwang73
 */
public class FightingEcosystem extends ANaturalEcosystem {
	
	/**
	 * The name of this ecosystem.
	 */
	public final static String _ecosystemName = "FightingEcosystem";
	
	/**
	 * The rules of this ecosystem.
	 */
	private final static String _ecosystemRules = "This Ecosystem simulates fights. The strongest organisms advance and breed to make the new generation.";
	
	/**
	 * The class of the species required by this ecosystem.
	 */
	public final static Class<IFightingOrganism> _requiredOrganismClass = IFightingOrganism.class;
	
	/**
	 * The range of indicies. Used to select unique, random indicies from a list.
	 */
	private List<Integer> _range;
	
	/**
	 * A list of Fighter organisms. Every time an organism wins a battle, the organism is added to this list.
	 * The list determines the how likely an organism is reproduced.
	 */
	private List<IFightingOrganism> _battleResults;
		
	/**
	 * The random which selects the organisms that will reproduce.
	 */
	private Random _reproducer;
	
	/**
	 * The constructor for the fighting ecosystem.
	 * @param generationSize The size of the generation. Must be at least 2
	 * @param organismFactory The factory for a fighter type organism
	 */
	public FightingEcosystem(int generationSize, AOrganismFactory organismFactory) {
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
	
	@Override
	protected void setUp() {
		this._range = new ArrayList<>();
		for (int i = 0; i < this._generationSize; i++) {
			this._range.add(i);
		}
		
		this._reproducer = new Random();
	}
	
	/**
	 * Return a string in the format of
	 * this._speciesName + " " + idx1 + ": " + name1 + " " + relationship + " " + this._speciesName + " " + idx2 + ": " + name2 + ".\n"
	 * @param name1 The first name
	 * @param idx1 The first index
	 * @param name2 The second name
	 * @param idx2 The second index
	 * @param relationship The relationship between them
	 * @return The complete string
	 */
	private String result(String name1, int idx1, String name2, int idx2, String relationship) {
		return this._speciesName + " " + idx1 + ": " + name1 + " " + relationship + " " + this._speciesName + " " + idx2 + ": " + name2 + ".\n";
	}
	
	@Override
	public String analyzeCurrentGeneration() {
		this._battleResults = new ArrayList<>();
		int numBattles = this._generationSize + (int)(Math.random() * this._generationSize);
		String results = numBattles + " battles were fought.\n";
		
		for (int i = 0; i < numBattles; i++) {
			Collections.shuffle(this._range);
			int idx1 = this._range.get(0);
			int idx2 = this._range.get(1);
			IFightingOrganism fighter1 = (IFightingOrganism)this._currentGeneration.get(idx1);
			IFightingOrganism fighter2 = (IFightingOrganism)this._currentGeneration.get(idx2);
			
			int battleResult = fighter1.fight(fighter2); 
			if (battleResult == 1) {
				this._battleResults.add(fighter1);
				results += this.result(fighter1.getName(), idx1, fighter2.getName(), idx2, "defeated");
			} else if (battleResult == 0) {
				results += this.result(fighter1.getName(), idx1, fighter2.getName(), idx2, "tied with");
			} else {
				this._battleResults.add(fighter2);
				results += this.result(fighter1.getName(), idx1, fighter2.getName(), idx2, "was defeated by");
			}
		}
		
		if (this._battleResults.size() == 0)
			this._currentGeneration.forEach(co -> this._battleResults.add((IFightingOrganism)co));
		
		return results;
	}
	
	@Override
	public String produceNextGeneration() {
		List<IFightingOrganism> newGeneration = new ArrayList<>();
		String results = "";
		
		for (int i = 0; i < this._generationSize; i++) {
			double change = Math.random();
			if (change < 0.05) {
				IFightingOrganism randomOrganism = (IFightingOrganism)this._organismFactory.makeRandomOrganism();
				results += randomOrganism.getName() + " has been randomly produced.\n";
				newGeneration.add(randomOrganism);
			} else if (change < 0.75 && !this._battleResults.isEmpty()) {
				IFightingOrganism oldOrganism = (IFightingOrganism)this._battleResults.get(this._reproducer.nextInt(this._battleResults.size()));
				results += oldOrganism.getName() + " has survived to the next generation.\n";
				newGeneration.add(oldOrganism);
				while (this._battleResults.remove(oldOrganism));
			} else {
				IFightingOrganism oldOrganism = (IFightingOrganism)this._currentGeneration.get(this._reproducer.nextInt(this._generationSize));
				IFightingOrganism childOrganism = (IFightingOrganism)oldOrganism.reproduce();
				results += childOrganism.getName() + " has been reproduced from " + oldOrganism.getName() + "\n";
				newGeneration.add(childOrganism);
			}
		}
		
		this._currentGeneration = new ArrayList<>();
		this._currentGeneration.addAll(newGeneration);
		
		return results;
	}
	
}
