package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.StackProgram2;

public class StackProgram2Test {

	@Test
	public void testSolution() {
		int expected = 8;
		
		int result = StackProgram2.solution(2, 10, new int[]{7, 4, 5, 6});
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		int expected = 101;
		
		int result = StackProgram2.solution(100, 100, new int[]{10});
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		int expected = 110;
		
		int result = StackProgram2.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
		
		assertEquals(expected, result);
	}

	@Test
	public void testSolution4() {
		int expected = 3;
		
		int result = StackProgram2.solution(2, 10, new int[]{7});
		
		assertEquals(expected, result);
	}
	
}
