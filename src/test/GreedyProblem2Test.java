package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GreedyProblem2;

public class GreedyProblem2Test {

	@Test
	public void testSolution() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("JEROEN");
		int expected = 56;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("JAN");
		int expected = 23;
		
		assertEquals(expected, result);
	}

}
