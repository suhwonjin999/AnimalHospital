package com.vet.main.reservation.treatment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {
	
	@Autowired
	private TreatmentDAO treatmentDAO; 
	
//	public List<Map<String,Object>> getScheduleList() throws Exception{
//		return treatmentDAO.getScheduleList();
//	};
	
	public List<TreatmentVO> getScheduleList() throws Exception{
		return treatmentDAO.getScheduleList();
	};
	
//	public int setScheduleAdd(TreatmentVO treatmentVO) throws Exception{
//		return treatmentDAO.setScheduleAdd(treatmentVO);
//	}
	
}
