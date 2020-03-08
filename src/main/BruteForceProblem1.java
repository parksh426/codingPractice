package main;

public class BruteForceProblem1 {

	/*
문제 설명


수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
-시험은 최대 10,000 문제로 구성되어있습니다.
-문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
-가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예


answers

return


[1,2,3,4,5] [1] 
[1,3,2,4,2] [1,2,3] 

입출력 예 설명

입출력 예 #1
-수포자 1은 모든 문제를 맞혔습니다.
-수포자 2는 모든 문제를 틀렸습니다.
-수포자 3은 모든 문제를 틀렸습니다.

따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2
-모든 사람이 2문제씩을 맞췄습니다.

	 */
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int tempIndex = 0;
        
        for(int i=0; i<answers.length; i++) {
        	tempIndex = i % first.length;
        	if(first[tempIndex] == answers[i]) {
        		count1++;
        	}
        	tempIndex = i % second.length;
        	if(second[tempIndex] == answers[i]) {
        		count2++;
        	}
        	tempIndex = i % third.length;
        	if(third[tempIndex] == answers[i]) {
        		count3++;
        	}
        }
        int max = Math.max(count1, count2);
        max = Math.max(max,  count3);
        String result = "";
        if(count1 == max) {
        	if(result.equals("")) {
        		result = "1";
        	}
        	else {
        		result += ",1";
        	}
        }
        if(count2 == max) {
        	if(result.equals("")) {
        		result = "2";
        	}
        	else {
        		result += ",2";
        	}
        }
        if(count3 == max) {
        	if(result.equals("")) {
        		result = "3";
        	}
        	else {
        		result += ",3";
        	}
        }
        String[] results = result.split(",");
        answer = new int[results.length];
        for(int i=0; i<results.length; i++) {
        	answer[i] = Integer.valueOf(results[i]);
        }
        
        
        return answer;
    }
}
