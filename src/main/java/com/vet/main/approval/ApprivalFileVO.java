package com.vet.main.approval;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApprivalFileVO {
	private Long fileNo;
	private Long apNo;
	private String fileName;
	private String originalFileName;
}
