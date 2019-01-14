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
	
	private final GenerationInfo gi = new GenerationInfo(1, "GenerationInfo Test", new ArrayList<IOrganism>());
	
	@Test
	void testErrorGI() {
		assertEquals(-1, GenerationInfo.errorGI.getGenerationNumber());
		assertEquals("ERROR", GenerationInfo.errorGI.getInfo());
		assertEquals(new ArrayList<>(), GenerationInfo.errorGI.getGeneration());
	}

	@Test
	void testGetGenerationNumber() {
		assertEquals(1, gi.getGenerationNumber());
	}

	@Test
	void testGetInfo() {
		assertEquals("GenerationInfo Test", gi.getInfo());
	}

	@Test
	void testGetGeneration() {
		assertEquals(new ArrayList<>(), gi.getGeneration());
	}

}
