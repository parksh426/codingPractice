package main;

import java.util.Arrays;

public class SortProblem3 {

	/*

���� ����


H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.

� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index�Դϴ�.

� �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-�����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
-���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.

����� ��


citations

return


[3, 0, 6, 1, 5] 3 

����� �� ����

�� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�. �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.


	 */
	
	public int solution1(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		int total = 0;
		//int tempH = citations[citations.length-1];
		int index = citations.length-1;
		
		for(int i=citations[citations.length-1]; i>=0; i--) {
			if(i <= total) {
				return i;
			}
			while(index >= 0 && i == citations[index]) {
				total++;
				index--;
				System.out.println("tempH:" + i + ", total:" + total);
				
				if(i <= total) {
					return i;
				}
			}
			
		}
		
		return answer;
	}
	
	public int solution(int[] citations) {
		System.out.println("solution start.");
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
            System.out.println("max:" + max);
        }

        return max;
    }

}
