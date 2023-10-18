package com.vet.main.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.main.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public List<CustomerVO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		Long count = customerDAO.getCount(pager);
		pager.makePageNum(count);
		//pager.setPerPage(10L);
		return customerDAO.getList(pager);
	}
	
	public int setAdd(CustomerVO customerVO) throws Exception {
		int result = customerDAO.setAdd(customerVO);
		
		return result;
	}
}
