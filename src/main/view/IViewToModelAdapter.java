package main.view;

/**
 * The adapter from the view to the model.
 * 
 * @author jhwang73
 */
public interface IViewToModelAdapter {
	
	/**
	 * The no-op adapter.
	 */
	public static final IViewToModelAdapter NULL_ADAPTER = new IViewToModelAdapter() {
		
	};
	
}
