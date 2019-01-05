package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * The Rock Paper Scissors Organism. For this species, organisms are either rock, paper, or scissors.
 * @author jasonhwang
 *
 */
public class RockPaperScissorsOrganism implements IFightingOrganism {
	
	public enum RockPaperScissors {
		ROCK(0),
		PAPER(1),
		SCISSORS(2);
		
		private int _value;
		
		private RockPaperScissors(int value) {
			this._value = value;
		}
		
		public int getValue() {
			return this._value;
		}
	}
	
	/**
	 * Determines whether this RPS Organism is a Rock, Paper, or Scissors.
	 */
	private RockPaperScissors _value;
	
	public RockPaperScissorsOrganism(RockPaperScissors value) {
		this._value = value;
	}

	@Override
	public IOrganism reproduce() {
		return new RockPaperScissorsOrganism(this._value);
	}

	@Override
	public String mutate() {
		double mutation = Math.random();
		if (mutation)
	}

	@Override
	public String getSpeciesName() {
		return "RockPaperScissorsOrganism";
	}

	@Override
	public String getName() {
		return this._value.toString();
	}

	@Override
	public boolean fight(IOrganism opponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
