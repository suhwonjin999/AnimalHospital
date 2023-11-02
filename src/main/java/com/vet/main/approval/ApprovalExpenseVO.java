package com.vet.main.approval;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApprovalExpenseVO {
	private Long expenseNo;
	private Long apNo;
	private String expenseName;
	private Long expenseAmount;
	private Long expensePrice;
	private String expenseBigo;
}
