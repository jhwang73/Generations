package test.model.generation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.model.generation.GenerationInfo;
import main.model.generation.IOrganism;

/**
 * Unit tests for Generation Info
 * 
 * @author jhwang73
 */
class GenerationInfoTest {
	
	/**
	 * The test Generation Info
	 */
	private final GenerationInfo gi = new GenerationInfo(1, "GenerationInfo Test", new ArrayList<IOrganism>());
	
	/**
	 * Test the error GI.
	 */
	@Test
	void testErrorGI() {
		assertEquals(-1, GenerationInfo.errorGI.getGenerationNumber());
		assertEquals("ERROR", GenerationInfo.errorGI.getInfo());
		assertEquals(new ArrayList<>(), GenerationInfo.errorGI.getGeneration());
	}

	/**
	 * Test for getGenerationNumber
	 */
	@Test
	void testGetGenerationNumber() {
		assertEquals(1, gi.getGenerationNumber());
	}

	/**
	 * Test for getInfo
	 */
	@Test
	void testGetInfo() {
		assertEquals("GenerationInfo Test", gi.getInfo());
	}

	/**
	 * Test for getGeneration
	 */
	@Test
	void testGetGeneration() {
		assertEquals(new ArrayList<>(), gi.getGeneration());
	}

}
