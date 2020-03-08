package main;

import java.util.Arrays;

public class SortProblem1 {

	/*

���� ����


�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
1.array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
2.1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
3.2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.

�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-array�� ���̴� 1 �̻� 100 �����Դϴ�.
-array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
-commands�� ���̴� 1 �̻� 50 �����Դϴ�.
-commands�� �� ���Ҵ� ���̰� 3�Դϴ�.

����� ��


array

commands

return


[1, 5, 2, 6, 3, 7, 4] [[2, 5, 3], [4, 4, 1], [1, 7, 3]] [5, 6, 3] 

����� �� ����

[1, 5, 2, 6, 3, 7, 4]�� 2��°���� 5��°���� �ڸ� �� �����մϴ�. [2, 3, 5, 6]�� �� ��° ���ڴ� 5�Դϴ�.
 [1, 5, 2, 6, 3, 7, 4]�� 4��°���� 4��°���� �ڸ� �� �����մϴ�. [6]�� ù ��° ���ڴ� 6�Դϴ�.
 [1, 5, 2, 6, 3, 7, 4]�� 1��°���� 7��°���� �ڸ��ϴ�. [1, 2, 3, 4, 5, 6, 7]�� �� ��° ���ڴ� 3�Դϴ�.


	 */
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tempCommand;
        int[] temp;
        
        for(int i=0; i<commands.length; i++) {
        	tempCommand = commands[i];
        	temp = new int[tempCommand[1]-tempCommand[0]+1];
        	for(int j=0; j<temp.length; j++) {
        		temp[j] = array[j+tempCommand[0]-1];
        	}
        	Arrays.sort(temp);
        	answer[i] = temp[tempCommand[2]-1];
        }
        
        return answer;
    }
	
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
	
}