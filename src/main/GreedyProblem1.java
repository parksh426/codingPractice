package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GreedyProblem1 {

	/*
���� ����


���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.

��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
-ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
-������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
-���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
-���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.

����� ��


n

lost

reserve

return


5 [2, 4] [1, 3, 5] 5 
5 [2, 4] [3] 4 
3 [3] [1] 2 

����� �� ����

���� #1
 1�� �л��� 2�� �л����� ü������ �����ְ�, 3�� �л��̳� 5�� �л��� 4�� �л����� ü������ �����ָ� �л� 5���� ü�������� ���� �� �ֽ��ϴ�.

���� #2
 3�� �л��� 2�� �л��̳� 4�� �л����� ü������ �����ָ� �л� 4���� ü�������� ���� �� �ֽ��ϴ�.

	 */
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Arrays.parallelSort(lost);
        Arrays.parallelSort(reserve);
        List<Integer> lostList = new LinkedList<Integer>(); 
        for(int j=0; j<lost.length; j++) {
        	lostList.add(lost[j]);
        }
        
        List<Integer> reserveList = new LinkedList<Integer>(); 
        for(int j=0; j<reserve.length; j++) {
        	reserveList.add(reserve[j]);
        }
        
        for(int x=0; x<lostList.size(); x++) {
        	int index = reserveList.indexOf(lostList.get(x));
        	if(index != -1) {
        		lostList.remove(x);
        		x--;
        		reserveList.remove(index);
        	}
        	
        }
        
        int i=0;
        int iReserve = 0;
        int temp;
        
        for(; i<lostList.size(); i++) {
        	temp = lostList.get(i);
        	
        	boolean found = false;
        	for(; iReserve<reserveList.size(); iReserve++) {
        		if(temp < reserveList.get(iReserve)-1) {
        			found = false;
        			break;
        		}
        		
        		if( temp == reserveList.get(iReserve)-1 || temp == reserveList.get(iReserve)+1 || temp == reserveList.get(iReserve)) {
        			iReserve++;
        			found = true;
        			break;
        		}
        	}
        	
        	if(found == false) {
        		answer--;
        	}
        	
        	if(iReserve >= reserveList.size()) {
        		i++;
        		break;
        	}
        }
        
        if(i<lostList.size()) {
        	answer = answer - (lostList.size()-i);
        }
        
        return answer;
    }
}
