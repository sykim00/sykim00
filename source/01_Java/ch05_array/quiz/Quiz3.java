package com.lec.quiz;
public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680;
		int[] arrCoin = {500, 100, 50, 10};
		System.out.println(money + "����");
		for(int idx = 0; idx < arrCoin.length; idx++) {
				System.out.println(arrCoin[idx] + "��" + money/arrCoin[idx] + "��\t");
				money %= arrCoin[idx];
		}
	}
}
