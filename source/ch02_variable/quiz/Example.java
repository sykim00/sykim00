package com.lec.quiz;
public class Example {
	public static void main (String[] args) {
		// ����, ����, ���� ���� �Ҵ�
		// ����, ���
		// ������ ���
		int kor = 80, eng = 100, mat = 70;		
		int tot = kor + eng + mat; // ����
		double avg = (double)tot / 3;
		System.out.println("���� : "+ kor + "\t���� : " + eng + "\t���� : " + mat);
		System.out.printf("���� : %d\t��� : %.2f\n", tot, avg);	
	}
}
