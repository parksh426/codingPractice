package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import main.BruteForceProblem3;

public class BruteForceProblem3Test {

	@Test
	public void testSolution() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 1, 1}, {356,1,0}, {327,2,0}, {489,0,1}});
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeIndex() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		Set<String> result = new HashSet<String>();
		brute3.makeIndex("", "123", 2, result);
		
	}

}
