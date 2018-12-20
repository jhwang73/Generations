package main.model.generation;

/**
 * The interface that describes an an organism of some species.
 * 
 * @author jhwang73
 */
public interface IOrganism {
	
	/**
	 * Display the organism as a String.
	 * Organisms can choose to display however much information.
	 * @return The String representation
	 */
	public String displayAsString();
	
}
