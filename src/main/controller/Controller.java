package main.controller;

import java.awt.EventQueue;

import main.model.Model;
import main.view.View;

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
		_model = new Model(null);
		_view = new View(null);
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
	 * @param args Arguments given by the system or command line.
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


