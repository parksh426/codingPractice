package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapProgram3 {

	/*

���� ����


�ϵ��ũ�� �� ���� �ϳ��� �۾��� ������ �� �ֽ��ϴ�. ��ũ ��Ʈ�ѷ��� �����ϴ� ����� ���� ������ �ֽ��ϴ�. ���� �Ϲ����� ����� ��û�� ���� ������� ó���ϴ� ���Դϴ�.

�������

- 0ms ������ 3ms�� �ҿ�Ǵ� A�۾� ��û
- 1ms ������ 9ms�� �ҿ�Ǵ� B�۾� ��û
- 2ms ������ 6ms�� �ҿ�Ǵ� C�۾� ��û


�� ���� ��û�� ���Խ��ϴ�. �̸� �׸����� ǥ���ϸ� �Ʒ��� �����ϴ�.
Screen Shot 2018-09-13 at 6.34.58 PM.png

�� ���� �ϳ��� ��û���� ������ �� �ֱ� ������ ������ �۾��� ��û���� ������� ó���ϸ� ������ ���� ó�� �˴ϴ�.
Screen Shot 2018-09-13 at 6.38.52 PM.png

- A: 3ms ������ �۾� �Ϸ� (��û���� ������� : 3ms)
- B: 1ms���� ����ϴٰ�, 3ms ������ �۾��� �����ؼ� 12ms ������ �۾� �Ϸ�(��û���� ������� : 11ms)
- C: 2ms���� ����ϴٰ�, 12ms ������ �۾��� �����ؼ� 18ms ������ �۾� �Ϸ�(��û���� ������� : 16ms)


�� �� �� �۾��� ��û���� ������� �ɸ� �ð��� ����� 10ms(= (3 + 11 + 16) / 3)�� �˴ϴ�.

������ A �� C �� B ������� ó���ϸ�
Screen Shot 2018-09-13 at 6.41.42 PM.png

- A: 3ms ������ �۾� �Ϸ�(��û���� ������� : 3ms)
- C: 2ms���� ����ϴٰ�, 3ms ������ �۾��� �����ؼ� 9ms ������ �۾� �Ϸ�(��û���� ������� : 7ms)
- B: 1ms���� ����ϴٰ�, 9ms ������ �۾��� �����ؼ� 18ms ������ �۾� �Ϸ�(��û���� ������� : 17ms)


�̷��� A �� C �� B�� ������ ó���ϸ� �� �۾��� ��û���� ������� �ɸ� �ð��� ����� 9ms(= (3 + 7 + 17) / 3)�� �˴ϴ�.

�� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�]�� ���� 2���� �迭 jobs�� �Ű������� �־��� ��, �۾��� ��û���� ������� �ɸ� �ð��� ����� ���� ���̴� ������� ó���ϸ� ����� �󸶰� �Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���. (��, �Ҽ��� ������ ���� �����ϴ�)

���� ����
-jobs�� ���̴� 1 �̻� 500 �����Դϴ�.
-jobs�� �� ���� �ϳ��� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�] �Դϴ�.
-�� �۾��� ���� �۾��� ��û�Ǵ� �ð��� 0 �̻� 1,000 �����Դϴ�.
-�� �۾��� ���� �۾��� �ҿ�ð��� 1 �̻� 1,000 �����Դϴ�.
-�ϵ��ũ�� �۾��� �����ϰ� ���� ���� ������ ���� ��û�� ���� �۾����� ó���մϴ�.

����� ��


jobs

return


[[0, 3], [1, 9], [2, 6]] 9 

����� �� ����

������ �־��� ���� �����ϴ�.
-0ms ������ 3ms �ɸ��� �۾� ��û�� ���ɴϴ�.
-1ms ������ 9ms �ɸ��� �۾� ��û�� ���ɴϴ�.
-2ms ������ 6ms �ɸ��� �۾� ��û�� ���ɴϴ�.


	 */
	
	
	public class JobCompare implements Comparator<int[]>{
		@Override
    	public int compare(int[] i1, int[] i2) {
			return i1[1] - i2[1];
    	}
	}
	
	public int solution(int[][] jobs) {
		System.out.println("solution start!");
        //int answer = 0;
        
        int time = 0;
        int total = 0;
        
        Arrays.sort(jobs,new Comparator<int[]>(){
        	@Override
        	public int compare(int[] one, int[] two){
        		if(one[0] == two[0]){
        			return Integer.compare(one[1],two[1]);
        		}
        		else{
        			return Integer.compare(one[0],two[0]);
        		}
        	}
        });
        
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(new JobCompare());
        
        int[] temp = null;
        int index = 0;
        
        while( index < jobs.length || pqueue.size() > 0 ) {
        	temp = pqueue.poll();
        	
        	if(temp == null) {
        		System.out.println(jobs[index][0] + ", " + jobs[index][1] + ", " + (jobs[index][1]) + ", " + (total + jobs[index][1]));
        		total += jobs[index][1];
        		time = jobs[index][0] + jobs[index][1];
        		index++;
        		
        		while( index < jobs.length && jobs[index][0] < time) {
        			pqueue.add(jobs[index]);
        			index++;
        		}
        	}
        	else {
        		System.out.println(temp[0] + ", " + temp[1] + ", " + (time-temp[0] + temp[1]) + ", " + (total + time-temp[0] + temp[1]));
        		total += time-temp[0] + temp[1];
    			time += temp[1];
    			
    			while( index < jobs.length && jobs[index][0] < time) {
    				pqueue.add(jobs[index]);
        			index++;
        		}
        	}        	
        }
        
        
        return (int)total/jobs.length;
    }
}
