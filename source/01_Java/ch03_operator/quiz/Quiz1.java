package com.lec.quiz;
import java.util.Scanner;
public class Quiz1 {
	public static void main(String[] args) {
//		String name = new String("ȫ�浿"); 
//		System.out.println(name.toUpperCase());
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int su = sc.nextInt(); //Ű����κ��� �Է¹��� ������ ��ȯ�ϴ� ���
		String result = (su % 3 == 0) ? "3�� ����Դϴ�" : "3�� ����� �ƴմϴ�";
		System.out.println("�Է��Ͻ� �� (" + su + ")�� " + result);
		sc.close();
	}

}
