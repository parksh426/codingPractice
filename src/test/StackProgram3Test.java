package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.StackProgram3;

public class StackProgram3Test {

	@Test
	public void testSolution() {
		int[] expected = {2, 1};
		
		int[] result = StackProgram3.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		
		assertArrayEquals(expected, result);
	}
	
}
