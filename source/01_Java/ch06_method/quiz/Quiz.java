package com.lec.method;
import java.util.Scanner;
public class Quiz {
	public static void main(String[] args) {
		// ����ڷκ��� 2~9�ܱ����� ���ϴ� �������� �޴´�.
		Scanner scanner = new Scanner(System.in);
		int dansu;
		do{
			System.out.print("������� ���ϴ� ������ ����? (2~9�ܱ����� �����մϴ�.)");
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