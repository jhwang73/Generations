package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * The ninja organism. Based off Masashi Kishimoto's series, Naruto.
 * @author jasonhwang
 *
 */
public class NinjaOrganism implements IFightingOrganism {

	/**
	 * The Ninja enmeration. Defines the database of available ninjas and their traits.
	 * @author jasonhwang
	 *
	 */
	public enum NinjaProperties {
		
		NARUTO(50);
		
		/**
		 * The chakra level of the ninja
		 */
		private int _chakraLevel;
		
		/**
		 * The constructor for the Ninja properties
		 * @param chakraLevel The chakra level of the ninja
		 */
		private NinjaProperties(int chakraLevel) {
			this._chakraLevel = chakraLevel;
		}
		
		/**
		 * Get the chakra level of the ninja
		 * @return The int of the chakra level
		 */
		public int getChakraLevel() {
			return this._chakraLevel;
		}
		
		/**
		 * Update the chakra level of the ninja
		 * @param chakraLevel The new chakra level
		 */
		public void setChakraLevel(int chakraLevel) {
			this._chakraLevel = chakraLevel;
		}
		
	}
	
	/**
	 * The probability activating/deactivating sage mode.
	 */
	private final static double SAGE_MODE_PROBABILITY = 0.1;
	
	/**
	 * Whether the user is at sage mode or not.
	 */
	private boolean _sageMode;
	
	/**
	 * The properties of the ninja.
	 */
	private NinjaProperties _properties;
		
	public NinjaOrganism(NinjaProperties properties) {
		this._properties = properties;
		this._sageMode = false;
	}
	
	@Override
	public String toString() {
		return this.getName() + "\n" + this.getChakraLevel();
	}
	
	@Override
	public IOrganism reproduce() {
		return new NinjaOrganism(this._properties);
	}

	@Override
	public String mutate() {
		double sageMode = Math.random();
		String mutationInfo;
		
		if (sageMode < SAGE_MODE_PROBABILITY) {
			this._sageMode = !this._sageMode;
			int sageModeDelta = 30;
			if (this._sageMode) {
				mutationInfo = "SAGE MODE!!!" + this.changeChakraLevel(true, sageModeDelta);
			}
			else {
				mutationInfo = "Sage mode ran out!" + this.changeChakraLevel(false, sageModeDelta);
			}
		} else {
			int maxDelta = 15;
			int delta = (int)Math.random() * maxDelta + 1;
			double increase = Math.random();
			if (increase < 0.5) {
				mutationInfo = this.changeChakraLevel(true, delta);
			} else {
				mutationInfo = this.changeChakraLevel(false, delta);
			}
		}
		
		return mutationInfo;
	}

	@Override
	public String getName() {
		return this._properties.name();
	}

	@Override
	public boolean fight(IOrganism opponent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Get the chakra level of the ninja organism.
	 * @return The int value of the chakra level
	 */
	public int getChakraLevel() {
		return this._properties.getChakraLevel();
	}
	
	/**
	 * Set the chakra level of the ninja
	 * @param chakraLevel The new chakra level
	 */
	private void setChakraLevel(int chakraLevel) {
		this._properties.setChakraLevel(chakraLevel);
	}
	
	/**
	 * Change the chakra level of the ninja. Set to 1 if it would go below 1.
	 * @param increase Whether to increase the chakra or decrease it
	 * @param delta The amount to change
	 * @return A description of the change that took place.
	 */
	private String changeChakraLevel(boolean increase, int delta) {
		if (increase) {
			this.setChakraLevel(this.getChakraLevel() + delta);
			return "Chakra increased by " + delta;
		}
		else {
			int originalChakra = this.getChakraLevel();
			this.setChakraLevel(Math.min(1, this.getChakraLevel() - delta));
			return "Chakra decreased by " + (this.getChakraLevel() - originalChakra);
		}
	}

}
