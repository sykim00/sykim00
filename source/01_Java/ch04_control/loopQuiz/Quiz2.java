package com.lec.loopQuiz;
//1~10까지 숫자 중 짝수의 합과 홀수의 합을 구해보자
public class Quiz2 {
	public static void main(String[] args) {
		int oddTotal = 0; // 홀수 누적 변수
		int evenTotal = 0; // 짝수 누적 변수
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				evenTotal += i;
			}else {
				oddTotal += i;
			}	
		}
		System.out.println("1~10까지의 홀수의 합은 " + oddTotal + ", 짝수의 합은 " + evenTotal);
	}
}
