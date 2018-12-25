package main.model.generation.organisms;

/**
 * Organisms which can fight.
 * 
 * @author jhwang73
 * @param <Species> The species of this organism, which can only fight other organisms of the same type.
 */
public interface IFighting<Species extends IFighting<Species>> extends IAsexual<Species> {
	
	/**
	 * Fight the opponent.
	 * @param opponent The opponent to fight
	 */
	public void fight(Species opponent);
	
}
