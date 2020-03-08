package main;

import java.util.HashSet;
import java.util.Set;

public class BruteForceProblem2 {

	/*
문제 설명


한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
-numbers는 길이 1 이상 7 이하인 문자열입니다.
-numbers는 0~9까지 숫자만으로 이루어져 있습니다.
-“013”은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예


numbers

return


“17” 3 
“011” 2 

입출력 예 설명

예제 #1
 [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
 [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
-11과 011은 같은 숫자로 취급합니다.

	 */

	public int solution(String numbers) {
		HashSet<Integer> set = new HashSet<>();
		permutation("", numbers, set);
		int count = 0;
		while(set.iterator().hasNext()){
			int a = set.iterator().next();
			set.remove(a);
			if(a==2) count++;
			if(a%2!=0 && isPrime(a)){
				count++;
			}
		}        
		return count;
	}

	public void permutation(String prefix, String str, HashSet<Integer> set) {
		int n = str.length();
		//if (n == 0) System.out.println(prefix);
		if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
		for (int i = 0; i < n; i++)
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

	}


	public int solution2(String numbers) {
		System.out.println("solution start!");
		//int answer = 0;
		Set<Integer> numSet = new HashSet<Integer>();

		for(int i=1; i<=numbers.length(); i++) {
			numSet.addAll(findPrime(numbers, i));
		}


		return numSet.size();
	}

	public Set<Integer> findPrime(String numbers, int length){
		Set<Integer> primes = new HashSet<Integer>();
		int tempNumber;
		Set<Integer> selected = new HashSet<Integer>();

		if(length == 1) {
			for(int i=0; i<numbers.length(); i++) {
				tempNumber = Integer.valueOf(numbers.charAt(i)+"");
				if( isPrime(tempNumber) ) {
					primes.add(tempNumber);
					System.out.println("tempNumber:" + tempNumber);
				}
			}
		}
		else if(length == 2) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j));
					if( isPrime(tempNumber) ) {
						primes.add(tempNumber);
						System.out.println("tempNumber:" + tempNumber);
					}
				}
				selected.remove(i);
			}
		}
		else if(length == 3) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					selected.add(j);
					for(int k=0; k<numbers.length(); k++) {
						if( selected.contains(k) ) {
							continue;
						}
						tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j) + numbers.charAt(k));
						if( isPrime(tempNumber) ) {
							primes.add(tempNumber);
							System.out.println("tempNumber:" + tempNumber);
						}
					}
					selected.remove(j);
				}
				selected.remove(i);
			}
		}
		else if(length == 4) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					selected.add(j);
					for(int k=0; k<numbers.length(); k++) {
						if( selected.contains(k) ) {
							continue;
						}
						selected.add(k);
						for(int l=0; l<numbers.length(); l++) {
							if( selected.contains(l) ) {
								continue;
							}
							tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j) + numbers.charAt(k) + numbers.charAt(l));
							if( isPrime(tempNumber) ) {
								primes.add(tempNumber);
								System.out.println("tempNumber:" + tempNumber);
							}
						}
						selected.remove(k);
					}
					selected.remove(j);
				}
				selected.remove(i);
			}
		}
		else if(length == 5) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					selected.add(j);
					for(int k=0; k<numbers.length(); k++) {
						if( selected.contains(k) ) {
							continue;
						}
						selected.add(k);
						for(int l=0; l<numbers.length(); l++) {
							if( selected.contains(l) ) {
								continue;
							}
							selected.add(l);
							for(int m=0; m<numbers.length(); m++) {
								if( selected.contains(m) ) {
									continue;
								}
								tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j) + numbers.charAt(k) + numbers.charAt(l) + numbers.charAt(m));
								if( isPrime(tempNumber) ) {
									primes.add(tempNumber);
									System.out.println("tempNumber:" + tempNumber);
								}
							}
							selected.remove(l);
						}
						selected.remove(k);
					}
					selected.remove(j);
				}
				selected.remove(i);
			}
		}
		else if(length == 6) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					selected.add(j);
					for(int k=0; k<numbers.length(); k++) {
						if( selected.contains(k) ) {
							continue;
						}
						selected.add(k);
						for(int l=0; l<numbers.length(); l++) {
							if( selected.contains(l) ) {
								continue;
							}
							selected.add(l);
							for(int m=0; m<numbers.length(); m++) {
								if( selected.contains(m) ) {
									continue;
								}
								selected.add(m);
								for(int n=0; n<numbers.length(); n++) {
									if( selected.contains(n) ) {
										continue;
									}
									tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j) + numbers.charAt(k) + numbers.charAt(l) + numbers.charAt(m) + numbers.charAt(n));
									if( isPrime(tempNumber) ) {
										primes.add(tempNumber);
										System.out.println("tempNumber:" + tempNumber);
									}
								}
								selected.remove(m);
							}
							selected.remove(l);
						}
						selected.remove(k);
					}
					selected.remove(j);
				}
				selected.remove(i);
			}
		}
		else if(length == 7) {
			for(int i=0; i<numbers.length(); i++) {
				selected.clear();
				selected.add(i);
				for(int j=0; j<numbers.length(); j++) {
					if( selected.contains(j) ) {
						continue;
					}
					selected.add(j);
					for(int k=0; k<numbers.length(); k++) {
						if( selected.contains(k) ) {
							continue;
						}
						selected.add(k);
						for(int l=0; l<numbers.length(); l++) {
							if( selected.contains(l) ) {
								continue;
							}
							selected.add(l);
							for(int m=0; m<numbers.length(); m++) {
								if( selected.contains(m) ) {
									continue;
								}
								selected.add(m);
								for(int n=0; n<numbers.length(); n++) {
									if( selected.contains(n) ) {
										continue;
									}
									selected.add(n);
									for(int o=0; o<numbers.length(); o++) {
										if( selected.contains(o) ) {
											continue;
										}
										tempNumber = Integer.valueOf("" + numbers.charAt(i) + numbers.charAt(j) + numbers.charAt(k) + numbers.charAt(l) + numbers.charAt(m) + numbers.charAt(n) + numbers.charAt(o));
										if( isPrime(tempNumber) ) {
											primes.add(tempNumber);
											System.out.println("tempNumber:" + tempNumber);
										}
									}
									selected.remove(n);
								}
								selected.remove(m);
							}
							selected.remove(l);
						}
						selected.remove(k);
					}
					selected.remove(j);
				}
				selected.remove(i);
			}
		}

		return primes;
	}

	public boolean isPrime(int num) {
		if(num < 2) {
			return false;
		}

		for(int i=2; i<num; i++) {
			if( num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
