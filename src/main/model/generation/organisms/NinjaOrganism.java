package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * The ninja organism. Based off Masashi Kishimoto's series, Naruto.
 * @author jasonhwang
 *
 */
public class NinjaOrganism implements IFightingOrganism {

	public NinjaOrganism() {
		
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public IOrganism reproduce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fight(IOrganism opponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
