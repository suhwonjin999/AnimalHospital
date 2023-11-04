package com.vet.main.approval;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApprovalExpenseVO {
	private Long apNo;
	private String expenseName;
	private Long expenseAmount;
	private Long expensePrice;
	private String expenseBigo;
	
	public void setExpenseBigo(String string) {
		if(this.expenseBigo == null || this.expenseBigo.isEmpty()) {
			this.expenseBigo = "";
		}
	}

}
