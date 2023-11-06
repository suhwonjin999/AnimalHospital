package com.vet.main.reservation.treatment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.vet.main.customer.CustomerVO;
import com.vet.main.dept.DeptVO;
import com.vet.main.emp.EmpVO;

@Mapper
public interface TreatmentDAO {

//	public List<Map<String,Object>> getScheduleList();
	public List<TreatmentVO> getScheduleList();
	public List<TreatmentVO> getDeptScheduleList(TreatmentVO treatmentVO);
	public int setTreatmentAdd(TreatmentVO treatmentVO);
	public List<CustomerVO> getCustomerList(CustomerVO customerVO);
	public List<EmpVO> getEmpList();
	public List<DeptVO> getDeptList();
	public TreatmentVO getDetail(TreatmentVO treatmentVO);
	public int setDelete(TreatmentVO treatmentVO);
	public int setUpdate(TreatmentVO treatmentVO);
	public List<TreatmentVO> getTreatment();
}
