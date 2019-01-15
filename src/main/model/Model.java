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
	 * The list of available ecosystems.
	 */
	private final List<AEcosystemFactory> _ecosystems = new ArrayList<>();
	/**
	 * The list of available species.
	 */
	private final List<AOrganismFactory> _species = new ArrayList<>();
	/**
	 * The map of available ecosystems to their valid species.
	 */
	private final Map<AEcosystemFactory, List<AOrganismFactory>> _ecosystemsToSpecies = new HashMap<>();
	
	/**
	 * The Constructor for the model.
	 * @param m2vAdapter The adapter from the model to the view
	 */
	public Model(IModelToViewAdapter m2vAdapter) {
		this._m2vAdapter = m2vAdapter;
	}
	
	/**
	 * Populate the available ecosystems.
	 */
	private void populateEcosystems() {
		_ecosystems.add(new AEcosystemFactory() {

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
				return FibonacciEcosystem._requiredOrganismClass;
			}

		});
		
		_ecosystems.add(new AEcosystemFactory() {

			@Override
			protected String getEcosystemName() {
				return FightingEcosystem._ecosystemName;
			}

			@Override
			public IEcosystem makeEcosystem(int generationSize, AOrganismFactory organismFactory) {
				return new FightingEcosystem(generationSize, organismFactory);
			}

			@Override
			public Class<? extends IOrganism> getRequiredOrganismClass() {
				return FightingEcosystem._requiredOrganismClass;
			}

		});
		
		_ecosystems.add(new AEcosystemFactory() {

			@Override
			protected String getEcosystemName() {
				return MatchmakingEcosystem._ecosystemName;
			}

			@Override
			public IEcosystem makeEcosystem(int generationSize, AOrganismFactory organismFactory) {
				return new MatchmakingEcosystem(generationSize, organismFactory);
			}

			@Override
			public Class<? extends IOrganism> getRequiredOrganismClass() {
				return MatchmakingEcosystem._requiredOrganismClass;
			}

		});

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
			public IOrganism makeRandomOrganism() {
				return new FibonacciOrganism(-1, -1);
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return FibonacciOrganism.class;
			}
			
		});
		
		_species.add(new AOrganismFactory() {

			@Override
			public String getSpeciesName() {
				return RockPaperScissorsOrganism._speciesName;
			}
			
			@Override
			public IOrganism makeRandomOrganism() {
				return new RockPaperScissorsOrganism();
//				return RockPaperScissorsOrganism.getRandomRPSOrganism();
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return RockPaperScissorsOrganism.class;
			}
			
		});
		
		_species.add(new AOrganismFactory() {

			@Override
			public String getSpeciesName() {
				return NinjaOrganism._speciesName;
			}

			@Override
			public IOrganism makeRandomOrganism() {
				return new NinjaOrganism();
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return NinjaOrganism.class;
			}
			
		});

		_species.add(new AOrganismFactory() {

			@Override
			public String getSpeciesName() {
				return NBAOrganism._speciesName;
			}

			@Override
			public IOrganism makeRandomOrganism() {
				return new NBAOrganism();
			}

			@Override
			public Class<? extends IOrganism> getOrganismClass() {
				return NBAOrganism.class;
			}
			
		});
		
	}
	
	/**
	 * Populate the available species for each available ecosystem.
	 */
	private void populateEcosystemsToSpecies() {
		this._ecosystems.forEach((s) -> {
			this._ecosystemsToSpecies.put(s, new ArrayList<>());
		});

		this._ecosystems.forEach((eco) -> {
			this._species.forEach((s) -> {
				if (eco.getRequiredOrganismClass().isAssignableFrom(s.getOrganismClass())) {
					this._ecosystemsToSpecies.get(eco).add(s);
				}
			});
		});
	}
	
	/**
	 * Start the model
	 */
	public void start() {
		this.populateEcosystems();
		this.populateSpecies();
		this.populateEcosystemsToSpecies();
	}
	
	/**
	 * Quit the model.
	 */
	public void quit() {
		System.exit(0);
	}
	
	/**
	 * Get the list of available species for the selected ecosystem.
	 * @param ecosystem The selected ecosystem
	 * @return The list of available species for the selected ecosystem
	 */
	public List<AOrganismFactory> getAvailableSpecies(AEcosystemFactory ecosystem) {
		return this._ecosystemsToSpecies.get(ecosystem);
	}
	
	/**
	 * Get all the available ecosystems.
	 * @return The list of available ecosystems
	 */
	public List<AEcosystemFactory> getAvailableEcosystems() {
		return this._ecosystems;
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
		
		String ecosystemInfo = this._ecosystem.getEcosystemName() + ": " + this._ecosystem.getEcosystemRules() + "\n";
		this._m2vAdapter.displayText(ecosystemInfo);
		
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
