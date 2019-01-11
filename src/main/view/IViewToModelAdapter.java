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
	@SuppressWarnings("rawtypes")
	public static final IViewToModelAdapter NULL_ADAPTER = new IViewToModelAdapter() {

		@Override
		public void quit() {
		}

		@Override
		public void begin(Object species, Object ecosystem, int generationSize) {
		}

		@Override
		public void nextGeneration() {
		}

		@Override
		public List getAvailableSpecies(Object ecosystem) {
			return null;
		}

		@Override
		public List getAvailableEcosystems() {
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
	 * @param generationSize The size of the generations
	 */
	public void begin(Species species, Ecosystem ecosystem, int generationSize);
	
	/**
	 * Advance to the next generation.
	 */
	public void nextGeneration();
	
	/**
	 * Get all the available species for the selected ecosystem.
	 * @param ecosystem The selected ecosystem
	 * @return The list of available species for the selected ecosystem
	 */
	public List<Species> getAvailableSpecies(Ecosystem ecosystem);
	
	/**
	 * Get all the available ecosystems.
	 * @return The list of available ecosystems
	 */
	public List<Ecosystem> getAvailableEcosystems();
	
}
