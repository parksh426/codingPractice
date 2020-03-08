package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.SortProblem1;

public class SortProblem1Test {

	@Test
	public void testSolution() {
		SortProblem1 sort1 = new SortProblem1();
		
		int[] result = sort1.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		int[] expected = {5, 6, 3};
		
		assertArrayEquals(expected, result);
	}

}
