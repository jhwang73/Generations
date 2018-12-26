package main.model;

import java.util.List;

import main.model.generation.IOrganism;

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

		@Override
		public void displayText(String text) {
			// TODO Auto-generated method stub
		}

		@Override
		public void setGeneration(int generationNumber) {
			// TODO Auto-generated method stub
		}

		@Override
		public void displayGeneration(List<? extends IOrganism> generation) {
			// TODO Auto-generated method stub
		}
		
	};
	
	/**
	 * Display text on the view
	 * @param text The text to display
	 */
	public void displayText(String text);
	
	/**
	 * Set the generation iteration number
	 * @param generationNumber The generation number
	 */
	public void setGeneration(int generationNumber);
	
	/**
	 * Display a generation
	 * @param generation The generation
	 */
	public void displayGeneration(List<? extends IOrganism> generation);

}
