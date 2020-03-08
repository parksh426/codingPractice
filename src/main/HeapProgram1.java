package main;

import java.util.PriorityQueue;

public class HeapProgram1 {

	/*

���� ����


�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.

���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)


Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
-scoville�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
-K�� 0 �̻� 1,000,000,000 �����Դϴ�.
-scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
-��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.

����� ��


scoville

K

return


[1, 2, 3, 9, 10, 12] 7 2 

����� �� ����

1.���ں� ������ 1�� ���İ� 2�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 1 + (2 * 2) = 5
���� ������ ���ں� ���� = [5, 3, 9, 10, 12]


2.���ں� ������ 3�� ���İ� 5�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 3 + (5 * 2) = 13
���� ������ ���ں� ���� = [13, 9, 10, 12]


��� ������ ���ں� ������ 7 �̻��� �Ǿ��� �̶� ���� Ƚ���� 2ȸ�Դϴ�.



	 */
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i=0; i<scoville.length; i++) {
        	queue.add(scoville[i]);
        }
        if(queue.peek() >= K) {
        	return 0;
        }
        
        Integer tempMin1 = 0;
        Integer tempMin2 = 0;
        boolean solved = false;
        
        while(queue.size() >= 1) {
        	tempMin1 = queue.poll();
        	if(tempMin1 < K) {
        		if(queue.peek() != null) {
        			tempMin2 = queue.poll();
            		queue.add(tempMin1 + (tempMin2*2));
            		answer++;
//            		System.out.println(tempMin1 + ", " + tempMin2 + ", " + (tempMin1 + (tempMin2*2)));
        		}
        	}
        	else {
        		solved = true;
        	}
        }
        
        return solved ? answer : -1;
    }
	
}
