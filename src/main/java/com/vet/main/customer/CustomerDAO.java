package com.vet.main.customer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.util.Pager;

@Mapper
public interface CustomerDAO {
	
	public Long getCount(Pager pager) throws Exception;
	
	//고객 목록
	public List<CustomerVO> getList(Pager pager) throws Exception;
		
	//고객 등록
	public int setAdd(CustomerVO customerVO) throws Exception;

}
