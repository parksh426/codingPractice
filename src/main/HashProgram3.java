package main;

import java.util.HashMap;
import java.util.Map;

public class HashProgram3 {

	
	/*
���� ����


�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.


����

�̸�


�� ���׶� �Ȱ�, ���� ���۶� 
���� �Ķ��� Ƽ���� 
���� û���� 
�ѿ� �� ��Ʈ 

�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
-clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
-�����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
-���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
-clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
-��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
-�����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.

����� ��


clothes

return


[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]] 5 
[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]] 3 

����� �� ����

���� #1
 headgear�� �ش��ϴ� �ǻ��� yellow_hat, green_turban�̰� eyewear�� �ش��ϴ� �ǻ��� blue_sunglasses�̹Ƿ� �Ʒ��� ���� 5���� ������ �����մϴ�.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses


���� #2
 face�� �ش��ϴ� �ǻ��� crow_mask, blue_sunglasses, smoky_makeup�̹Ƿ� �Ʒ��� ���� 3���� ������ �����մϴ�.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup


	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(String[][] clothes) {
        
        int answer = 1;

        if(clothes == null || clothes.length <= 0) {
            return 0;
        }

        Map<String, Integer> groupMap = new HashMap<String, Integer>();

        for(String[] cloth : clothes) {
            int temp = groupMap.getOrDefault(cloth[1], 0);
            groupMap.put(cloth[1], temp+1);
        }

        for(int temp : groupMap.values()) {
            answer *= (temp + 1);
        }
        answer--;

        return answer;
    }

}