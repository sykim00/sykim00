package com.lec.quiz;
import java.util.Scanner;
// �Է��� ���� ¦/Ȧ�� ���� ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� :");
		int su = sc.nextInt();
		int result = su%2;
		System.out.println((result==0)? "�Է��� ���� ¦��" : "�Է��� ���� Ȧ��");
		sc.close();
	}

}
