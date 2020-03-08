package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import main.StackProgram6;

public class StackProgram6Test {

	@Test
	public void testSolution() {
		int[] result = StackProgram6.solution(new int[]{1, 2, 3, 2, 3});
		int[] expected = {4, 3, 1, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		int[] result = StackProgram6.solution2(new int[]{1, 2, 3, 2, 3});
		int[] expected = {4, 3, 1, 1, 0};
		
		assertArrayEquals(expected, result);
		
		result = StackProgram6.solution2(new int[]{1, 1, 1, 1, 1});
		expected = new int[]{4, 3, 2, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		int[] result = StackProgram6.solution2(new int[]{1, 2, 3, 4, 5});
		int[] expected = {4, 3, 2, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		int[] result = StackProgram6.solution2(new int[]{5, 4, 3, 2, 1});
		int[] expected = {1, 1, 1, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		int[] result = StackProgram6.solution2(new int[]{1, 2, 1, 2, 1});
		int[] expected = {4, 1, 2, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution6() {
		int[] result = StackProgram6.solution2(new int[]{1, 2, 3, 2, 1});
		int[] expected = {4, 3, 1, 1, 0};
		
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSolution7() {
		int[] result = StackProgram6.solution2(new int[]{1, 2, 3, 1, 2, 3});
		int[] expected = {5, 2, 1, 2, 1, 0};
		
		assertArrayEquals(expected, result);
	}

}
