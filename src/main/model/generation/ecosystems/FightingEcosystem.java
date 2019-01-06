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
 * @param <Fighter> The species of the fighting type organism
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
	 * @param generationSize The size of the generation. Must be at least 2.
	 * @param organismFactory The factory for a fighter type organism
	 */
	public FightingEcosystem(int generationSize, AOrganismFactory organismFactory) {
		super(generationSize, organismFactory);
	}
	
	@Override
	protected void setUp() {
		this._range = new ArrayList<>();
		for (int i = 0; i < this._generationSize; i++) {
			this._range.add(i);
		}
		
		this._reproducer = new Random();
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
		this._battleResults = new ArrayList<>();
		int numBattles = (int)(2 * Math.random() * this._generationSize) + 8;
		String results = numBattles + " battles were fought.";
		
		for (int i = 0; i < numBattles; i++) {
			Collections.shuffle(this._range);
			int idx1 = this._range.get(0);
			int idx2 = this._range.get(1);
			IFightingOrganism fighter1 = (IFightingOrganism)this._currentGeneration.get(idx1);
			IFightingOrganism fighter2 = (IFightingOrganism)this._currentGeneration.get(idx2);
			
			if (fighter1.fight(fighter2)) {
				this._battleResults.add(fighter1);
				results += this._speciesName + " " + idx1 + ": " + fighter1.getName() + " defeated " + this._speciesName + " " + idx2 + ": " + fighter2.getName() + ".\n";
			}
		}
		
		return results;
	}
	
	@Override
	public String produceNextGeneration() {
		List<IFightingOrganism> newGeneration = new ArrayList<>();
		String results = this._generationSize + " new " + this._speciesName + "s have been produced.";
		int size = this._battleResults.size();
		
		for (int i = 0; i < this._generationSize; i++) {
			IFightingOrganism newOrganism = (IFightingOrganism)this._battleResults.get(this._reproducer.nextInt(size)).reproduce();
			results += newOrganism.getName() + " has been produced!\n";
			newGeneration.add(newOrganism);
		}
		
		this._currentGeneration = new ArrayList<>();
		this._currentGeneration.addAll(newGeneration);
		
		return results;
	}
	
}
