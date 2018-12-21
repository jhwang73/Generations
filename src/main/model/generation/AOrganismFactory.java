package main.model.generation;

public abstract class AOrganismFactory<Species> {
	
	public abstract String getSpeciesName();
	
	public abstract Species makeOrganism();
	
	// TODO: this will be created as anon inner class in the model. the view picks a species factory & an ecosystem
	// construct the ecosystem with factory as argument. DONE.
	
}
