package main.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

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
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

}
