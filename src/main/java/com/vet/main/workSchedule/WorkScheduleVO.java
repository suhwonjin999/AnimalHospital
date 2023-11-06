package com.vet.main.workSchedule;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WorkScheduleVO {
	private Long workNo;
	private String username;
	private String workDate;
	private String workTime;
	private String homeTime;
	private String deptName;
	private String positionName;
	private String empName;
}
