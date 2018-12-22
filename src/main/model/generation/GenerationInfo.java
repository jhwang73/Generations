package main.model.generation;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a generation number, a generation of a species, and the info regarding that generation.
 * 
 * @author jhwang73
 * @param <Species> The species
 */
public class GenerationInfo<Species extends IOrganism> {
	
	/**
	 * The error GI. Return when there is an error during the processing of making generations.
	 */
	@SuppressWarnings("rawtypes")
	public static final GenerationInfo errorGI = new GenerationInfo<>(-1, "ERROR", new ArrayList<>());
	
	/**
	 * The iteration of the generation. Zero-indexed.
	 */
	private final int generationNumber;

	/**
	 * The information regarding this generation.
	 * This info will describe what happened to get to this current generation from the previous generation,
	 * and any relevant information about this generation.
	 */
	private final String info;
	
	/**
	 * The generation, or equivalently, a list of organisms in that generation.
	 */
	private final List<Species> generation;
	
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
	public final int getGenerationNumber() {
		return generationNumber;
	}
	
	/**
	 * Get the info.
	 * @return the info
	 */
	public final String getInfo() {
		return info;
	}

	/**
	 * Get the generation.
	 * @return the generation
	 */
	public final List<Species> getGeneration() {
		return generation;
	}

}
