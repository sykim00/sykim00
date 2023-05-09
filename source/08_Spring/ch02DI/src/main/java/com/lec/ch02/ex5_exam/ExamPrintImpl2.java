package com.lec.ch02.ex5_exam;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class ExamPrintImpl2 implements ExamPrint{
	private Exam exam;
	public void print() {
		System.out.println("이름 : " + exam.getName());
		System.out.println("총점 : " + exam.getTotal());
		System.out.println("평균 : " + exam.getAvg());
	}	
}
