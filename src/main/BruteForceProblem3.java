package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class BruteForceProblem3 {
	
	/*
���� ����


���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�. �����غ���

���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�. �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.

* ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
* ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ
* ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�


���� ���, �Ʒ��� ��찡 ������

A : 123
B : 1��Ʈ����ũ 1��.
A : 356
B : 1��Ʈ����ũ 0��.
A : 327
B : 2��Ʈ����ũ 0��.
A : 489
B : 0��Ʈ����ũ 1��.


�̶� ������ ���� 324�� 328 �� �����Դϴ�.

������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-������ ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
-baseball�� �� ���� [�� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ��] �� ��� �ֽ��ϴ�.

����� ��


baseball

return


[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] 2 

����� �� ����

������ ���� ���� �����ϴ�.

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
		
		// strikesBalls �� �� ���ҿ� ���ؼ� ������ ������ ������ result set �� ����
		String numList = "123456789";
		int[] onOff;
		LinkedList<String> answer;
		for(String[] sb : strikesBalls) {
			// permutation to find possible answers
			onOff = new int[9];
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
			System.out.println("a:" + a);
			result.add(a);
			return;
		}
		
		for(int i=0; i<numList.length(); i++) {
			if(onOff[i] == 0) {
				onOff[i] = 1;
				answer.add(""+numList.charAt(i));
				findPossibleAnswers(sb, result, numList, onOff, answer);
				answer.removeLast();
				onOff[i] = 0;
			}
		}
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
