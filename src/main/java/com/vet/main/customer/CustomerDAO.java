package com.vet.main.customer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.file.FileVO;
import com.vet.main.util.Pager;

@Mapper
public interface CustomerDAO {
	
	public Long getTotal(Pager pager) throws Exception;
	
	//고객 목록
	public List<CustomerVO> getList(Pager pager) throws Exception;
		
	//고객 등록
	public int setAdd(CustomerVO customerVO) throws Exception;
	
	//사진추가
	public int setFileAdd(FileVO fileVO) throws Exception;

}
