package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BruteForceProblem1;

public class BruteForceProblem1Test {

	@Test
	public void testSolution() {
		BruteForceProblem1 brute1 = new BruteForceProblem1();
		int[] result = brute1.solution(new int[] {1, 2, 3, 4, 5});
		int[] expected = new int[] {1};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		BruteForceProblem1 brute1 = new BruteForceProblem1();
		int[] result = brute1.solution(new int[] {1, 3, 2, 4, 2});
		int[] expected = new int[] {1, 2, 3};
		
		assertArrayEquals(expected, result);
	}

}
