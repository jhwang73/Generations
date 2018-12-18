package main.model.generation;

import java.util.List;

/**
 * Holds a generation of species(singular), and the info regarding that generation.
 * 
 * @author jhwang73
 * @param <Species> The species(singular).
 */
public class GenerationInfo<Species> {
	
	/**
	 * The iteration of the generation. Zero-indexed.
	 */
	private int generationNumber;

	/**
	 * The information regarding this generation.
	 * For the initial generation, this info will describe the species(singular) and the breeding process.
	 * For all other generations, this info will describe what happened to get to the current generation.
	 */
	private String info;
	
	/**
	 * The generation, or equivalently, a list of organisms in that generation.
	 */
	private List<Species> generation;
	
	/**
	 * The Constructor for the Generation Info.
	 * @param generationNumber The iteration of the generation
	 * @param info The information regarding this generation
	 * @param generation The generation
	 */
	public GenerationInfo(int generationNumber, String info, List<Species> generation) {
		this.generationNumber = generationNumber;
		this.info = info;
		this.generation = generation;
	}

	/**
	 * Get the generation number.
	 * @return the generationNumber.
	 */
	public int getGenerationNumber() {
		return generationNumber;
	}
	
	/**
	 * Get the info.
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Get the generation.
	 * @return the generation
	 */
	public List<Species> getGeneration() {
		return generation;
	}

}
