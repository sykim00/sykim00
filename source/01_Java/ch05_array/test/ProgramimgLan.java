package com.lec.test;
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] array = {76, 45, 34, 89, 100, 50, 90, 93};
		int sum=0, avg=0, max=0, min=0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			if(array[i] > max) max = array[i];
			if(array[i] < min) min = array[i];
		}	
		avg = sum / array.length;
		System.out.println("�迭 ���� �հ� : " + sum + "\t�迭 ���� ��� : " + avg);
		System.out.println("�迭 ���� �ִ� : " + max + "\t�迭 ���� �ּڰ�: " + min);
	}
}
