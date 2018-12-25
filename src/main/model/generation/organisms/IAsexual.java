package main.model.generation.organisms;

/**
 * Organisms which can asexually reproduce.
 * 
 * @author jhwang73
 * @param <Species> The species of this organism, which can only produce other organisms of the same type.
 */
public interface IAsexual<Species extends IAsexual<Species>> extends INatural {
	
	/**
	 * Reproduce asexually
	 * @return A new organism, the child of this organism
	 */
	public Species reproduce();

}
