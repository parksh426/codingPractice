package main;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapProgram2 {
	
/*

���� ����


��� ���忡���� �Ϸ翡 �а��縦 1�澿 ����մϴ�. ���� �а��縦 ���޹޴� ������ �������� ������ k�� ���Ŀ��� �а��縦 ���޹��� �� �ֱ� ������ �ؿ� ���忡�� �а��縦 �����ؾ� �մϴ�.

�ؿ� ���忡���� ���� �а��縦 ������ �� �ִ� ��¥�� ������ �˷��־���, ��� ���忡���� ��ۺ� ���̱� ���� �ּ����� Ƚ���� �а��縦 ���޹ް� �ͽ��ϴ�.

���� ���忡 �����ִ� �а��� ���� stock, �а��� ���� ����(dates)�� �ش� ������ ���� ������ �а��� ����(supplies), ���� �������κ��� ���޹��� �� �ִ� ���� k�� �־��� ��, �а��簡 �������� �ʰ� ������ ��ϱ� ���ؼ� �ּ��� �� �� �ؿ� �������κ��� �а��縦 ���޹޾ƾ� �ϴ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

dates[i]���� i��° ���� �������� ���������, supplies[i]���� dates[i] ��¥�� ���� ������ �а��� ������ ��� �ֽ��ϴ�.

���ѻ���
-stock�� �ִ� �а���� ����(0�� ����)���� ���˴ϴ�.
-stock�� k�� 2 �̻� 100,000 �����Դϴ�.
-dates�� �� ���Ҵ� 1 �̻� k �����Դϴ�.
-supplies�� �� ���Ҵ� 1 �̻� 1,000 �����Դϴ�.
-dates�� supplies�� ���̴� 1 �̻� 20,000 �����Դϴ�.
-k�� °���� �а��簡 ����� ���޵Ǳ� ������ k-1�Ͽ� ����� ���������� Ȯ���ϸ� �˴ϴ�.
-dates�� ����ִ� ��¥�� �������� ���ĵǾ� �ֽ��ϴ�.
-dates�� ����ִ� ��¥�� ���޵Ǵ� �а���� �۾� ���� �� ������ ���޵Ǵ� ���� �������� �մϴ�. ���� ��� 9��°�� �а��簡 �ٴڳ�����, 10��°�� ���޹����� 10��°���� ������ ��� �� �ֽ��ϴ�.
-�а��簡 �ٴڳ��� ���� �־����� �ʽ��ϴ�.

����� ��


stock

dates

supplies

k

result


4 [4,10,15] [20,5,10] 30 2 

����� �� ����
-���� �а��簡 4�� ���� �ֱ� ������ ���ð� 1�� ��~3�� �ı��� ����ϰ� ���� ��� �а��縦 �� ����մϴ�. ���� 4�� �Ŀ��� �ݵ�� �а��縦 ���޹޾ƾ� �մϴ�.
-4��° ���޹ް� ���� 15�� ���� ��ħ���� 9���� �а��簡 �����ְ� �ǰ�, �̶� 10���� �� ���޹����� 19���� �����ְ� �˴ϴ�. 15�� ���ĺ��� 29�� ���ı��� �ʿ��� �а���� 15���̹Ƿ� �� �̻��� ������ �ʿ� �����ϴ�.
-���� �� 2ȸ�� �а��縦 ���޹����� �˴ϴ�.


 */
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		System.out.println("solution start!" + stock + ", " + k);
		int answer = 0;
		
		int nextDateLimit = stock;
		int index = 0;
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
		
//		PriorityQueue<Integer> pqueue = new PriorityQueue<>(new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
		
		while(nextDateLimit < k) {
			
			for(; index<dates.length; index++) {
				if(dates[index] <= nextDateLimit) {					
					pqueue.add(supplies[index]);
					if(nextDateLimit + pqueue.peek() >= k) {
						System.out.println(nextDateLimit + pqueue.peek());
						answer++;
						return answer;
					}
				}
				else {
					break;
				}
			}
			nextDateLimit += pqueue.poll();
			answer++;
			System.out.println(nextDateLimit);
		}
				
		return answer;
	}
	
	public static int solution2(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0; 
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder()); 
        int start = 0; 
        //k ���� ���� ���߾� ��. 
        for(int i = 0; i < k; i++) {
            stock --; // ��� ����. 

            //������ �ִ� stock�� �׳� �������ٸ�, i+1 �� ���� ������ �޾ƾ��Ѵ�. 
            if(stock == 0) {
                int j = start; 
                while(j < dates.length && dates[j] <= i+1) {
                    pqueue.offer(supplies[j]); 
                    j ++; 
                }

                start = j;
                answer ++;
                stock += pqueue.poll();
            }

        }
        return answer;
    }
}
