package com.vet.main.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.util.FileManger;
import com.vet.main.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private FileManger fileManger;
	
	//spEl
	//properties 값을 java 사용
	//@Value("${properties의 키}")
	@Value("${app.upload}")
	private String uploadPath;
		
	@Value("${app.customer}")
	private String customerName;
	
	//고객목록
	public List<CustomerVO> getList(Pager pager) throws Exception {
		Long totalCount = customerDAO.getTotal(pager);
		pager.makeNum(totalCount);
		pager.makeStartRow();
		return customerDAO.getList(pager);
	}
	
	//고객추가(이미지포함)
	public int setAdd(CustomerVO customerVO, MultipartFile[] files) throws Exception {
		int result = customerDAO.setAdd(customerVO);
		
		for(MultipartFile multipartFile:files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			CustomerFileVO fileVO = new CustomerFileVO();
			String fileName = fileManger.save(this.uploadPath + this.customerName, multipartFile);
			fileVO.setCustomerNo(customerVO.getCustomerNo());
			fileVO.setFileName(fileName);
			fileVO.setOriginalFileName(multipartFile.getOriginalFilename());
			result = customerDAO.setFileAdd(fileVO);
		}
		
		return result;
	}
	
	//고객상세
	public CustomerVO getDetail(CustomerVO customerVO) throws Exception {
		return customerDAO.getDetail(customerVO);
	}
	
	//고객수정
	public int setUpdate(CustomerVO customerVO) throws Exception {
		return customerDAO.setUpdate(customerVO);
	}
}
