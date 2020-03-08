package main;

import java.util.ArrayList;

public class StackProgram3 {

	/*
���� ����


���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.

��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.

���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
-�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
-�۾� ������ 100 �̸��� �ڿ����Դϴ�.
-�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
-������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.

����� ��


progresses

speeds

return


[93,30,55] [1,30,5] [2,1] 

����� �� ����

ù ��° ����� 93% �Ϸ�Ǿ� �ְ� �Ϸ翡 1%�� �۾��� �����ϹǷ� 7�ϰ� �۾� �� ������ �����մϴ�.
�� ��° ����� 30%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 30%�� �۾��� �����ϹǷ� 3�ϰ� �۾� �� ������ �����մϴ�. ������ ���� ù ��° ����� ���� �ϼ��� ���°� �ƴϱ� ������ ù ��° ����� �����Ǵ� 7��° �����˴ϴ�.
�� ��° ����� 55%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 5%�� �۾��� �����ϹǷ� 9�ϰ� �۾� �� ������ �����մϴ�. 

���� 7��°�� 2���� ���, 9��°�� 1���� ����� �����˴ϴ�.


	 */
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		
		ArrayList<Integer> result = new ArrayList<>();
		int currentDay = 0;
		int tempDay = -1;
		int temp = 0;
		
		for(int i=0; i<progresses.length; i++) {
			tempDay = (int) Math.ceil((100-progresses[i])/speeds[i]);
			//System.out.println("tempDay:"+tempDay);
			if(i==0) {
				currentDay = tempDay;
				temp = 1;
			}
			else {
				if(currentDay >= tempDay) {
					temp++;
				}
				else {
					result.add(temp);
					currentDay = tempDay;
					temp = 1;
				}
			}
		}
		result.add(temp);
		
		answer = new int[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
}
