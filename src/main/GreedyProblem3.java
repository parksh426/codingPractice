package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GreedyProblem3 {

	/*
���� ����


� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.

���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
-number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
-k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.

����� ��


number

k

return


��1924�� 2 ��94�� 
��1231234�� 3 ��3234�� 
��4177252841�� 4 ��775841�� 

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
			// ���� ���ϴ� ���
			findMaxNumber2(number.substring(1), selected+number.charAt(0), k, maxNum, length);
			// �����ϴ� ���
			findMaxNumber2(number.substring(1), selected, k-1, maxNum, length);
		}
	}
}
