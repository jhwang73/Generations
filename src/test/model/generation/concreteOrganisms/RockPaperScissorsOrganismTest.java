package test.model.generation.concreteOrganisms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.generation.organisms.RockPaperScissorsOrganism;
import main.model.generation.organisms.RockPaperScissorsOrganism.RockPaperScissorsValue;

/**
 * Unit tests for RockPaperScissorsOrganism
 * 
 * @author jhwang73
 */
class RockPaperScissorsOrganismTest {

	RockPaperScissorsOrganism rpsRock = new RockPaperScissorsOrganism(RockPaperScissorsValue.ROCK);
	RockPaperScissorsOrganism rpsPaper = new RockPaperScissorsOrganism(RockPaperScissorsValue.PAPER);
	RockPaperScissorsOrganism rpsScissors = new RockPaperScissorsOrganism(RockPaperScissorsValue.SCISSORS);

	@Test
	void testToString() {
		assertEquals("ROCK", rpsRock.toString());
		assertEquals("PAPER", rpsPaper.toString());
		assertEquals("SCISSORS", rpsScissors.toString());
	}

	@Test
	void testReproduce() {
		assertEquals("ROCK", rpsRock.reproduce().getName());
	}

	@Test
	void testGetName() {
		assertEquals("ROCK", rpsRock.toString());
	}

	@Test
	void testGetRockPaperScissorsValueInt() {
		assertEquals(0, rpsRock.getRockPaperScissorsValueInt());
		assertEquals(1, rpsPaper.getRockPaperScissorsValueInt());
		assertEquals(2, rpsScissors.getRockPaperScissorsValueInt());
	}

}
