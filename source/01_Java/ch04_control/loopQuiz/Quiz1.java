package com.lec.loopQuiz;
// 1~10������ ���� ���غ���
public class Quiz1 {
	public static void main(String[] args) {
		int tot = 1; //�������� ���� ����
		for(int i=1; i<=10; i++) {
			tot *= i;
		}
		System.out.println("1~10������ ���� " + tot);
	}
}
