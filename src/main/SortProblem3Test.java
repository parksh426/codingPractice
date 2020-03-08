package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortProblem3Test {

	@Test
	public void testSolution() {
		SortProblem3 sort3 = new SortProblem3();
		int result = sort3.solution(new int[] {3, 0, 6, 1, 5});
		int expected = 3;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		SortProblem3 sort3 = new SortProblem3();
		int result = sort3.solution(new int[] {6, 6, 6, 6, 6, 2, 1});
		int expected = 5;
		
		assertEquals(expected, result);
	}

}
