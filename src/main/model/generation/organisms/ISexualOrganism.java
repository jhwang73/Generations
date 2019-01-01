package main.model.generation.organisms;

/**
 * Organisms which can sexually reproduce.
 * 
 * @author jhwang73
 * @param <Species> The species of this organism and its mate, which can only produce other organisms of the same type.
 */
public interface ISexualOrganism<Species extends ISexualOrganism<Species>> extends INaturalOrganism {

	/**
	 * Reproduce sexually
	 * @param mate The mate
	 * @return A new organism, the child of this organism and its mate
	 */
	public Species reproduce(Species mate);
	
}
