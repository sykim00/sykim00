package com.lec.quiz;
import java.util.Scanner;
// ���̿� ���� ��ο��, �Ϲ� ���
public class Quiz4 {
	public static void main(String[] args) {
		System.out.print("���̸� �Է��ϼ��� �� ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		System.out.println((age>=65)? "��ο��" : "�Ϲ�");
		sc.close();
	}
}
