package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BruteForceProblem2;

public class BruteForceProblem2Test {

	@Test
	public void testSolution() {
		BruteForceProblem2 brute2 = new BruteForceProblem2();
		int result = brute2.solution("17");
		int expected = 3;
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		BruteForceProblem2 brute2 = new BruteForceProblem2();
		int result = brute2.solution("011");
		int expected = 2;
		assertEquals(expected, result);
	}

	@Test
	public void testIsPrimeNumer() {
		BruteForceProblem2 brute2 = new BruteForceProblem2();
		boolean result = brute2.isPrime(3);
		assertTrue(result);
		
		result = brute2.isPrime(4);
		assertTrue(!result);
		
		result = brute2.isPrime(101);
		assertTrue(result);
	}

}
