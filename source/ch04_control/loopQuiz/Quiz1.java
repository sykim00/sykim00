package com.lec.loopQuiz;
// 1~10까지의 곱을 구해보자
public class Quiz1 {
	public static void main(String[] args) {
		int tot = 1; //누적합을 위한 변수
		for(int i=1; i<=10; i++) {
			tot *= i;
		}
		System.out.println("1~10까지의 곱은 " + tot);
	}
}
