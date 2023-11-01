package com.vet.main.reservation.treatment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface TreatmentDAO {

//	public List<Map<String,Object>> getScheduleList();
	public List<TreatmentVO> getScheduleList();
//	public int setScheduleAdd(TreatmentVO treatmentVO);
}
