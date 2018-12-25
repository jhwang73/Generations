package main.model.generation.organisms;

/**
 * Organisms which can sexually reproduce.
 * 
 * @author jhwang73
 * @param <Species> The species of this organism and its mate, which can only produce other organisms of the same type.
 */
public interface ISexual<Species extends ISexual<Species>> extends INatural {

	/**
	 * Reproduce sexually
	 * @param mate The mate
	 * @return A new organism, the child of this organism and its mate
	 */
	public Species reproduce(Species mate);
	
}
