package main;

import java.util.Arrays;
import java.util.Comparator;

public class SortProblem2 {
	
	/*

���� ����


0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.

0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
-numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
-numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
-������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.

����� ��


numbers

return


[6, 10, 2] ��6210�� 
[3, 30, 34, 5, 9] ��9534330�� 


	 */


	public String solution(int[] numbers) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		
		Integer[] newNumbers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		
		Arrays.sort(newNumbers, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer i1, Integer i2) {
				String s1 = String.valueOf(i1);
				String s2 = String.valueOf(i2);
				return (s1+s2).compareTo(s2+s1);
			}
		});
		
		for(int i=newNumbers.length-1; i>=0; i--) {
			sb.append(newNumbers[i]);
		}
		
		answer = sb.toString();
		if(answer.startsWith("0")) {
			answer = "0";
		}
		
		return answer;
	}

}
