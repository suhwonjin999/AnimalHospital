package com.vet.main.approval;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApprovalExpenseVO {
	private Long apNo;
	private String expenseName;
	private String expenseAmount;
	private String expensePrice;
	private String expenseBigo;
	
	public void setExpenseBigo(String string) {
		if(this.expenseBigo == null || this.expenseBigo.isEmpty()) {
			this.expenseBigo = "";
		}
	}
}
