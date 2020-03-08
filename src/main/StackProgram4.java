package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackProgram4 {

	/*
���� ����


�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.

1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
3. �׷��� ������ J�� �μ��մϴ�.


���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.

���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.

���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
-�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
-location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.

����� ��


priorities

location

return


[2, 1, 3, 2] 2 1 
[1, 1, 9, 1, 1, 1] 0 5 

����� �� ����

���� #1

������ ���� ���� �����ϴ�.

���� #2

6���� ����(A, B, C, D, E, F)�� �μ� ����Ͽ� �ְ� �߿䵵�� 1 1 9 1 1 1 �̹Ƿ� C D E F A B ������ �μ��մϴ�. 



	 */
	
    public static int solution(int[] priorities, int location) {
    	//System.out.println("---start---");
        int answer = 0;
        int locIndex = location;
        
        LinkedList<Integer> list = new LinkedList<>();
        int maxPriorities = 0;
        for(int i=0; i < priorities.length; i++) {
        	if(maxPriorities < priorities[i]) {
        		maxPriorities = priorities[i];
        	}
        	list.add(priorities[i]);
        }
        
        int temp = 0;
        while(true) {
        	temp = list.removeFirst();
        	locIndex--;
        	//System.out.println("temp:" + temp + ", locIndex:" + locIndex);
        	if(temp >= maxPriorities) {
        		answer++;
        		maxPriorities = getMaxPriority(list);
        		if(locIndex < 0) {
        			break;
        		}
        	}
        	else {
        		list.add(temp);
        		if(locIndex < 0) {
        			locIndex = list.size()-1;
        		}
        	}
        }
        
        return answer;
    }
    
    public static int getMaxPriority(List<Integer> list) {
    	int maxPriority = 0;
        for(int i=0; i < list.size(); i++) {
        	if(maxPriority < list.get(i)) {
        		maxPriority = list.get(i);
        	}
        }
        return maxPriority;
    }
    
    public int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
