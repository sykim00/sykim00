package com.lec.quiz;
import java.util.Scanner;
// �Է��� �μ��� ���� ���
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��°���� �Է��ϼ���.");
		int num1 = sc.nextInt();
		System.out.print("�ι�°���� �Է��ϼ���.");
		int num2 = sc.nextInt();
		System.out.println("�μ��� ������ ����� " + ((num1==num2)? "O" : "X"));
		System.out.println("ù��° ���� �� ū�� ���� " + ((num1>num2)? "O" : "X"));
	}
}
