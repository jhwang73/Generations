package main.model.generation.organisms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public final static String _speciesName = "RPS";
	
	/**
	 * Determines whether this RPS Organism is a Rock, Paper, or Scissors.
	 */
	private RockPaperScissorsValue _RPSValue;
	
	/**
	 * The list of available RPS.
	 */
	private final static List<RockPaperScissorsValue> _availableRPS = new ArrayList<>(Arrays.asList(RockPaperScissorsValue.values()));
				
	/**
	 * The Constructor for the Rock Paper Scissors Organism
	 * @param rps The identity of the RPSOrganism. Either Rock, Paper, or Scissors.
	 */
	public RockPaperScissorsOrganism(RockPaperScissorsValue rps) {
		this._RPSValue = rps;
	}
	
	/**
	 * Get a random RPS Organism.
	 * @return A RPS Organism
	 */
	public static RockPaperScissorsOrganism getRandomRPSOrganism() {
		int value = (int) (Math.random() * _availableRPS.size());
		return new RockPaperScissorsOrganism(_availableRPS.get(value));
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public IOrganism reproduce() {
		return new RockPaperScissorsOrganism(this._RPSValue);
	}

	@Override
	public String mutate() {
		int newInt = this.getRockPaperScissorsValueInt();
		String old = this._RPSValue.name();
		
		if (Math.random() < 0.5) {
			newInt = (newInt + 1) % 3;
		} else {
			newInt = (newInt + 2) % 3;
		}
		
		this._RPSValue = _availableRPS.get(newInt);
		
		return old + " changed to " + this._RPSValue.name();	
	}

	@Override
	public String getName() {
		return this._RPSValue.name();
	}

	@Override
	public int fight(IOrganism opponent) {
		int myInt = this.getRockPaperScissorsValueInt();
		int opponentInt = ((RockPaperScissorsOrganism)opponent).getRockPaperScissorsValueInt();
		
		if (myInt == opponentInt) {
			return 0;
		} else if ((myInt == 0 && opponentInt == 2) || (myInt == 1 && opponentInt == 0) || (myInt == 2 && opponentInt == 1)) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Get the int that represents this RPSOrganism's RPSValue
	 * @return The int representing the RPSOrganism's RPSValue
	 */
	private int getRockPaperScissorsValueInt() {
		return this._RPSValue.getValue();
	}

}
