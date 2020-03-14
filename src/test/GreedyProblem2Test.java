package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GreedyProblem2;

public class GreedyProblem2Test {

	@Test
	public void testSolution() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		String result = greedy2.solution("1924", 2);
		String expected = "94";
		assertEquals(result, expected);
	}
	
	@Test
	public void testSolution2() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		String result = greedy2.solution("1231234", 3);
		String expected = "3234";
		assertEquals(result, expected);
	}
	
	@Test
	public void testSolution3() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		String result = greedy2.solution("4177252841", 4);
		String expected = "775841";
		assertEquals(result, expected);
	}

}
