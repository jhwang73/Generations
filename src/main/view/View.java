package main.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * The view. The user interacts with this.
 * 
 * @author jhwang73
 * @param <Organism> The organism
 * @param <Species> The species
 * @param <Ecosystem> The ecosystem
 */
public class View<Organism, Species, Ecosystem> extends JFrame {
	
	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 3477867755243767271L;
	/**
	 * The adapter from the view to the model. Initialized to the no-op adapter.
	 */
	private IViewToModelAdapter<Species, Ecosystem> _v2mAdapter = IViewToModelAdapter.NULL_ADAPTER;
	
	/**
	 * The pane that holds all the components.
	 */
	private JPanel contentPane;
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
	private final JComboBox<Species> comboBoxSpecies = new JComboBox<Species>();
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
	private final JLabel lblGenerationNumber = new JLabel("Generation ?");
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
	 * The size of the generation. Must be at least 2.
	 */
	private final JSpinner spinnerGenerationSize = new JSpinner(new SpinnerNumberModel(2, 2, 10, 1));
	/**
	 * Labels the list of available ecosystems.
	 */
	private final JLabel lblEcosystem = new JLabel("Ecosystem:");
	/**
	 * The list of ecosystems for a selected species.
	 */
	private final JComboBox<Ecosystem> comboBoxEcosystems = new JComboBox<Ecosystem>();
	/**
	 * The split pane where the information is displayed.
	 */
	private final JSplitPane splitPane = new JSplitPane();
	/**
	 * Information about the ecosystem & the generations are displayed here.
	 */
	private final JTextArea textAreaInfo = new JTextArea();
	/**
	 * The generation is displayed here.
	 */
	private final JTextPane textPaneGeneration = new JTextPane();

	/**
	 * Initializes the GUI
	 */
	public void start() {
		setVisible(true);
		btnNextGeneration.setEnabled(false);
		
		// Populate the list of available species
		_v2mAdapter.getAvailableSpecies().forEach((s) -> comboBoxSpecies.addItem(s));
	}

	/**
	 * Constructor for the view.
	 * @param v2mAdapter The adapter from the view to the model.
	 */
	public View(IViewToModelAdapter<Species, Ecosystem> v2mAdapter) {
		this._v2mAdapter = v2mAdapter;
		setMinimumSize(new Dimension(300, 300));
		initGUI();
	}

	/**
	 * Initializes the components of the GUI
	 */
	private void initGUI() {
		
		// TODO: do button synchronization? disable on view, in controller, undisable
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		panelNorth.setBackground(new Color(0, 255, 153));
		panelNorth.setToolTipText("The action buttons are here.");
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		panelSouth.setBackground(new Color(0, 255, 153));
		panelSouth.setToolTipText("Holds information and actions about the progression of generations");
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		btnQuit.setToolTipText("Quit the application");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdapter.quit();
				System.exit(0);
			}
		});
		panelNorth.add(btnQuit);
		
		lblSpecies.setToolTipText("The available species are:");
		panelNorth.add(lblSpecies);
		
		comboBoxSpecies.setToolTipText("The list of species");
		comboBoxSpecies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxEcosystems.removeAllItems();
				_v2mAdapter.getAvailableEcosystems(comboBoxSpecies.getItemAt(comboBoxSpecies.getSelectedIndex())).forEach((eco) -> {
					comboBoxEcosystems.addItem(eco);
				});
			}
		});
		panelNorth.add(comboBoxSpecies);
		
		lblEcosystem.setToolTipText("The ecosystem to place the selected species in");
		panelNorth.add(lblEcosystem);
		
		comboBoxEcosystems.setToolTipText("The list of available ecosystems for the selected species");
		panelNorth.add(comboBoxEcosystems);
		
		lblGenerationSize.setToolTipText("The size of the generation (The number of organisms in each generation)");
		panelNorth.add(lblGenerationSize);
		
		((JSpinner.DefaultEditor) spinnerGenerationSize.getEditor()).getTextField().setEditable(false);
		spinnerGenerationSize.setToolTipText("Input the size of the generation");
		panelNorth.add(spinnerGenerationSize);
		
		btnBegin.setToolTipText("Start a new generation of the selected species in the selected ecosystem.");
		panelNorth.add(btnBegin);

		lblGenerationNumber.setToolTipText("The #th generation");
		panelSouth.add(lblGenerationNumber);
		
		btnNextGeneration.setToolTipText("Simulate an advancement to the next generation.");
		panelSouth.add(btnNextGeneration);
		splitPane.setToolTipText("Contains the text information and the generation display");
		
		contentPane.add(splitPane, BorderLayout.CENTER);
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setEditable(false);
		textAreaInfo.setToolTipText("The text area where information regarding the ecosystem and generations are displayed");
		textAreaInfo.setSize(new Dimension(200, 600));
		splitPane.setLeftComponent(textAreaInfo);
		textPaneGeneration.setEditable(false);
		textPaneGeneration.setToolTipText("Displays the generations");
		splitPane.setRightComponent(textPaneGeneration);
		
	}
	
	/**
	 * Display text on the view
	 * @param text The text to display
	 */
	public void displayText(String text) {
		textAreaInfo.append(text);
	}
	
	/**
	 * Set the generation iteration number
	 * @param generationNumber The generation number
	 */
	public void setGeneration(int generationNumber) {
		lblGenerationNumber.setText("Generation " + generationNumber);
	}
	
	/**
	 * Display the generation
	 * @param generation The generation
	 */
	public <O extends Organism> void displayGeneration(List<O> generation) {
		//TODO
	}

}
