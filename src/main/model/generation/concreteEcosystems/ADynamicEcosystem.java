package main.model.generation.concreteEcosystems;

import main.model.generation.IEcosystem;

/**
 * The base class of dynamic ecosystems, where interaction is not fixed. All dynamic ecosystems extend this.
 * 
 * @author jhwang73
 */
public abstract class ADynamicEcosystem implements IEcosystem {

	@Override
	public String getEcosystemInfo() {
		return "Ecosystem Name: " + getEcosystemName() +
			   "\nRules: " + getEcosystemRules() +
			   "\nOther Info" + getEcosystemOtherInfo();
	}
	
	/**
	 * Get the name of the ecosystem.
	 * @return The name of the ecosystem
	 */
	protected abstract String getEcosystemName();
	
	/**
	 * Get the rules of how generations are initialized & advanced in this ecosystem.
	 * @return The rules of the ecosystem
	 */
	protected abstract String getEcosystemRules();
	
	/**
	 * Get any other relevant info in the ecosystem.
	 * @return Other info
	 */
	protected abstract String getEcosystemOtherInfo();

}
