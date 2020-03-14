package main;

public class BruteForceProblem3_2 {

	/*
���� ����


���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�. �����غ���

���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�. �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.

	 * ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
	 * ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ
	 * ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�


���� ���, �Ʒ��� ��찡 ������

A : 123
B : 1��Ʈ����ũ 1��.
A : 356
B : 1��Ʈ����ũ 0��.
A : 327
B : 2��Ʈ����ũ 0��.
A : 489
B : 0��Ʈ����ũ 1��.


�̶� ������ ���� 324�� 328 �� �����Դϴ�.

������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-������ ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
-baseball�� �� ���� [�� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ��] �� ��� �ֽ��ϴ�.

����� ��


baseball

return


[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] 2 

����� �� ����

������ ���� ���� �����ϴ�.

	 */

	public int solution(int[][] baseball) {
		int ans = 0;

		for (int i=123; i<=987; i++) {
			int a, b, c;
			a = i % 10;
			b = i/10 % 10;
			c = i / 100;
			if (a == b || b == c || a == c || b == 0 || a == 0) continue;
			boolean flag = true;
			for (int j=0; j<baseball.length; j++) {
				if (!isCorrect(i, baseball[j][0], baseball[j][1], baseball[j][2])) {
					flag = false;
					break;
				}
			}
			if (flag) 
				ans++;
		}

		return ans;
	}

	static boolean isCorrect(int i, int q, int strike, int ball) {
		int a, b, c, A, B, C, strikeCnt = 0, ballCnt = 0;
		a = i % 10; 
		b = i/10 % 10; 
		c = i / 100; 
		A = q % 10;
		B = q/10 % 10;
		C = q / 100;

		if (a == A) strikeCnt++;
		if (b == B) strikeCnt++;
		if (c == C) strikeCnt++;
		if (a != A && (a == B || a == C)) ballCnt++;
		if (b != B && (b == A || b == C)) ballCnt++;
		if (c != C && (c == A || c == B)) ballCnt++;

		if (strikeCnt == strike && ballCnt == ball) return true;
		return false;
	}
}
