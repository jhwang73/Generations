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

/**
 * The view. The user interacts with this.
 * 
 * @author jhwang73
 */
public class View extends JFrame {

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
	 * The list of "things".
	 */
	private final JComboBox comboBoxThings = new JComboBox();
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
	 * Initializes the GUI
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Constructor for the view.
	 */
	public View() {
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
		
		comboBoxThings.setToolTipText("The list of things you can simulate generations of");
		panelNorth.add(comboBoxThings);
		
		btnBegin.setToolTipText("Start a new generation of the selected \"thing\".");
		panelNorth.add(btnBegin);

		lblGenerationNumber.setToolTipText("The #th generation");
		panelSouth.add(lblGenerationNumber);
		
		btnNextGeneration.setToolTipText("Simulate an advancement to the next generation.");
		panelSouth.add(btnNextGeneration);
	}

}
