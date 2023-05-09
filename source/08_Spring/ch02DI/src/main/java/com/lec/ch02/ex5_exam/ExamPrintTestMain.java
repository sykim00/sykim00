package com.lec.ch02.ex5_exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamPrintTestMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX5.xml");
		ExamPrint examPrint = ctx.getBean("examPrint", ExamPrint.class);
		examPrint.print();
		ctx.close();
	}
}
