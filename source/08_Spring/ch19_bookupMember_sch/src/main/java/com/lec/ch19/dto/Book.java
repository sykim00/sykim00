package com.lec.ch19.dto;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate; // 출판일
	private String bimg1;
	private String bimg2;
	private String binfo;
	private int startRow;
	private int endRow;
	// 검색을 위한 필드
	private String schItem;
	private String schWord;
}
