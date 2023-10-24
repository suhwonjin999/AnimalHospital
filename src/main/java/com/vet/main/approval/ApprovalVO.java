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
	private String empNo;
	private Long apFormatNo;
	private String apTitle;
	private Date apCDate;
	private Date apUDate;
	private Date dayoffStartDate;
	private Date dayoffEndDate;
	private String apContents;
	private String apState;
	private String apRejection;
	private String dayoffKind;
	private Time dayoffStartTime;
	private Time dayoffEndTime;
	private String apKind;
	
	private String positionName;
	private String deptName;
	private String name;
}
