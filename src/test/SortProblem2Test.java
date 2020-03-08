package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.SortProblem2;

public class SortProblem2Test {

	@Test
	public void testSolution() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {6, 10, 2});
		String expected = "6210";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution2() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {3, 30, 34, 5, 9});
		String expected = "9534330";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution3() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {12, 122});
		String expected = "12212";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution4() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {40, 403});
		String expected = "40403";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution5() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {40, 405});
		String expected = "40540";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution6() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {40, 404});
		String expected = "40440";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution7() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {12, 121});
		String expected = "12121";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution8() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {2, 22, 223});
		String expected = "223222";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution9() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {21, 212});
		String expected = "21221";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution10() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {41, 415});
		String expected = "41541";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution11() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {2, 22});
		String expected = "222";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution12() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {70, 0, 0, 0});
		String expected = "70000";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSolution13() {
		SortProblem2 sort2 = new SortProblem2();
		String result = sort2.solution(new int[] {12, 1213});
		String expected = "121312";
		
		assertEquals(expected, result);
	}

}
