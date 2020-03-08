package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.HeapProgram1;

public class HeapProgram1Test {

	@Test
	public void testSolution() {
		int result = HeapProgram1.solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
		int expected = 2;
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		int result = HeapProgram1.solution(new int[] {1, 2}, 7);
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		int result = HeapProgram1.solution(new int[] {8}, 7);
		int expected = 0;
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		int result = HeapProgram1.solution(new int[] {5}, 7);
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		int result = HeapProgram1.solution(new int[] {1, 1, 1}, 7);
		int expected = 2;
		assertEquals(expected, result);
	}

}
