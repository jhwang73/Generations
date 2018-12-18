package main.model;

/**
 * The adapter from the model to the view.
 * 
 * @author jhwang73
 */
public interface IModelToViewAdapter {
	
	/**
	 * The no-op adapter.
	 */
	public static final IModelToViewAdapter NULL_ADAPTER = new IModelToViewAdapter() {
		
	};

}
