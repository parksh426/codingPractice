package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapProgram4 {

	/*
���� ����


���� �켱���� ť�� ���� ������ �� �� �ִ� �ڷᱸ���� ���մϴ�.


��ɾ�

���� ž(����)


I ���� ť�� �־��� ���ڸ� �����մϴ�. 
D 1 ť���� �ִ��� �����մϴ�. 
D -1 ť���� �ּڰ��� �����մϴ�. 

���� �켱���� ť�� �� ���� operations�� �Ű������� �־��� ��, ��� ������ ó���� �� ť�� ��������� [0,0] ������� ������ [�ִ�, �ּڰ�]�� return �ϵ��� solution �Լ��� �������ּ���.

���ѻ���
-operations�� ���̰� 1 �̻� 1,000,000 ������ ���ڿ� �迭�Դϴ�.
-operations�� ���Ҵ� ť�� ������ ������ ��Ÿ���ϴ�. 
  -- ���Ҵ� "��ɾ� ������" �������� �־����ϴ�.- �ִ�/�ּڰ��� �����ϴ� ���꿡�� �ִ�/�ּڰ��� �� �̻��� ���, �ϳ��� �����մϴ�.

-�� ť�� �����͸� �����϶�� ������ �־��� ���, �ش� ������ �����մϴ�.

����� ��


operations

return


["I 16","D 1"] [0,0] 
["I 7","I 5","I -5","D -1"] [7,5] 

����� �� ����

16�� ���� �� �ִ��� �����մϴ�. ��������Ƿ� [0,0]�� ��ȯ�մϴ�.
7,5,-5�� ���� �� �ּڰ��� �����մϴ�. �ִ밪 7, �ּҰ� 5�� ��ȯ�մϴ�.

	 */
	
	
	
	public int[] solution(String[] operations) {
        int[] answer = {};
        
        List<Integer> list = new LinkedList<Integer>();
        String temp;
        String[] operTemp;
        boolean sorted = false;
        
        for(int i=0; i<operations.length; i++) {
        	temp = operations[i];
        	operTemp = temp.split(" ");
        	switch (operTemp[0]) {
        	case "I":
        		list.add(Integer.valueOf(operTemp[1]));
        		sorted = false;
            	break;
        	case "D":
        		if(list != null && list.size() > 0) {
        			if(!sorted) {
            			Collections.sort(list);
                		sorted = true;
            		}
            		if(operTemp[1].startsWith("-")) {
            			list.remove(0);
            		}
            		else {
            			list.remove(list.size()-1);
            		}
        		}
        		break;
        	}
        }
        
        if(list == null || list.size() == 0) {
        	answer = new int[] {0, 0};
        }
        else {
        	if(!sorted) {
        		Collections.sort(list);
        	}
        	answer = new int[] {list.get(list.size()-1), list.get(0)};
        }
        
        return answer;
    }
	
	public int[] solution2(String[] arguments) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<arguments.length; i++) {
            String temp[] = arguments[i].split(" ");
            switch(temp[0]) {
            case "I" : 
                pq.add(Integer.parseInt(temp[1]));
                reverse_pq.add(Integer.parseInt(temp[1]));
                break;
            case "D" :
                if(pq.size() > 0) {
                    if(Integer.parseInt(temp[1]) == 1) {
                        // �ִ� ����
                        int max = reverse_pq.poll();
                        pq.remove(max);
                    } else {
                        // �ּڰ� ����
                        int min = pq.poll();
                        reverse_pq.remove(min);
                    }
                }
                break;
            }
        }

        if(pq.size() >= 2) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }

        System.out.println(answer[0] + ":" + answer[1]);

        return answer;
    }
}
