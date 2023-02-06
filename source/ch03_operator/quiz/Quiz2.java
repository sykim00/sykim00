package com.lec.quiz;
import java.util.Scanner;
// 입력한 수의 짝/홀수 여부 출력
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int su = sc.nextInt();
		int result = su%2;
		System.out.println((result==0)? "입력한 수는 짝수" : "입력한 수는 홀수");
		sc.close();
	}

}
