package main.view;

import java.util.List;

/**
 * The adapter from the view to the model.
 * 
 * @author jhwang73
 * @param <Species> The species
 * @param <Ecosystem> The ecosystem
 */
public interface IViewToModelAdapter<Species, Ecosystem> {
	
	/**
	 * The no-op adapter.
	 */
	public static final IViewToModelAdapter NULL_ADAPTER = new IViewToModelAdapter() {

		@Override
		public void quit() {
			// TODO Auto-generated method stub
		}

		@Override
		public void begin(Object species, Object ecosystem) {
			// TODO Auto-generated method stub
		}

		@Override
		public void nextGeneration() {
			// TODO Auto-generated method stub
		}

		@Override
		public List getAvailableSpecies() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List getAvailableEcosystems(Object species) {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	/**
	 * Quit the system
	 */
	public void quit();
	
	/**
	 * Begin the selected ecosystem with the selected species.
	 * @param species The species
	 * @param ecosystem The ecosystem
	 */
	public void begin(Species species, Ecosystem ecosystem);
	
	/**
	 * Advance to the next generation.
	 */
	public void nextGeneration();
	
	/**
	 * Get all the available species.
	 * @return The list of available species
	 */
	public List<Species> getAvailableSpecies();
	
	/**
	 * Get all the available ecosystems for the selected species.
	 * @param species The selected species
	 * @return The list of available ecosystems for the selected species
	 */
	public List<Ecosystem> getAvailableEcosystems(Species species);
	
}
