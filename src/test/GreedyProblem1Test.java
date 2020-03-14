package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GreedyProblem1;

public class GreedyProblem1Test {

	@Test
	public void testSolution() {
		GreedyProblem1 greedy1 = new GreedyProblem1();
		int result = greedy1.solution(5, new int[] {2, 4}, new int[] {1, 3, 5});
		int expected = 5;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		GreedyProblem1 greedy1 = new GreedyProblem1();
		int result = greedy1.solution(5, new int[] {2, 4}, new int[] {3});
		int expected = 4;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		GreedyProblem1 greedy1 = new GreedyProblem1();
		int result = greedy1.solution(3, new int[] {3}, new int[] {1});
		int expected = 2;
		
		assertEquals(expected, result);
	}

}
