package main.controller;

import java.awt.EventQueue;
import java.util.List;

import main.model.*;
import main.model.generation.IOrganism;
import main.view.*;

/**
 * The controller. Determines and instantiates the model and view.
 * 
 * @author jhwang73
 */
public class Controller {
	
	/**
	 * The model. The application uses this for backend operations.
	 */
	private Model _model;

	/**
	 * The view. The user interacts with this.
	 */
	private View _view;

	/**
	 * The constructor of the Controller.
	 */
	public Controller() {
		_model = new Model(new IModelToViewAdapter() {

			@Override
			public void displayText(String text) {
				_view.displayText(text);
			}

			@Override
			public void setGeneration(int generationNumber) {
				_view.setGeneration(generationNumber);
			}

			@Override
			public void displayGeneration(List<? extends IOrganism> generation) {
				// TODO Auto-generated method stub
			}
			
		});
		
		_view = new View(new IViewToModelAdapter() {

			@Override
			public void quit() {
				_model.quit();
			}

			@Override
			public void begin(Object species, Object ecosystem) {
				_model.beginNewEcosystem(species, ecosystem);
			}

			@Override
			public void nextGeneration() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public List getAvailableSpecies() {
				return _model.getAvailableSpecies();
			}

			@Override
			public List getAvailableEcosystems(Object species) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}
	
	/**
	 * Start the system.
	 */
	public void start() {
		_model.start();
		_view.start();
	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


