package com.vet.main.approval;


import java.sql.Date;
import java.sql.Time;

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
	private Date dayoffStartDate;
	private Date dayoffEndDate;
	private String apContents;
	private Long apState;
	private String apRejection;
	private String dayoffKind;
	private Time dayoffStartTime;
	private Time dayoffEndTime;
}
