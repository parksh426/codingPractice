package main;

import java.util.LinkedList;
import java.util.Scanner;

public class BruteForce {
	
	/*
���

3 2
***����(0,1,2)***
0 1 
0 2 
1 0 
1 2 
2 0 
2 1 
***�ߺ�����(0,1,2)***
0 0 
0 1 
0 2 
1 0 
1 1 
1 2 
2 0 
2 1 
2 2 
***����(0,1,2)***
0 1 
0 2 
1 2 
***�ߺ�����(0,1,2)***
0 0 
0 1 
0 2 
1 1 
1 2 
2 2 
	 */
	
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int r = sc.nextInt();
    	
    	int n = 3;
    	int r = 2;
         
         
        //���� (�����ְ� �迭)
        System.out.println("***����(0,1,2)***");
        LinkedList<Integer> perArr = new LinkedList<Integer>(); 
        int[] perCheck = new int[n];
        permutation(n, r, perArr, perCheck);
         
        //�ߺ����� (�����ְ� �迭 + �ڽ��ڽŵ� ����)
        System.out.println("***�ߺ�����(0,1,2)***");
        LinkedList<Integer> rePerArr = new LinkedList<Integer>();   
        rePermutation(n, r, perArr);
         
        //���� (�������ɾ��� ���� ������ ����)
        System.out.println("***����(0,1,2)***");
        int[] comArr = new int[r];
        combination(comArr, n, r, 0, 0);
         
         
        //�ߺ� ���� (�������ɾ��� ���� ������ ���� + �ڱ��ڽŵ� ����)
        System.out.println("***�ߺ�����(0,1,2)***");
        int[] reComArr = new int[r];
        reCombination(reComArr, n, r, 0, 0);
         
 
    }
     
     
    //�ߺ� ���� (�������ɾ��� ���� ������ ���� + �ڱ��ڽŵ� ����)
    private static void reCombination(int[] reComArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : reComArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }       
        if(target == n)return;
         
        reComArr[index] = target;
        reCombination(reComArr, n, r-1, index+1, target);//�̴°��
        reCombination(reComArr, n, r, index, target+1);//�Ȼ̴°��
         
    }
    //���� (�������ɾ��� ���� ������ ����)
    private static void combination(int[] comArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : comArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if(target == n)return;
         
        comArr[index] = target;
        combination(comArr, n, r-1, index+1, target+1);//�̴°��
        combination(comArr, n, r, index, target+1);//�Ȼ̴°��
         
    }
    //�ߺ����� (�����ְ� �迭 + �ڽ��ڽŵ� ����)
    private static void rePermutation(int n, int r, LinkedList<Integer> rePerArr) {
        if(rePerArr.size() == r){
            for(int i : rePerArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
         
        for(int i=0; i<n; i++){  
            rePerArr.add(i);
            rePermutation(n, r, rePerArr);
            rePerArr.removeLast();
 
        }
         
         
    }
    //���� (�����ְ� �迭)
    private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {
        if(perArr.size() == r){
            for(int i : perArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
         
        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(i);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
         
    }

}
