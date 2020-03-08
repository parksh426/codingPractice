package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import main.HeapProgram4;

public class HeapProgram4Test {

	@Test
	public void testSolution() {
		
		HeapProgram4 program = new HeapProgram4();
		String[] operations = {"I 16", "D 1"};
		int[] result = program.solution(operations);
		int[] expected = {0, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution1() {
		
		HeapProgram4 program = new HeapProgram4();
		String[] operations = {"I 7","I 5","I -5","D -1"};
		int[] result = program.solution(operations);
		int[] expected = {7, 5};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		
		HeapProgram4 program = new HeapProgram4();
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result = program.solution(operations);
		int[] expected = {333, -45};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		
		HeapProgram4 program = new HeapProgram4();
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] result = program.solution(operations);
		int[] expected = {0, 0};
		
		assertArrayEquals(expected, result);
	}

}
