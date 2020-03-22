package main;

public class GreedyProblem2 {

	/*
문제 설명


조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동


예를 들어 아래의 방법으로 “JAZ”를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.


만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
-name은 알파벳 대문자로만 이루어져 있습니다.
-name의 길이는 1 이상 20 이하입니다.

입출력 예


name

return


“JEROEN” 56 
“JAN” 23 

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
