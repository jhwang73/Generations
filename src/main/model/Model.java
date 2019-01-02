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
	 * The current ecosystem.
	 */
	private IEcosystem _ecosystem;
	/**
	 * The list of available species.
	 */
	private final List<AOrganismFactory> _species = new ArrayList<>();
	/**
	 * The list of available ecosystems.
	 */
	private final List<AEcosystemFactory> ecosystems = new ArrayList<>();
	/**
	 * The map of available species' to their valid ecosystems.
	 */
	private final Map<AOrganismFactory, List<AEcosystemFactory>> _speciesToEcosystems = new HashMap<>();
	
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
		_species.add(new AOrganismFactory() {

			@Override
			public String getSpeciesName() {
				return FibonacciOrganism._speciesName;
			}

			@Override
			public IOrganism makeOrganism() {
				return new FibonacciOrganism(-1, -1);
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return FibonacciOrganism.class;
			}
			
		});
		
	}
	
	/**
	 * Populate the available ecosystems.
	 */
	private void populateEcosystems() {
		ecosystems.add(new AEcosystemFactory() {

			@Override
			protected String getEcosystemName() {
				return FibonacciEcosystem._ecosystemName;
			}

			@Override
			public IEcosystem makeEcosystem(int generationSize, AOrganismFactory organismFactory) {
				return new FibonacciEcosystem(generationSize, organismFactory);
			}

			@Override
			public Class<? extends IOrganism> getRequiredOrganismClass() {
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

		this._species.forEach((s) -> {
			ecosystems.forEach((e) -> {
				if (s.getOrganismClass().isAssignableFrom(e.getRequiredOrganismClass())) {
					this._speciesToEcosystems.get(s).add(e);
				}
			});
		});
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
	
	/**
	 * Get the list of available species.
	 * @return The list of available species.
	 */
	public List<AOrganismFactory> getAvailableSpecies() {
		return this._species;
	}
	
	/**
	 * Get all the available ecosystems for the selected species.
	 * @param species The selected species
	 * @return The list of available ecosystems for the selected species
	 */
	public List<AEcosystemFactory> getAvailableEcosystems(AOrganismFactory species) {
		return this._speciesToEcosystems.get(species);
	}
		
	/**
	 * Begin a new ecosystem with the species.
	 * @param species The species
	 * @param ecosystem The ecosystem
	 * @param generationSize The size of the generations. At least 2
	 */
	public void beginNewEcosystem(AOrganismFactory species, AEcosystemFactory ecosystem, int generationSize) {
		if (generationSize < 2)
			return;
		
		this._ecosystem = ecosystem.makeEcosystem(generationSize, species);
		
		GenerationInfo initialGI = this._ecosystem.initialGeneration();
		
		this._m2vAdapter.displayText(initialGI.getInfo());
		this._m2vAdapter.setGeneration(initialGI.getGenerationNumber());
		this._m2vAdapter.displayGeneration(initialGI.getGeneration());
	}
	
	/**
	 * Advance to the next generation in the current ecosystem.
	 */
	public void nextGeneration() {
		GenerationInfo nextGI = this._ecosystem.nextGeneration();
		this._m2vAdapter.displayText(nextGI.getInfo());
		this._m2vAdapter.setGeneration(nextGI.getGenerationNumber());
		this._m2vAdapter.displayGeneration(nextGI.getGeneration());
	}
}
