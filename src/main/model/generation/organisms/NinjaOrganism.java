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
	public enum Ninja {
		
		NARUTO(50);
		
		/**
		 * The chakra level of the ninja
		 */
		private int _chakraLevel;
		
		/**
		 * The constructor for the Ninja
		 * @param chakraLevel The chakra level of the ninja
		 */
		private Ninja(int chakraLevel) {
			
		}
		
		/**
		 * Get the chakra level of the ninja
		 * @return The int of the chakra level
		 */
		public int getChakraLevel() {
			return this._chakraLevel;
		}
		
	}
	
	public NinjaOrganism() {
		
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public IOrganism reproduce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fight(IOrganism opponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
