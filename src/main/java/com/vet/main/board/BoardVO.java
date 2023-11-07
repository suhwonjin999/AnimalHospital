package com.vet.main.board;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	
	// 사원번호
	private String username;
	// 제목
	private String title;
	// 작성일
	private Date createDate;
	// 내용
	private String contents;

}
