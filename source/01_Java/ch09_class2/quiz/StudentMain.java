package com.lec.quiz;
public class StudentMain {
	public static void main(String[] args) {
		 Student[] students = {
				 new Student("정우성", 90, 80, 95),
				 new Student("김하늘", 100, 80, 95),
				 new Student("황정민", 95, 80, 90),
				 new Student("강동원", 95, 90, 99),
				 new Student("유아인", 90, 90, 90)};
		int[] total = new int[students.length];
		int[] avg = new int[total.length];
		line('■');
		System.out.println("\t\t\t성적표");
		line('-');
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		line('-');
		for(Student student : students) {
			System.out.print(student.infoString());
			total[0] += student.getKor();
			total[1] += student.getEng();
			total[2] += student.getMat();
			total[3] += student.getTot();
			total[4] += student.getAvg();	
		}
		line('-');
		for(int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = total[idx]/students.length; // 버림(86.6은 86)
			avg[idx] = (int)((double)total[idx]/students.length+0.5); // 반올림(86.6은 90으로)
		}
		System.out.print("총점" + "\t\t");
		for(int t : total) {
			System.out.print(t + "\t");
		}
		System.out.println();
		System.out.print("평균" + "\t\t");
		for(int a : avg) {
			System.out.print(a+"\t");
		}
		System.out.println();
		line('■');
	}
	private static void line(char c) {
		for(int i = 0; i <= 55; i++) {
			System.out.print(c);
			System.out.println();
		}
	}
}
