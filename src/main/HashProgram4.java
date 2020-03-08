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
���� ����


��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
1.���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
2.�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
3.�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.

�뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���ѻ���
-genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
-plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
-genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
-�帣 ������ 100�� �̸��Դϴ�.
-�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
-��� �帣�� ����� Ƚ���� �ٸ��ϴ�.

����� ��


genres

plays

return


["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500] [4, 1, 3, 0] 

����� �� ����

classic �帣�� 1,450ȸ ����Ǿ�����, classic �뷡�� ������ �����ϴ�.
-���� ��ȣ 3: 800ȸ ���
-���� ��ȣ 0: 500ȸ ���
-���� ��ȣ 2: 150ȸ ���

pop �帣�� 3,100ȸ ����Ǿ�����, pop �뷡�� ������ �����ϴ�.
-���� ��ȣ 4: 2,500ȸ ���
-���� ��ȣ 1: 600ȸ ���

���� pop �帣�� [4, 1]�� �뷡�� ����, classic �帣�� [3, 0]�� �뷡�� �״����� �����մϴ�.



	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
�׽�Ʈ 1 �� ��� (2.11ms, 52.8MB) 
�׽�Ʈ 2 �� ��� (2.39ms, 50.5MB) 
�׽�Ʈ 3 �� ���� (3.18ms, 52.5MB) 
�׽�Ʈ 4 �� ��� (2.37ms, 50MB) 
�׽�Ʈ 5 �� ���� (3.59ms, 52.5MB) 
�׽�Ʈ 6 �� ���� (3.51ms, 52.7MB) 
�׽�Ʈ 7 �� ���� (3.71ms, 50.6MB) 
�׽�Ʈ 8 �� ���� (3.34ms, 52.8MB) 
�׽�Ʈ 9 �� ���� (3.38ms, 52.5MB) 
�׽�Ʈ 10 �� ���� (3.77ms, 54.4MB) 
�׽�Ʈ 11 �� ���� (3.67ms, 51.9MB) 
�׽�Ʈ 12 �� ���� (3.00ms, 52.4MB) 
�׽�Ʈ 13 �� ��� (1.92ms, 54.1MB) 
�׽�Ʈ 14 �� ��� (1.87ms, 50.8MB) 
�׽�Ʈ 15 �� ��� (2.15ms, 52.7MB) 

ä�� ���
��Ȯ��: 40.0
�հ�: 40.0 / 100.0
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
