package main;

import java.util.LinkedList;

public class StackProgram6 {


	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for(int i=0; i<prices.length; i++) {
			answer[i] = -1;
		}

		for(int i=0; i<prices.length; i++) {
			for(int j=0; j<i; j++) {
				if(answer[j] == -1 && prices[j] > prices[i]) {
					answer[j] = i-j;
				}
			}
		}

		for(int i=0; i<prices.length; i++) {
			if(answer[i] == -1) {
				answer[i] = prices.length-i-1;
			}
		}

		return answer;
	}

	public static int[] solution2(int[] prices) {
		int[] answer = new int[prices.length];

		LinkedList<Integer> tempList = new LinkedList<>();
		
		tempList.add(0);
		
		for(int i=1; i<prices.length; i++) {
			for(int j=0; j<tempList.size(); j++) {
				if(prices[tempList.get(j)] > prices[i]) {
					answer[tempList.get(j)] = i - tempList.get(j);
					tempList.remove(j);
					--j;
				}
			}
			tempList.add(i);
		}
		
		for(int j=0; j<tempList.size(); j++) {
			answer[tempList.get(j)] = prices.length - tempList.get(j) -1;
		}
		
		return answer;
	}

}
