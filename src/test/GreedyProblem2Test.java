package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GreedyProblem2;

public class GreedyProblem2Test {

	@Test
	public void testSolution00() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("JEROEN");
		int expected = 56;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution000() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBBBBABA");
		int expected = 12;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution001() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAABAA");
		int expected = 4;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution002() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAABA");
		int expected = 3;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution003() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAAAA");
		int expected = 0;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution004() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BAAAABAA");
		int expected = 5;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution005() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBBBBABA");
		int expected = 12;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution006() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BAAABA");
		int expected = 4;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution01() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("JAN");
		int expected = 23;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution02() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAA");
		int expected = 0;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution03() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAZ");
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution04() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("ZAA");
		int expected = 1;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution05() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBABA");
		int expected = 6;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution06() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("AAAAAAAAAABABB");
		int expected = 7;
		
		assertEquals(expected, result);
	}
	
//	@Test
//	public void testSolution06() {
//		GreedyProblem2 greedy2 = new GreedyProblem2();
//		int result = greedy2.solution("BBBAAB");
//		int expected = 8;
//		
//		assertEquals(expected, result);
//	}
//	
	@Test
	public void testSolution07() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBAABAA");
		int expected = 7;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution08() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBAABBB");
		int expected = 10;
		
		assertEquals(expected, result);
	}
//	
//	@Test
//	public void testSolution09() {
//		GreedyProblem2 greedy2 = new GreedyProblem2();
//		int result = greedy2.solution("BBAABAAAA");
//		int expected = 7;
//		
//		assertEquals(expected, result);
//	}
//	
//	@Test
//	public void testSolution10() {
//		GreedyProblem2 greedy2 = new GreedyProblem2();
//		int result = greedy2.solution("BBAABAAAAB");
//		int expected = 10;
//		
//		assertEquals(expected, result);
//	}
	
	@Test
	public void testSolution11() {
		GreedyProblem2 greedy2 = new GreedyProblem2();
		int result = greedy2.solution("BBBBAAAAAAABBBA");
		int expected = 17;
		
		assertEquals(expected, result);
	}
	
}
