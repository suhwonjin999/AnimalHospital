package com.vet.main.notice;

import com.vet.main.util.FileVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeFileVO extends FileVO {
	
	// 공지사항 번호
	private Long noticeNo;

}
