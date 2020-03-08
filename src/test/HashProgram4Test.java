package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.HashProgram4;

public class HashProgram4Test {

	@Test
	public void testSolution() {
		System.out.println("testSolution00");
		String[] genres = {"classic", "pop", "classic", "K-POP", "classic", "pop", "pop", "classic"};
		int[] plays = {500, 600, 150, 3500, 800, 2500, 1, 800};
		
		int[] answer = {3, 5, 1, 4, 7};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
		
		String[] genres2 = {"classic", "classic", "classic", "classic", "pop"};
		int[] plays2 = {100, 100, 100, 100, 1000};
		
		int[] answer2 = {4, 0, 1};
		
		result = HashProgram4.solution(genres2, plays2);
		
		assertArrayEquals(answer2, result);
	}
	
	@Test
	public void testSolution2() {
		System.out.println("testSolution02");
		String[] genres = {"classic", "pop", "classic", "classic", "classic"};
		int[] plays = {500, 600, 500, 500, 500};
		
		int[] answer = {0, 2, 1};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution3() {
		System.out.println("testSolution03");
		String[] genres = {"classic", "pop", "pop", "classic", "classic", "classic", "pop", "pop"};
		int[] plays = {500, 400, 600, 500, 500, 500, 600, 600};
		
		int[] answer = {2, 6, 0, 3};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution4() {
		System.out.println("testSolution04");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {100, 100, 100, 100};
		
		int[] answer = {0, 1};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution5() {
		System.out.println("testSolution05");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {100, 50, 100, 100};
		
		int[] answer = {0, 2};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution6() {
		System.out.println("testSolution06");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {100, 100, 50, 100};
		
		int[] answer = {0, 1};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution7() {
		System.out.println("testSolution07");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {50, 100, 50, 100};
		
		int[] answer = {1, 3};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution8() {
		System.out.println("testSolution08");
		String[] genres = {"pop", "pop", "pop"};
		int[] plays = {50, 100, 50};
		
		int[] answer = {1, 0};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution9() {
		System.out.println("testSolution09");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {50, 100, 50, 50};
		
		int[] answer = {1, 0};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution10() {
		System.out.println("testSolution10");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {100, 50, 100, 100};
		
		int[] answer = {0, 2};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}

	@Test
	public void testSolution11() {
		System.out.println("testSolution11");
		String[] genres = {"pop", "pop", "pop", "pop", "pop", "A", "B"};
		int[] plays = {100, 50, 1000, 50, 200, 1000, 2000};
		
		int[] answer = {6, 2, 4, 5};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	@Test
	public void testSolution12() {
		System.out.println("testSolution12");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {100, 200, 300, 400};
		
		int[] answer = {3, 2};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
	
	
	@Test
	public void testSolution13() {
		System.out.println("testSolution13");
		String[] genres = {"pop", "pop", "pop", "pop"};
		int[] plays = {400, 300, 200, 100};
		
		int[] answer = {0, 1};
		
		int[] result = HashProgram4.solution(genres, plays);
		
		assertArrayEquals(answer, result);
	}
}
