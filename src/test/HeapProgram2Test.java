package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.HeapProgram2;

public class HeapProgram2Test {

	@Test
	public void testSolution() {
		int result = HeapProgram2.solution(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30);
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testSolution2() {
		int result = HeapProgram2.solution(10, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30);
		int expected = 1;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		int result = HeapProgram2.solution(10, new int[] {4, 10, 15}, new int[] {10, 10, 10}, 30);
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		int result = HeapProgram2.solution(10, new int[] {4, 10, 15, 17, 18, 20}, new int[] {10, 10, 10, 10, 10, 10}, 30);
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		int result = HeapProgram2.solution(4, new int[] {4, 10, 15, 20, 22, 30}, new int[] {20, 5, 10, 3, 10, 10}, 36);
		int expected = 3;
		
		assertEquals(expected, result);
	}
}
