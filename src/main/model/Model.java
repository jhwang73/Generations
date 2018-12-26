package main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.model.generation.*;
import main.model.generation.ecosystems.*;
import main.model.generation.organisms.*;

/**
 * The model. The system does the backend operations here.
 * 
 * @author jhwang73
 */
public class Model {
	
	/**
	 * The adapter from the model to the view. Initialized to the no-op adapter.
	 */
	private IModelToViewAdapter _m2vAdapter = IModelToViewAdapter.NULL_ADAPTER;
	
	/**
	 * The map of available species' names to their classes.
	 */
	private final Map<String, Class<? extends IOrganism>> _species = new HashMap<>();
	/**
	 * The map of available species' to their valid ecosystems.
	 */
	private final Map<String, List<String>> _speciesToEcosystems = new HashMap<>();
	/**
	 * The map of available ecosystems to their classes.
	 */
	private final Map<String, Class<? extends IEcosystem<? extends IOrganism>>> _ecosystems = new HashMap<>();
	
	/**
	 * The Constructor for the model.
	 * @param m2vAdapter The adapter from the model to the view
	 */
	public Model(IModelToViewAdapter m2vAdapter) {
		this._m2vAdapter = m2vAdapter;
	}
	
	private void populateSpecies() { 
		this._species.put("FibonacciOrganism", FibonacciOrganism.class);
	}
	
	private void populateEcosystems() {
		
	}
	
	private void populateSpeciesToEcosystems() {
		
	}
	
	/**
	 * Start the model
	 */
	public void start() {
		this.populateSpecies();
		this.populateEcosystems();
		this.populateSpeciesToEcosystems();
	}
	
	/**
	 * Quit the model.
	 */
	public void quit() {
		System.exit(0);
	}
	
	public List<Object> getAvailableSpecies() {
		return null;
	}
	
	// TODO: use instanceOf() when determining which ecosystems are available for which species
	
	// TODO: generation size will be at least 2.
	
	public void beginNewEcosystem(Object species, Object ecosystem) {
//		System.out.println(IEcosystem.class.isAssignableFrom(FibonacciEcosystem.class));
//		IEcosystem test = new FibonacciEcosystem();
//		ecosystem = new SurvivalEcosystem(species);
//		GenInfo = ecosystem.initialGeneration();
	}
}
