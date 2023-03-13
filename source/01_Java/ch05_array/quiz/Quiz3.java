package com.lec.quiz;
public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680;
		int[] arrCoin = {500, 100, 50, 10};
		System.out.println(money + "원은");
		for(int idx = 0; idx < arrCoin.length; idx++) {
				System.out.println(arrCoin[idx] + "원" + money/arrCoin[idx] + "개\t");
				money %= arrCoin[idx];
		}
	}
}
