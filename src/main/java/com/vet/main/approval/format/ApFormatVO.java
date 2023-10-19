package com.vet.main.approval.format;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApFormatVO {
	private Long apFormatNo;
	private Date apFormatDate;
	private String apFormatTitle;
	private String apFormatContents;
}
