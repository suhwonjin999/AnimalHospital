package com.vet.main.reservation.treatment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/treatment/*")
@Slf4j
public class TreatmentController {
	
	@Autowired
	private TreatmentService treatmentService;

	
	@GetMapping("schedule")
	public String getScheduleList1()throws Exception{
		return "/treatment/schedule";
	}	

	@PostMapping("schedule")
	@ResponseBody
	public List<Map<String,Object>> getScheduleList()throws Exception{
		List<TreatmentVO> list = treatmentService.getScheduleList();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();
		
		for(int i=0; i < list.size(); i++) {
			hash.put("title", list.get(i).getAnimalName());		
			hash.put("start", list.get(i).getTreatmentDatet());			
			//hash.put("startTime", list.get(i).getTreatmentDatet());
		
			jsonObj = new JSONObject(hash); 
			jsonArr.add(jsonObj);		
		}
		
		log.info("jsonArrCheck:{}", jsonArr);
		
		return jsonArr;		
	}
	
//	@PostMapping("scheduleAdd")
//	public String setScheduleAdd(@RequestBody TreatmentVO treatmentVO)throws Exception{
//		treatmentService.setScheduleAdd(treatmentVO);
//		
//		return "scheduleAdd";
//	}


	
	
}