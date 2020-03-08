package main;

import java.util.HashSet;
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
		
		return result;
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
