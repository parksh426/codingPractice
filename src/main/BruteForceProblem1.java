package main;

public class BruteForceProblem1 {

	/*
���� ����


�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
-������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
-������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
-���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.

����� ��


answers

return


[1,2,3,4,5] [1] 
[1,3,2,4,2] [1,2,3] 

����� �� ����

����� �� #1
-������ 1�� ��� ������ �������ϴ�.
-������ 2�� ��� ������ Ʋ�Ƚ��ϴ�.
-������ 3�� ��� ������ Ʋ�Ƚ��ϴ�.

���� ���� ������ ���� ���� ����� ������ 1�Դϴ�.

����� �� #2
-��� ����� 2�������� ������ϴ�.

	 */
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int tempIndex = 0;
        
        for(int i=0; i<answers.length; i++) {
        	tempIndex = i % first.length;
        	if(first[tempIndex] == answers[i]) {
        		count1++;
        	}
        	tempIndex = i % second.length;
        	if(second[tempIndex] == answers[i]) {
        		count2++;
        	}
        	tempIndex = i % third.length;
        	if(third[tempIndex] == answers[i]) {
        		count3++;
        	}
        }
        int max = Math.max(count1, count2);
        max = Math.max(max,  count3);
        String result = "";
        if(count1 == max) {
        	if(result.equals("")) {
        		result = "1";
        	}
        	else {
        		result += ",1";
        	}
        }
        if(count2 == max) {
        	if(result.equals("")) {
        		result = "2";
        	}
        	else {
        		result += ",2";
        	}
        }
        if(count3 == max) {
        	if(result.equals("")) {
        		result = "3";
        	}
        	else {
        		result += ",3";
        	}
        }
        String[] results = result.split(",");
        answer = new int[results.length];
        for(int i=0; i<results.length; i++) {
        	answer[i] = Integer.valueOf(results[i]);
        }
        
        
        return answer;
    }
}
