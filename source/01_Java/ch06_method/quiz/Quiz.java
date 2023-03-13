package com.lec.method;
import java.util.Scanner;
public class Quiz {
	public static void main(String[] args) {
		// 사용자로부터 2~9단까지의 원하는 구구단을 받는다.
		Scanner scanner = new Scanner(System.in);
		int dansu;
		do{
			System.out.print("출력하을 원하는 구구단 수는? (2~9단까지만 가능합니다.)");
			dansu = scanner.nextInt();
		}while(dansu < 2 || dansu > 9);
		 gugu(dansu);
	}
	private static void gugu(int dansu) {
		for(int i = 1; i < 10; i++) {
			System.out.println(dansu + " * " + i + " = " + (dansu*i));
		}//for
	}
}