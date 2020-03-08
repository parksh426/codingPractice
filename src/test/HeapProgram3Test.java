package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.HeapProgram3;

public class HeapProgram3Test {

	@Test
	public void testSolution() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int result = program.solution(jobs);
		int expected = 9;
		
		assertEquals(expected, result);
	}

	@Test
	public void testSolution2() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};
		int result = program.solution(jobs);
		int expected = 6;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{0, 5}, {1, 2}, {5, 5}};
		int result = program.solution(jobs);
		int expected = 6;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
		int result = program.solution(jobs);
		int expected = 74;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		int result = program.solution(jobs);
		int expected = 74;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution6() {
		HeapProgram3 program = new HeapProgram3();
		int[][] jobs = {{0, 6}, {2, 6}, {4, 3}};
		int result = program.solution(jobs);
		int expected = 8;
		
		assertEquals(expected, result);
	}
}
