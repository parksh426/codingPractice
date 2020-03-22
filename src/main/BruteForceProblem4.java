package main;

public class BruteForceProblem4 {

	/*
���� ����


Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ���������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.

image.png

Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� �������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.

Leo�� �� ī�꿡�� ���� ������ �� brown, ������ ������ �� red�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
-������ ������ �� red�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
-ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.

����� ��


brown

red

return


10 2 [4, 3] 
8 1 [3, 3] 
24 24 [8, 6] 

	 */

	public int[] solution(int brown, int red) {
		int[] answer = {};
		
		int x=0, y=0;
		
		for(int i=(brown+red); i>=1; i--) {
			if((brown+red) % i == 0) {
				x = i;
				y = (brown+red) / i;
				
				if( y > x ) {
					break;
				}
				
				if( (x >= 3 && y >= 3) && (x-2)*(y-2) == red) {
					return new int[] {x, y};
				}
			}
		}
		
		
		return answer;
	}
}