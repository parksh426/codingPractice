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
	public void testSolution2() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 0, 0}});
		int expected = 120;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 0, 0}, {234, 0, 0}});
		int expected = 60;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 0, 0}, {234, 0, 0}, {345, 0, 0}});
		int expected = 24;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 3, 0}});
		int expected = 1;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution6() {
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 2, 0}});
		int expected = 18;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution7() {
		System.out.println("testSolution7");
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		int result = brute3.solution(new int[][] {{123, 0, 3}});
		int expected = 2;
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeIndex() {
//		BruteForceProblem3 brute3 = new BruteForceProblem3();
//		Set<String> result = new HashSet<String>();
//		brute3.makeIndex("", "123", 2, result);
		
		BruteForceProblem3 brute3 = new BruteForceProblem3();
		String s = "123";
		int r = 1;
		Set<String> result = new HashSet<String>();
		String[] value = new String[r];
		brute3.makeIndex(0, 0, s, r, value, result);
	}

}
