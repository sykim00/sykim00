package com.lec.quiz;
public class Example {
	public static void main (String[] args) {
		// 국어, 영어, 수학 점수 할당
		// 총점, 평균
		// 점수들 출력
		int kor = 80, eng = 100, mat = 70;		
		int tot = kor + eng + mat; // 총점
		double avg = (double)tot / 3;
		System.out.println("국어 : "+ kor + "\t영어 : " + eng + "\t수학 : " + mat);
		System.out.printf("총점 : %d\t평균 : %.2f\n", tot, avg);	
	}
}
