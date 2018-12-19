package main.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * The view. The user interacts with this.
 * 
 * @author jhwang73
 * @param <Species> The species
 */
public class View<Species> extends JFrame {
	
	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 3477867755243767271L;
	/**
	 * The adapter from the view to the model. Initialized to the no-op adapter.
	 */
	private IViewToModelAdapter _v2mAdapter = IViewToModelAdapter.NULL_ADAPTER;
	
	/**
	 * The pane that holds all the components.
	 */
	private JPanel contentPane;
	/**
	 * The panel which holds on the generation panel.
	 */
	private final JPanel panelCenter = new JPanel();
	/**
	 * The panel which holds the application actions.
	 */
	private final JPanel panelNorth = new JPanel();
	/**
	 * Quit the application.
	 */
	private final JButton btnQuit = new JButton("Quit");
	/**
	 * The list of species.
	 */
	private final JComboBox<Species> comboBoxThings = new JComboBox<Species>();
	/**
	 * Begin a new generation.
	 */
	private final JButton btnBegin = new JButton("Begin");
	/**
	 * The panel which holds the generation info & actions.
	 */
	private final JPanel panelSouth = new JPanel();
	/**
	 * Which generation you are currently at.
	 */
	private final JLabel lblGenerationNumber = new JLabel("Generation:#");
	/**
	 * Go to the next generation.
	 */
	private final JButton btnNextGeneration = new JButton("Next Generation");
	/**
	 * Labels the list of species.
	 */
	private final JLabel lblSpecies = new JLabel("Species:");
	/**
	 * Labels the size of the generation.
	 */
	private final JLabel lblGenerationSize = new JLabel("Generation Size");
	/**
	 * The size of the generation.
	 */
	private final JSpinner spinnerGenerationSize = new JSpinner(new SpinnerNumberModel(2, 2, 10, 1));

	/**
	 * Initializes the GUI
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Constructor for the view.
	 * @param v2mAdapter The adapter from the view to the model.
	 */
	public View(IViewToModelAdapter v2mAdapter) {
		this._v2mAdapter = v2mAdapter;
		setSize(new Dimension(500, 500));
		initGUI();
	}

	/**
	 * Initializes the components of the GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		panelCenter.setToolTipText("The main panel where generations are shown");
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelNorth.setBackground(new Color(0, 255, 153));
		panelNorth.setToolTipText("The action buttons are here.");
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		panelSouth.setBackground(new Color(0, 255, 153));
		panelSouth.setToolTipText("Holds information and actions about the progression of generations");
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		btnQuit.setToolTipText("Quit the application");
		panelNorth.add(btnQuit);
		lblSpecies.setToolTipText("The available species are:");
		
		panelNorth.add(lblSpecies);
		comboBoxThings.setToolTipText("The list of species");
		
		panelNorth.add(comboBoxThings);
		
		lblGenerationSize.setToolTipText("The size of the generation (The number of organisms in each generation)");
		panelNorth.add(lblGenerationSize);
		
		((JSpinner.DefaultEditor) spinnerGenerationSize.getEditor()).getTextField().setEditable(false);
		spinnerGenerationSize.setToolTipText("Input the size of the generation");
		panelNorth.add(spinnerGenerationSize);
		
		btnBegin.setToolTipText("Start a new generation of the selected species.");
		panelNorth.add(btnBegin);

		lblGenerationNumber.setToolTipText("The #th generation");
		panelSouth.add(lblGenerationNumber);
		
		btnNextGeneration.setToolTipText("Simulate an advancement to the next generation.");
		panelSouth.add(btnNextGeneration);
	}

}
