package com.vet.main.notice;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVO {
	
	private Long noticeNo;
	
	private Long empNo;
	
	private String title;
	
	private Date createDate;
	
	private String noticeContents;
	
	private Long hit;

}
