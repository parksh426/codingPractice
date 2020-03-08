package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.StackProgram4;

public class StackProgram4Test {

	@Test
	public void test() {
		
		int expected = 1;
		
		int result = StackProgram4.solution(new int[] {2, 1, 3, 2}, 2);
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void test2() {
		
		int expected = 5;
		
		int result = StackProgram4.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
		
		assertEquals(expected, result);
		
	}

}
