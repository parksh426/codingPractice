package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GreedyProblem3 {

	/*
문제 설명


어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
-number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
-k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예


number

k

return


“1924” 2 “94” 
“1231234” 3 “3234” 
“4177252841” 4 “775841” 

	 */

	
	public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

	
	public String solution2(String number, int k) {
		System.out.println(String.format("solution started. number[%s], k[%d]", number, k));
		//String answer = "";
		StringBuilder tempAnswer = new StringBuilder();
		int length = number.length() - k;
		String numbers = number;
		String[] result = new String[2];
		
		while(tempAnswer.length() < length) {
			findMaxNumber(0, numbers.length()-(length-tempAnswer.length()), numbers, result);
			System.out.println(String.format("temps[0]:%s, temps[1]:%s", result[0], result[1]));
			tempAnswer.append(result[0]);
			numbers = result[1];
		}
		
		return tempAnswer.toString();
	}
	
	public void findMaxNumber(int start, int end, String s, String[] resultArray) {
		System.out.println(String.format("findMaxNumber start:%d, end:%d, s:[%s]", start, end, s));
		char c = ' ';
		char temp;
		int index = start;
		for(int i=start; i<=end; i++) {
			temp = s.charAt(i);
			if(i == start) {
				c = s.charAt(i);
				index = i;
			}
			else {
				if(c < temp) {
					c = temp;
					index = i;
				}
			}
			if(c == '9') {
				break;
			}
		}
		resultArray[0] = ""+c;
		resultArray[1] = s.substring(index+1);
	}
	
	
	
	
	
	
	
	
	public String solution3String(String number, int k) {
		System.out.println("solution started.");
		//String answer = "";
		List<Integer> maxNum = new LinkedList<Integer>();
		int length = number.length() - k;
		
		findMaxNumber2(number, "", k, maxNum, length);
		
		return maxNum.get(0).toString();
	}
	
	public void findMaxNumber2(String number, String selected, int k, List<Integer> maxNum, int length) {
		if(k==0) {
			if(selected.length() == length) {
				int tempSelected = Integer.valueOf(selected);
				if(maxNum.size() == 0) {
					maxNum.add(tempSelected);
					System.out.println("" + tempSelected);
				}
				else {
					if(maxNum.get(0) < tempSelected) {
						maxNum.remove(0);
						maxNum.add(tempSelected);
						System.out.println("" + tempSelected);
					}
				}
				return;
			}
		}
		
		if(number.length() > 0) {
			// 제거 안하는 경우
			findMaxNumber2(number.substring(1), selected+number.charAt(0), k, maxNum, length);
			// 제거하는 경우
			findMaxNumber2(number.substring(1), selected, k-1, maxNum, length);
		}
	}
}
