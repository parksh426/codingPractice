package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashProgram4 {

	
	/*
문제 설명


스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
1.속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2.장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3.장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
-genres[i]는 고유번호가 i인 노래의 장르입니다.
-plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
-genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
-장르 종류는 100개 미만입니다.
-장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
-모든 장르는 재생된 횟수가 다릅니다.

입출력 예


genres

plays

return


["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500] [4, 1, 3, 0] 

입출력 예 설명

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
-고유 번호 3: 800회 재생
-고유 번호 0: 500회 재생
-고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
-고유 번호 4: 2,500회 재생
-고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.



	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
테스트 1 〉 통과 (2.11ms, 52.8MB) 
테스트 2 〉 통과 (2.39ms, 50.5MB) 
테스트 3 〉 실패 (3.18ms, 52.5MB) 
테스트 4 〉 통과 (2.37ms, 50MB) 
테스트 5 〉 실패 (3.59ms, 52.5MB) 
테스트 6 〉 실패 (3.51ms, 52.7MB) 
테스트 7 〉 실패 (3.71ms, 50.6MB) 
테스트 8 〉 실패 (3.34ms, 52.8MB) 
테스트 9 〉 실패 (3.38ms, 52.5MB) 
테스트 10 〉 실패 (3.77ms, 54.4MB) 
테스트 11 〉 실패 (3.67ms, 51.9MB) 
테스트 12 〉 실패 (3.00ms, 52.4MB) 
테스트 13 〉 통과 (1.92ms, 54.1MB) 
테스트 14 〉 통과 (1.87ms, 50.8MB) 
테스트 15 〉 통과 (2.15ms, 52.7MB) 

채점 결과
정확성: 40.0
합계: 40.0 / 100.0
	 */
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        if(genres == null || plays == null || genres.length != plays.length) {
        	return answer;
        }
        
        // Genre play total
        Map<String, Long> genreSum = new HashMap<String, Long>();
        // Genre Top2 index List
        Map<String, ArrayList<Integer>> genreTop = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> tempTop;
//        boolean isSame = false;
        boolean isInserted = false;
        
        // start from id = 0
        for(int currentId=0; currentId<genres.length; currentId++) {
        	genreSum.put(genres[currentId], genreSum.getOrDefault(genres[currentId], 0L) + plays[currentId]);
        	tempTop = genreTop.get(genres[currentId]);
        	// case1 : empty top list
        	if(tempTop == null) {
        		tempTop = new ArrayList<>(3);
        		tempTop.add(currentId);
        		genreTop.put(genres[currentId], tempTop);
        	}
        	// case2 : top list is not empty
        	else {
        		isInserted = false;
        		int j = 0;
        		for(j=0; j<tempTop.size(); j++) {
        			if(plays[tempTop.get(j)] < plays[currentId] ) {
        				tempTop.add(j, currentId);
        				isInserted = true;
        				break;
        			}
//        			else if(plays[tempTop.get(j)] == plays[currentId] ) {
//        				isSame = true;
//        			}
        		}
        		if( tempTop.size() < 2 && isInserted == false ) {
        			tempTop.add(currentId);
        		}
        		while(tempTop.size() > 2) {
        			tempTop.remove(tempTop.size()-1);
        		}
        		genreTop.put(genres[currentId], tempTop);
        	}
        }
        
        List<Map.Entry<String, Long>> genreSumList = new LinkedList<>(genreSum.entrySet());
        
        // Sort by num of plays 
        Collections.sort(genreSumList, new Comparator<Map.Entry<String, Long>>(){
        	@Override
        	public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        		int comparison = (int) ((o1.getValue() - o2.getValue()) * -1);
        		//return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
        		return comparison;
        	}
        });
        
        ArrayList<Integer> tempResult = new ArrayList<>();
        for(int i=0; i<genreSumList.size(); i++) {
        	tempTop = genreTop.get(genreSumList.get(i).getKey());
        	System.out.println(genreSumList.get(i).getKey() + " SUM:" + genreSumList.get(i).getValue());
        	for(int j=0; j<tempTop.size(); j++) {
        		System.out.println(genreSumList.get(i).getKey() + ":" + tempTop.get(j));
    			tempResult.add(tempTop.get(j));
    		}
        }
        
        answer = new int[tempResult.size()];
        for(int i=0; i<tempResult.size(); i++) {
        	answer[i] = tempResult.get(i);
        }
        
        return answer;
    }
    
}
