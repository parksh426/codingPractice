package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.StackProgram1;

public class StackProgram1Test {

	@Test
	public void testSolution() {
		
		int[] input = {6, 9, 5, 7, 4};
		int[] expected = {0, 0, 2, 2, 4};
		
		int[] result = StackProgram1.solution(input);
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		
		int[] input = {3, 9, 9, 3, 5, 7, 2};
		int[] expected = {0, 0, 0, 3, 3, 3, 6};
		
		int[] result = StackProgram1.solution(input);
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		
		int[] input = {1, 5, 3, 6, 7, 6, 5};
		int[] expected = {0, 0, 2, 0, 0, 5, 6};
		
		int[] result = StackProgram1.solution(input);
		
		assertArrayEquals(expected, result);
	}

}
