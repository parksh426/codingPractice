package main;

import java.util.Stack;

public class StackProgram1 {

	
	/*
���� ����


���� ������ ž N�븦 �������ϴ�. ��� ž�� ����⿡�� ��ȣ�� ��/�����ϴ� ��ġ�� ��ġ�߽��ϴ�. �߻��� ��ȣ�� ��ȣ�� ���� ž���� ���� ž������ �����մϴ�. ����, �� �� ���ŵ� ��ȣ�� �ٸ� ž���� �۽ŵ��� �ʽ��ϴ�.

���� ��� ���̰� 6, 9, 5, 7, 4�� �ټ� ž�� �������� ���ÿ� ������ ��ȣ�� �߻��մϴ�. �׷���, ž�� ������ ���� ��ȣ�� �ְ�޽��ϴ�. ���̰� 4�� �ټ� ��° ž���� �߻��� ��ȣ�� ���̰� 7�� �� ��° ž�� �����ϰ�, ���̰� 7�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž��, ���̰� 5�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž�� �����մϴ�. ���̰� 9�� �� ��° ž�� ���̰� 6�� ù ��° ž�� ���� ������ ��ȣ�� � ž������ ������ �� �����ϴ�.


�۽� ž(����)

���� ž(����)


5(4) 4(7) 
4(7) 2(9) 
3(5) 2(9) 
2(9) - 
1(6) - 

�� ���ʺ��� ������� ž�� ���̸� ���� �迭 heights�� �Ű������� �־��� �� �� ž�� �� ��ȣ�� ��� ž���� �޾Ҵ��� ����� �迭�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
-heights�� ���� 2 �̻� 100 ������ ���� �迭�Դϴ�.
-��� ž�� ���̴� 1 �̻� 100 �����Դϴ�.
-��ȣ�� �����ϴ� ž�� ������ 0���� ǥ���մϴ�.

����� ��


heights

return


[6,9,5,7,4] [0,0,2,2,4] 
[3,9,9,3,5,7,2] [0,0,0,3,3,3,6] 
[1,5,3,6,7,6,5] [0,0,2,0,0,5,6] 

����� �� ����

����� �� #1
�ռ� ������ ���� �����ϴ�.

����� �� #2

[1,2,3] ��° ž�� �� ��ȣ�� �ƹ��� �������� �ʽ��ϴ�.
 [4,5,6] ��° ž�� �� ��ȣ�� 3��° ž�� �����մϴ�.
 [7] ��° ž�� �� ��ȣ�� 6��° ž�� �����մϴ�.

����� �� #3

[1,2,4,5] ��° ž�� �� ��ȣ�� �ƹ��� �������� �ʽ��ϴ�.
 [3] ��° ž�� �� ��ȣ�� 2��° ž�� �����մϴ�.
 [6] ��° ž�� �� ��ȣ�� 5��° ž�� �����մϴ�.
 [7] ��° ž�� �� ��ȣ�� 6��° ž�� �����մϴ�.


	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] solution(int[] heights) {
        //int[] answer = {};
        int[] answer = new int[heights.length];
        
        int pIndex = -1;
        
        for(int i=0; i<heights.length; i++) {
        	if( i == 0 ) {
        		answer[i] = 0;
        	}
        	else if(heights[i-1] == heights[i]) {
        		answer[i] = answer[i-1]; 
        	}
        	else if(heights[i-1] > heights[i]) {
        		answer[i] = i; 
        		pIndex = i-1;
        	}
        	else if(heights[i-1] < heights[i]) {
        		int tempIndex = pIndex;
        		while(tempIndex >= 0) {
        			if(heights[tempIndex] > heights[i]) {
        				answer[i] = tempIndex + 1;
        				pIndex = tempIndex;
        				break;
        			}
        			else if(heights[tempIndex] == heights[i]) {
        				answer[i] = answer[tempIndex];
        				pIndex = tempIndex;
        				break;
        			}
        			else if(heights[tempIndex] < heights[i]) {
        				tempIndex = answer[tempIndex]-1;
        				if(tempIndex < 0) {
        					answer[i] = 0;
        					pIndex = -1;
        					break;
        				}
        			}
        		}
        	}
        }
        
        
        return answer;
    }
	
    class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "idx : " + idx + " height : " + height;
        }
    }

    public int[] solution2(int[] heights) {
        Stack<Tower> st = new Stack<>();
        int[] answer = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            Tower tower = new Tower(i + 1, heights[i]);
            int receiveIdx = 0;

            while (!st.isEmpty()) {
                Tower top = st.peek();

                if (top.height > tower.height) {
                    receiveIdx = top.idx;
                    break;
                }

                st.pop();
            }

            st.push(tower);
            answer[i] = receiveIdx;
        }

        return answer;
    }

}
