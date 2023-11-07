package com.vet.main.file;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileVO {
	
	// 파일번호
	private Long fileNo;
	
	// 파일명
	private String fileName;
	
	// 원본파일명
	private String originalFileName;

}
