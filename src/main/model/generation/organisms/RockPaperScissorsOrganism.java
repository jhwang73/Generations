package main.model.generation.organisms;

import main.model.generation.IOrganism;

/**
 * The Rock Paper Scissors Organism. For this species, organisms are either rock, paper, or scissors.
 * @author jasonhwang
 *
 */
public class RockPaperScissorsOrganism implements IFightingOrganism {
	
	/**
	 * The RPS Value wrapper. Limits the possible values of the organism to Rock, Paper, and Scissors.
	 * @author jasonhwang
	 *
	 */
	public enum RockPaperScissorsValue {
		ROCK(0),
		PAPER(1),
		SCISSORS(2);
		
		/**
		 * The int value
		 * 0 - Rock
		 * 1 - Paper
		 * 2 - Scissors
		 */
		private int _value;
		
		/**
		 * The constructor for the RockPaperScissors
		 * @param value The value of the RPS
		 */
		private RockPaperScissorsValue(int value) {
			this._value = value;
		}
		
		/**
		 * Get the int value of RPS.
		 * @return The int value
		 */
		public int getValue() {
			return this._value;
		}
	}
	
	/**
	 * The name of the species of this organism.
	 */
	public final static String _speciesName = "RockPaperScissorsOrganism";
	
	/**
	 * Determines whether this RPS Organism is a Rock, Paper, or Scissors.
	 */
	private RockPaperScissorsValue _RPSValue;
	
	/**
	 * The Constructor for the Rock Paper Scissors Organism
	 * @param rps The identity of the RPSOrganism. Either Rock, Paper, or Scissors.
	 */
	public RockPaperScissorsOrganism(RockPaperScissorsValue rps) {
		this._RPSValue = rps;
	}
	
	public static RockPaperScissorsOrganism getRandomRPSOrganism() {
		double value = Math.random();
		RockPaperScissorsValue rps;
		if (value < 0.33)
			rps = RockPaperScissorsValue.ROCK;
		else if (value < 0.66)
			rps = RockPaperScissorsValue.PAPER;
		else
			rps = RockPaperScissorsValue.SCISSORS;
		
		return new RockPaperScissorsOrganism(rps);
	}

	@Override
	public IOrganism reproduce() {
		return new RockPaperScissorsOrganism(this._RPSValue);
	}

	@Override
	public String mutate() {
		double mutation = Math.random();
		int oldRPSValueInt = this._RPSValue.getValue();
		if (mutation < 0.33)
			this._RPSValue = RockPaperScissorsValue.ROCK;
		else if (mutation < 0.66)
			this._RPSValue = RockPaperScissorsValue.PAPER;
		else
			this._RPSValue = RockPaperScissorsValue.SCISSORS;
		
		if (this._RPSValue.getValue() == oldRPSValueInt)
			return "No mutation.";
		else
			return "The RPSOrganism changed to " + this._RPSValue.name();	
	}

	@Override
	public String getName() {
		return this._RPSValue.name();
	}

	@Override
	public boolean fight(IOrganism opponent) {
		int myInt = this.getRockPaperScissorsValueInt();
		int opponentInt = ((RockPaperScissorsOrganism)opponent).getRockPaperScissorsValueInt();
		
		return (myInt == 0 && opponentInt == 2) || (myInt == 1 && opponentInt == 0) || (myInt == 2 && opponentInt == 1);
	}
	
	/**
	 * Get the int that represents this RPSOrganism's RPSValue
	 * @return The int representing the RPSOrganism's RPSValue
	 */
	public int getRockPaperScissorsValueInt() {
		return this._RPSValue.getValue();
	}

}
