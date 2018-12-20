package main.model;

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
	 * The Constructor for the model.
	 * @param m2vAdapter The adapter from the model to the view
	 */
	public Model(IModelToViewAdapter m2vAdapter) {
		this._m2vAdapter = m2vAdapter;
	}
	
	/**
	 * Start the model
	 */
	public void start() {
		// TODO: Anything?
	}
	
	// TODO: use instanceOf() when determining which ecosystems are available for which species
	
	public void initialGeneration(String species) {
//		ecosystem = new SurvivalEcosystem(species);
//		GenInfo = ecosystem.initialGeneration();
	}
}
