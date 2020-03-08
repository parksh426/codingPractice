package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.HashProgram3;

public class HashProgram3Test {

	@Test
	public void testSolution() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		int result = HashProgram3.solution(clothes);
		System.out.println("Answer:" + result);
		
		assertEquals(5, result);
	}

}
