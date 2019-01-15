package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.model.generation.IOrganism;

/**
 * The ninja organism. Based off Masashi Kishimoto's series, Naruto.
 * 
 * @author jasonhwang
 */
public class NinjaOrganism implements IFightingOrganism {

	/**
	 * The Ninja enmeration. Defines the database of available ninjas and their traits.
	 * @author jasonhwang
	 */
	public enum Ninja {
		
		NARUTO(50),
		SASUKE(50),
		HASHIRAMA(80),
		MADARA(75),
		ROCKLEE(50);
		
		/**
		 * The base chakra level of the ninja
		 */
		private int _baseChakraLevel;
		
		/**
		 * The constructor for the Ninja
		 * @param baseChakraLevel The base chakra level of the ninja
		 */
		private Ninja(int baseChakraLevel) {
			this._baseChakraLevel = baseChakraLevel;
		}
		
		/**
		 * Get the base chakra level of the ninja
		 * @return The int of the base chakra
		 */
		public int getBaseChakra() {
			return this._baseChakraLevel;
		}
		
	}
	
	/**
	 * The name of the species of this organism.
	 */
	public final static String _speciesName = "Ninja";
	
	/**
	 * The list of available ninja.
	 */
	private final static List<Ninja> _availableNinjas = new ArrayList<>(Arrays.asList(Ninja.values()));
	
	/**
	 * The probability activating/deactivating sage mode.
	 */
	private final static double SAGE_MODE_PROBABILITY = 0.1;
	
	/**
	 * Whether the user is at sage mode or not.
	 */
	private boolean _sageMode;
	
	/**
	 * The ninja.
	 */
	private Ninja _ninja;
	
	/**
	 * Additional chakra the ninja has.
	 */
	private int _additionalChakra;
		
	/**
	 * The Constructor for the Ninja Organism
	 * @param ninja The identity of the ninja organism.
	 */
	public NinjaOrganism(Ninja ninja) {
		this._ninja = ninja;
		this._sageMode = false;
		this._additionalChakra = 0;
	}
	
	/**
	 * The Constructor for a random Ninja Organism.
	 */
	public NinjaOrganism() {
		int ninja = (int) (Math.random() * _availableNinjas.size());
		this._ninja = _availableNinjas.get(ninja);
		this._sageMode = false;
		this._additionalChakra = 0;
	}
	
	@Override
	public String toString() {
		return this.getName() + "\n" + (this.getChakraLevel());
	}
	
	@Override
	public IOrganism reproduce() {
		return new NinjaOrganism(this._ninja);
	}

	@Override
	public String mutate() {
		double sageMode = Math.random();
		String mutationInfo;
		
		if (!this._sageMode && sageMode < SAGE_MODE_PROBABILITY) {
			int sageModeDelta = 100;
			mutationInfo = this.getName() + " activated SAGE MODE!!! " + this.changeChakraLevel(true, sageModeDelta);
			this._sageMode = true;
		} else {
			int maxDelta = 50;
			int delta = (int)(Math.random() * maxDelta) + 1;
			mutationInfo = this.changeChakraLevel(true, delta);
		}
		return mutationInfo;
	}

	@Override
	public String getName() {
		if (this._sageMode)
			return "Sage " + this._ninja.name();
		else
			return this._ninja.name();
	}

	@Override
	public int fight(IOrganism opponent) {
		if (this.getChakraLevel() > ((NinjaOrganism)opponent).getChakraLevel())
			return 1;
		else if (this.getChakraLevel() < ((NinjaOrganism)opponent).getChakraLevel())
			return -1;
		else
			return 0;
	}
	
	/**
	 * Get the current chakra level of the ninja organism.
	 * @return The int value of the current chakra
	 */
	public int getChakraLevel() {
		return this._ninja.getBaseChakra() + this._additionalChakra;
	}
	
	/**
	 * Change the additional chakra level of the ninja.
	 * @param increase Whether to increase the chakra or decrease it
	 * @param delta The amount to change
	 * @return A description of the change that took place.
	 */
	private String changeChakraLevel(boolean increase, int delta) {
		if (increase) {
			this._additionalChakra += delta;
			return "Chakra increased by " + delta;
		}
		else {
			this._additionalChakra -= delta;
			return "Chakra decreased by " + delta;
		}
	}

}
