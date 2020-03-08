package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.StackProgram5;

public class StackProgram5Test {

	@Test
	public void testSolution() {
		int expected = 17;
		
		int result = StackProgram5.solution("()(((()())(())()))(())");
		
		assertEquals(expected, result);
	}

}
