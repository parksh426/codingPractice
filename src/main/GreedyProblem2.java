package main;

public class GreedyProblem2 {

	/*
���� ����


���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA

���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.

�� - ���� ���ĺ�
�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
�� - Ŀ���� ���������� �̵�


���� ��� �Ʒ��� ������� ��JAZ���� ���� �� �ֽ��ϴ�.

- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.


������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.

���� ����
-name�� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
-name�� ���̴� 1 �̻� 20 �����Դϴ�.

����� ��


name

return


��JEROEN�� 56 
��JAN�� 23 

	 */
	

	public int solution(String name) {
		System.out.println("solution started: " + name);
		int answer = 0;
		
		int oldIndex = 0;
		int index = 0;
		int nextIndex = 0;
		char c;
		int a, b;
		char[] letters = new char[name.length()];
		for(int i=0; i<letters.length; i++) {
			letters[i] = 'A';
		}
		
		boolean ignore = false;
		
		while(nextIndex < name.length()) {
			nextIndex = getNextIndex(index, name);
			if(letters[nextIndex] == name.charAt(nextIndex)) {
				break;
			}
			System.out.println(String.format("next index:%d", nextIndex));
			//a = (nextIndex-oldIndex);
			a = (nextIndex);
			b = (name.length()-nextIndex+oldIndex);
			if(!ignore) {
				//int nonA = nonACountRight(name, nextIndex);
				if(a < b) {
					answer += a-oldIndex;
				}
				// AABA, JEROEN, BBAABBB, BAAAABAA, BBBBBABA (a=6, b=8-6+4), BAAABA (a=4, b=6-4+0)
				else if(a == b) {
					if(name.charAt(name.length()-1) == 'A' || oldIndex+1 == nextIndex) {
						answer += a-oldIndex;
					}
					else {
						answer += b;
					}
				}
				else {
					answer += b;
				}
			}
			if(a >= b) {
				ignore = true;
			}
			System.out.println(String.format("position shift:%d", a < b ? a-oldIndex : b));
			
			c = name.charAt(nextIndex);
			a = (c-'A');
			b = ('Z'-c+1);
			answer += a < b ? a : b;
			System.out.println(String.format("alphabet change:%d", a < b ? a : b));
			letters[nextIndex] = c;
			
			oldIndex = nextIndex;
			// move to right
			index = nextIndex + 1;
			if(index == name.length()) {
				index = 0;
			}
		}
		
		
		return answer;
	}
	
	public int nonACountRight(String name, int nextIndex) {
		int result = 0;
		for(int i=name.length()-1; i>=nextIndex; i--) {
			if(name.charAt(i) == 'A') {
				return name.length()-i;
			}
		}
		
		return result;
	}
	
	public int getNextIndex(int current, String name) {
		int result = 0;
		
		// move to right
		for(result=current; result<name.length(); result++) {
			if(name.charAt(result) != 'A') {
				return result;
			}
		}
		
		for(result=0; result<current; result++) {
			if(name.charAt(result) != 'A') {
				return result;
			}
		}
		
		return result;
	}
	
	

	public int[] findBeginningIndex(String name) {
		int[] result = new int[2]; // [0] beginning index, [1] 1:right, 2:left
		
		int start=0, end=name.length()-1;
		if(name.charAt(0) != 'A') {
			// BBBAAB
			// BBAAAAAAABB
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) != 'A') {
					end = i-1;
					break;
				}
			}
			
			for(int i=name.length()-1; i>=0; i--) {
				if(name.charAt(i) != 'A') {
					start = i;
//					if(start == name.length()) {
//						start = 0;
//					}
				}
			}
			
			if(name.length()-1-start < end) {
				
			}
		}
		
		//AAAAAAABBBBBBBBBBBBBAA
		
		return result;
	}
	

}
