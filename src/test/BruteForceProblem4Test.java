package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BruteForceProblem4;

public class BruteForceProblem4Test {

	@Test
	public void testSolution() {
		BruteForceProblem4 brute4 = new BruteForceProblem4();
		int[] result = brute4.solution(10, 2);
		int[] expected = {4, 3};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		BruteForceProblem4 brute4 = new BruteForceProblem4();
		int[] result = brute4.solution(8, 1);
		int[] expected = {3, 3};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		BruteForceProblem4 brute4 = new BruteForceProblem4();
		int[] result = brute4.solution(24, 24);
		int[] expected = {8, 6};
		assertArrayEquals(expected, result);
	}

}
