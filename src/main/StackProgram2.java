package main;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackProgram2 {

	/*
���� ����


Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
�� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.

���� ���, ���̰� 2�̰� 10kg ���Ը� �ߵ�� �ٸ��� �ֽ��ϴ�. ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.


��� �ð�

�ٸ��� ���� Ʈ��

�ٸ��� �ǳʴ� Ʈ��

��� Ʈ��


0 [] [] [7,4,5,6] 
1~2 [] [7] [4,5,6] 
3 [7] [4] [5,6] 
4 [7] [4,5] [6] 
5 [7,4] [5] [6] 
6~7 [7,4,5] [6] [] 
8 [7,4,5,6] [] [] 

����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.

solution �Լ��� �Ű������� �ٸ� ���� bridge_length, �ٸ��� �ߵ� �� �ִ� ���� weight, Ʈ���� ���� truck_weights�� �־����ϴ�. �̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
-bridge_length�� 1 �̻� 10,000 �����Դϴ�.
-weight�� 1 �̻� 10,000 �����Դϴ�.
-truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
-��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.

����� ��


bridge_length

weight

truck_weights

return


2 10 [7,4,5,6] 8 
100 100 [10] 101 
100 100 [10,10,10,10,10,10,10,10,10,10] 110 

	 */
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
//        Queue<Integer> bridge = new Deque<Integer>();
        Deque<Integer> bridge = new ArrayDeque<Integer>();
        
        if( truck_weights == null || truck_weights.length < 1 || truck_weights[0] > weight ) {
        	return answer;
        }
        
        for(int i=0; i<bridge_length; i++) {
			bridge.add(0);
		}
        
        int index = 0;
        int totalWeight = 0;
        do{
        	if( bridge.size() > 0 ) {
        		totalWeight -= bridge.pop();
        		answer++;
        	}
        	
        	if(index < truck_weights.length && totalWeight + truck_weights[index] <= weight && bridge_length > bridge.size()) {
        		bridge.add(truck_weights[index]);
        		totalWeight += truck_weights[index];
        		index++;
        	}
        	else {
        		if(totalWeight > 0 && index < truck_weights.length) {
        			bridge.add(0);
        		}
        	}
        }
        while(bridge.size() > 0);
        
        return answer;
    }
}
