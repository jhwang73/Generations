package main.model;

import java.util.ArrayList;
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
	private final List<AOrganismFactory<?>> _species = new ArrayList<>();
	/**
	 * The map of available species' to their valid ecosystems.
	 */
	private final Map<AOrganismFactory<?>, List<AEcosystemFactory<?>>> _speciesToEcosystems = new HashMap<>();
	
	/**
	 * The Constructor for the model.
	 * @param m2vAdapter The adapter from the model to the view
	 */
	public Model(IModelToViewAdapter m2vAdapter) {
		this._m2vAdapter = m2vAdapter;
	}
	
	/**
	 * Populate the available species.
	 */
	private void populateSpecies() { 
		this._species.add(new AOrganismFactory<FibonacciOrganism>() {

			@Override
			public String getSpeciesName() {
				return FibonacciOrganism._speciesName;
			}

			@Override
			public FibonacciOrganism makeOrganism() {
				return new FibonacciOrganism(-1, -1);
			}

			@Override
			public Class<FibonacciOrganism> getOrganismClass() {
				return FibonacciOrganism.class;
			}
		
		});
		
	}
	
	/**
	 * Populate the available ecosystems for each available species.
	 */
	private void populateSpeciesToEcosystems() {
		this._species.forEach((s) -> {
			this._speciesToEcosystems.put(s, new ArrayList<>());
		});
		
		
		// Now, iterate thru each species, iterate thru each ecosystem (or other way around, figure it out
		
		
		List<AEcosystemFactory<?>> ecosystems = new ArrayList<>();
		ecosystems.add(new AEcosystemFactory<FibonacciOrganism>() {

			@Override
			public IEcosystem<FibonacciOrganism> makeEcosystem(int generationSize,
					AOrganismFactory<FibonacciOrganism> organismFactory) {
				return new FibonacciEcosystem(generationSize, organismFactory);
			}

			@Override
			public Class<FibonacciOrganism> getRequiredOrganismClass() {
				return FibonacciOrganism.class;
			}

			


			
		});
		
//		this._species.forEach((s) -> {
//			ecosystems.forEach((e) -> {
//				if (s.getOrganismClass().isAssignableFrom(ORGANISM ALLOWED)) {
//					THEN ADD TO THE LIST THAT THIS IS AN ALLOWABLE ECOSYSTEM
//				}
//			});
//		});
		
//		System.out.println(IEcosystem.class.isAssignableFrom(FibonacciEcosystem.class));

		
	}
	
	/**
	 * Start the model
	 */
	public void start() {
		this.populateSpecies();
		this.populateSpeciesToEcosystems();
	}
	
	/**
	 * Quit the model.
	 */
	public void quit() {
		System.exit(0);
	}
	
	/**
	 * Get the list of available species.
	 * @return The list of available species.
	 */
	public List<AOrganismFactory<?>> getAvailableSpecies() {
		return this._species;
	}
	
	/**
	 * Get all the available ecosystems for the selected species.
	 * @param species The selected species
	 * @return The list of available ecosystems for the selected species
	 */
	public List<AEcosystemFactory<?>> getAvailableEcosystems(AOrganismFactory<? extends IOrganism> species) {
		return this._speciesToEcosystems.get(species);
	}
	
	// TODO: use instanceOf() when determining which ecosystems are available for which species
	// TODO: generation size will be at least 2.
	
	/**
	 * Begin a new ecosystem with the species.
	 * @param species The species
	 * @param ecosystem The ecosystem
	 * @param generationSize The size of the generations
	 */
	public void beginNewEcosystem(AOrganismFactory<?> species, AEcosystemFactory<?> ecosystem, int generationSize) {
//		IEcosystem test = new FibonacciEcosystem();
//		ecosystem = new SurvivalEcosystem(species);
//		GenInfo = ecosystem.initialGeneration();
	}
}
