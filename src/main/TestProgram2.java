package main;

import java.util.Arrays;

public class TestProgram2 {

	
	/*
	 * ���� ����


��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
-������ : 119
-���ؿ� : 97 674 223
-������ : 11 9552 4421

��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
-phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
-�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.

����� ����


phone_book

return


["119", "97674223", "1195524421"] false 
["123","456","789"] true 
["12","123","1235","567","88"] false 

����� �� ����

����� �� #1
�տ��� ������ ���� �����ϴ�.

����� �� #2
�� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��찡 �����Ƿ�, ���� true�Դϴ�.

����� �� #3
ù ��° ��ȭ��ȣ, "12"�� �� ��° ��ȭ��ȣ "123"�� ���λ��Դϴ�. ���� ���� false�Դϴ�.

	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        if(phone_book == null || phone_book.length <= 1) {
        	return answer;
        }
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++) {
        	if( phone_book[i+1].startsWith(phone_book[i]) ) {
        		return false;
        	}
        }
        
        return answer;
    }

}
