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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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
	@SuppressWarnings("unchecked")
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
	private final JSpinner spinnerGenerationSize = new JSpinner(new SpinnerNumberModel(2, 2, 16, 1));
	/**
	 * Labels the list of available ecosystems.
	 */
	private final JLabel lblEcosystem = new JLabel("Ecosystem:");
	/**
	 * The list of ecosystems for a selected species.
	 */
	private final JComboBox<Ecosystem> comboBoxEcosystems = new JComboBox<Ecosystem>();
	/**
	 * The scroll pane where info is displayed.
	 */
	private final JScrollPane scrollPaneInfo = new JScrollPane();
	/**
	 * The scroll pane where generations are displayed.
	 */
	private final JScrollPane scrollPaneGeneration = new JScrollPane();
	/**
	 * The text area where information is displayed.
	 */
	private final JTextArea textAreaInfo = new JTextArea();
	/**
	 * The text area where generations are displayed.
	 */
	private final JTextArea textAreaGeneration = new JTextArea();

	/**
	 * Initializes the GUI
	 */
	public void start() {
		setVisible(true);
		btnNextGeneration.setEnabled(false);
		
		// Populate the list of available species
		_v2mAdapter.getAvailableEcosystems().forEach((eco) -> comboBoxEcosystems.addItem(eco));
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 600);

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
		
		lblEcosystem.setToolTipText("The ecosystem to place the selected species in");
		panelNorth.add(lblEcosystem);
		
		comboBoxEcosystems.setToolTipText("The list of available ecosystems for the selected species");
		comboBoxEcosystems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxSpecies.removeAllItems();
				_v2mAdapter.getAvailableSpecies(comboBoxEcosystems.getItemAt(comboBoxEcosystems.getSelectedIndex())).forEach((s) -> {
					comboBoxSpecies.addItem(s);
				});
			}
		});
		panelNorth.add(comboBoxEcosystems);
		
		lblSpecies.setToolTipText("The available species are:");
		panelNorth.add(lblSpecies);
		
		comboBoxSpecies.setToolTipText("The list of species");
		panelNorth.add(comboBoxSpecies);
		
		lblGenerationSize.setToolTipText("The size of the generation (The number of organisms in each generation)");
		panelNorth.add(lblGenerationSize);
		
		((JSpinner.DefaultEditor) spinnerGenerationSize.getEditor()).getTextField().setEditable(false);
		spinnerGenerationSize.setToolTipText("Input the size of the generation");
		panelNorth.add(spinnerGenerationSize);
		
		btnBegin.setToolTipText("Start a new generation of the selected species in the selected ecosystem.");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin.setEnabled(false);
				btnNextGeneration.setEnabled(false);
				textAreaInfo.setText("");
				textAreaGeneration.setText("");
				_v2mAdapter.begin(comboBoxSpecies.getItemAt(comboBoxSpecies.getSelectedIndex()), comboBoxEcosystems.getItemAt(comboBoxEcosystems.getSelectedIndex()), (Integer)spinnerGenerationSize.getValue());
			}
		});
		panelNorth.add(btnBegin);

		lblGenerationNumber.setToolTipText("The #th generation");
		panelSouth.add(lblGenerationNumber);
		
		btnNextGeneration.setToolTipText("Simulate an advancement to the next generation.");
		btnNextGeneration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBegin.setEnabled(false);
				btnNextGeneration.setEnabled(false);
				textAreaGeneration.setText("");
				_v2mAdapter.nextGeneration();
			}
		});
		panelSouth.add(btnNextGeneration);
		
		scrollPaneInfo.setToolTipText("The scroll pane which will hold the info text pane");
		scrollPaneInfo.setPreferredSize(new Dimension(400, 600));
		contentPane.add(scrollPaneInfo, BorderLayout.WEST);
		textAreaInfo.setEditable(false);
		
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setToolTipText("The text area for information");
		textAreaInfo.setText("Click an ecosystem, a species, press begin, and observe the generations advance!");
		scrollPaneInfo.setViewportView(textAreaInfo);
		textAreaGeneration.setEditable(false);
		
		textAreaGeneration.setLineWrap(true);
		scrollPaneGeneration.setViewportView(textAreaGeneration);
		
		scrollPaneGeneration.setToolTipText("The scroll pane which holds the generations");
		contentPane.add(scrollPaneGeneration, BorderLayout.CENTER);
		textAreaGeneration.setToolTipText("The text area for the generation");
		
		
	}
	
	/**
	 * Display text on the view
	 * @param text The text to display
	 */
	public void displayText(String text) {
		textAreaInfo.append(text + "\n");
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
	public void displayGeneration(List<? extends Organism> generation) {
		generation.forEach((o) -> textAreaGeneration.append(o.toString() + "\n\n"));
		btnBegin.setEnabled(true);
		btnNextGeneration.setEnabled(true);
	}

}
