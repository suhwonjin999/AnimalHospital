package com.vet.main.approval;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApprovalVO {
	private Long apNo;
	private Long empNo;
	private Long apFormatNo;
	private String apTitle;
	private Date apCdate;
	private Date apUdate;
	private Date apStartDate;
	private Date apEndDate;
	private String apContents;
	private Long apState;
	private String apRejection;
	private Date apConfirmDate;
	private String apDayoffKind;
}
