package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class BruteForceProblem3 {
	
	/*
문제 설명


숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃


예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.


이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
-질문의 수는 1 이상 100 이하의 자연수입니다.
-baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

입출력 예


baseball

return


[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] 2 

입출력 예 설명

문제에 나온 예와 같습니다.

	 */


	public int solution(int[][] baseball) {
//		int answer = 0;
		
		Set<String> numSet = new HashSet<String>();
		Set<String> tempSet;
		
		for(int i=0; i<baseball.length; i++) {
			if(i == 0) {
				numSet = makePossibleSet(baseball[i]);
			}
			else {
				tempSet = makePossibleSet(baseball[i]);
				numSet.retainAll(tempSet);
			}
		}
		
		System.out.println("-----Answer------");
		for(String s : numSet) {
			System.out.print(s);
			System.out.print(", ");
		}
		System.out.println();
		System.out.println("-----------------");
		
		return numSet.size();
	}
	
	public Set<String> makePossibleSet(int[] guess){
		Set<String> result = new HashSet<String>();
		
		String question = String.valueOf(guess[0]);
		int strike = guess[1];
		int ball = guess[2];
		
		String[] value = new String[strike];
		Set<String> strikes = new HashSet<String>();
		makeIndex(0, 0, "012", strike, value, strikes);
		
		Set<String[]> strikesBalls = new HashSet<String[]>(); // 0: strike index, 1: ball index, 2: out, 3: question
		String[] balls = new String[ball];
		for(String s : strikes) {
			String notS = notStrikes(s);
			makeBalls(0, 0, s, notS, ball, balls, strikesBalls, question);
		}
		
		// strikesBalls 의 각 원소에 대해서 가능한 정답의 집합을 result set 에 저장
		String numList = "123456789";
		int[] onOff;
		LinkedList<String> answer;
		for(String[] sb : strikesBalls) {
			// permutation to find possible answers
			onOff = new int[9];
			// out check
			for(int i=0; i<sb[2].length(); i++) {
				System.out.println("1onOffIndex:" + (Integer.valueOf(""+sb[3].charAt(Integer.valueOf(""+sb[2].charAt(i))))-1));
				onOff[Integer.valueOf(""+sb[3].charAt(Integer.valueOf(""+sb[2].charAt(i))))-1] = 1;
			}
			// strike check
			for(int i=0; i<sb[0].length(); i++) {
				System.out.println("2onOffIndex:" + (Integer.valueOf(""+sb[3].charAt(Integer.valueOf(""+sb[0].charAt(i))))-1));
				onOff[Integer.valueOf(""+sb[3].charAt(Integer.valueOf(""+sb[0].charAt(i))))-1] = 1;
			}
			answer = new LinkedList<String>();
			findPossibleAnswers(sb, result, numList, onOff, answer);
		}
		
		return result;
	}
	
	public void findPossibleAnswers(String[] sb, Set<String> result, String numList, int[] onOff, LinkedList<String> answer) {
		if(answer.size() == 3) {
			String a = "";
			Iterator<String> it = answer.iterator();
			while(it.hasNext()) {
				a += it.next();
			}
				
			if( ballCheck(a, sb[1], sb[3]) ) {
				System.out.println("a:" + a);
				result.add(a);
			}
			return;
		}
		
		// strike check
		System.out.println("1answer.size():" + answer.size() + ", sb[0]:" + sb[0]);
		if(sb[0].contains(""+answer.size())) {
			int temp = Integer.valueOf(""+sb[3].charAt(answer.size()));
			System.out.println("2answer.size():" + answer.size() + ", sb[0]:" + sb[0] + ", temp:" + temp);
			answer.add(""+temp);
			findPossibleAnswers(sb, result, numList, onOff, answer);
			answer.removeLast();
			return;
		}
		
		for(int i=0; i<numList.length(); i++) {
			
			if(onOff[i] == 0) {
				// ball check
				if(sb[1].contains(""+answer.size()) && sb[3].charAt(answer.size()) == numList.charAt(i)) {
					System.out.println("ball check - answer.size():" + answer.size() + ", sb[1]:" + sb[1] + ", temp:" + sb[3].charAt(answer.size()));
					continue;
				}
				
				onOff[i] = 1;
				answer.add(""+numList.charAt(i));
				findPossibleAnswers(sb, result, numList, onOff, answer);
				answer.removeLast();
				onOff[i] = 0;
			}
		}
	}
	
	public boolean ballCheck(String s, String ball, String question) {
		boolean result = true;
		
		// ball contaion check
		for(char b : ball.toCharArray()) {
			if(!s.contains(""+question.charAt(Integer.valueOf(""+b)))) {
				return false;
			}
		}
		// ball position check
		for(int i=0; i<ball.length(); i++) {
			if(s.charAt(Integer.valueOf(""+ball.charAt(i))) == question.charAt(Integer.valueOf(""+ball.charAt(i)))) {
				return false;
			}
		}
		
		return result;
	}
	
	public String findOut(String strike, String ball) {
		String result = "";
		
		if(!strike.contains("0") && !ball.contains("0")) {
			result += "0";
		}
		if(!strike.contains("1") && !ball.contains("1")) {
			result += "1";
		}
		if(!strike.contains("2") && !ball.contains("2")) {
			result += "2";
		}
		
		return result;
	}
	
	public void makeBalls(int index, int target, String strikes, String notStrikes, int ballCount, String[] value, Set<String[]> strikesBalls, String question) {
		if(ballCount == 0) {
			String[] result = new String[4];
			result[0] = strikes;
			String temp = "";
			for(String s : value) {
				temp += s;
			}
			result[1] = temp;
			result[2] = findOut(result[0], result[1]);
			result[3] = question;
			System.out.println("Strikes:" + result[0] + ", balls:" + result[1] + ", out:" + result[2] + ", question:" + result[3]);
			strikesBalls.add(result);
			return;
		}
		
		if(target == notStrikes.length()) {
			return;
		}
		
		value[index] = ""+notStrikes.charAt(target);
		
		makeBalls(index+1, target+1, strikes, notStrikes, ballCount-1, value, strikesBalls, question);
		makeBalls(index, target+1, strikes, notStrikes, ballCount, value, strikesBalls, question);
		
		return ;
	}
	
	public String notStrikes(String strikes) {
		String result = "";
		if(!strikes.contains("0")) {
			result += "0";
		}
		if(!strikes.contains("1")) {
			result += "1";
		}
		if(!strikes.contains("2")) {
			result += "2";
		}
		return result;
	}
	
	public void makeIndex(int index, int target, String str, int length, String[] value, Set<String> result) {
		if(length == 0) {
			String temp = "";
			for(String s : value) {
				temp += s;
			}
			result.add(temp);
			System.out.println(temp);
			return;
		}
		
		if(target == str.length()) {
			return;
		}
		
		value[index] = ""+str.charAt(target);
		
		makeIndex(index+1, target+1, str, length-1, value, result);
		makeIndex(index, target+1, str, length, value, result);
	}
	
	public void makeIndex(String prefix, String str, int length, Set<String> result) {
		if(prefix != null && prefix.length() == length) {
			result.add(prefix);
			System.out.println(prefix);
		}
		else if(prefix.length() < length) {
			for(int i=0; i<str.length(); i++) {
				makeIndex(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()), length, result);
			}
		}
	}

}
