package com.lec.ch04.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutoWairedTestMain {
	public static void main(String[] args) {
		String location1 = "classpath:META-INF/ex1/CTX1.xml";
		String location2 = "classpath:META-INF/ex1/CTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location1, location2);
		Student student = ctx.getBean("student" , Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println("student : " + student);
		System.out.println("student2 : " + student2);
		if(student.equals(student2)) {
			System.out.println("같은객체");
		}else {
			System.out.println("다른객체");
		}
		Family family = ctx.getBean("family", Family.class);
		System.out.println("Family : " + family);
		ctx.close();
	}
}
