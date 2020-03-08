package main;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestProgram {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String result = solution(participant, completion);
		System.out.println("[" + result + "]");

		result = solution2(participant, completion);
		System.out.println("[" + result + "]");
		
		result = solution3(participant, completion);
		System.out.println("[" + result + "]");
		
		result = solution4(participant, completion);
		System.out.println("[" + result + "]");
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> temp = new HashMap<String, Integer>();
		Integer tempIndex = null;
		boolean found = false;
		
		if((participant.length - completion.length) != 1) {
			return "";
		}

		for (String name : participant)
		{
			tempIndex = temp.get(name);
			if( tempIndex == null ) {
				tempIndex = 0;
			}
			else {
				tempIndex++;
			}
			
			found = false;
			for(int i = tempIndex ; i < completion.length ; i++ ) {
				if(completion[i].equals(name)) {
					found = true;
					temp.put(name, i);
					break;
				}
			}
			if(!found) {
				answer = name;
				break;
			}
		}

		return answer;
	}

	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> temp1 = new HashMap<String, Integer>();
		Map<String, Integer> temp2 = new HashMap<String, Integer>();
		Integer tempCount = null;
		Integer tempCount2 = null;
		
		if((participant.length - completion.length) != 1) {
			return "";
		}

		for (String name : participant)
		{
			tempCount = temp1.get(name);
			if(tempCount == null) {
				temp1.put(name, 1);
			}
			else {
				temp1.put(name, tempCount+1);
			}
		}
		
		for (String name : completion)
		{
			tempCount = temp1.get(name);
			if(tempCount == null) {
				return name;
			}
			tempCount = temp2.get(name);
			if(tempCount == null) {
				temp2.put(name, 1);
			}
			else {
				temp2.put(name, tempCount+1);
			}
		}
		
		for (String name : participant)
		{
			tempCount = temp1.get(name);
			tempCount2 = temp2.get(name);
			if(tempCount2 == null || tempCount != tempCount2) {
				answer = name;
				break;
			}
		}

		return answer;
	}
	
	public static String solution3(String[] participant, String[] completion) {
		//String answer = "";
		
		if((participant.length - completion.length) != 1) {
			return "";
		}
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		
		for(int i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[participant.length-1];
	}
	
	public static String solution4(String[] participant, String[] completion) { 
		HashMap map = new HashMap<>(); 
		for (int i = 0; i < participant.length ; i++) { 
			map.compute(participant[i], (k, v) -> v != null ? null : 1); 
			if (i < completion.length) 
				map.compute(completion[i], (k,v) -> v != null ? null : 1); 
		} 
		return (String) map.keySet().iterator().next(); 
	}

}
