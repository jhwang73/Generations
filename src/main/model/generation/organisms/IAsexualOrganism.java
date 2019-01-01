package main.model.generation.organisms;

/**
 * Organisms which can asexually reproduce.
 * 
 * @author jhwang73
 * @param <Species> The species of this organism, which can only produce other organisms of the same type.
 */
public interface IAsexualOrganism<Species extends IAsexualOrganism<Species>> extends INaturalOrganism {
	
	/**
	 * Reproduce asexually
	 * @return A new organism, the child of this organism
	 */
	public Species reproduce();

}
