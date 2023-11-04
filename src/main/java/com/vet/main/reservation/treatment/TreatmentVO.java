package com.vet.main.reservation.treatment;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TreatmentVO {

	private Long treatmentNo;
	private LocalDateTime treatmentDate;
	
	private String username;
	private String deptNo;
	private String empName;
	
	private String animalName;
	private String name;
	private Long customerNo;
	private String phone;	
	
}
