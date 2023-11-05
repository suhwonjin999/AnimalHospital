package com.vet.main.treatmentchart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.commons.FileManager;
import com.vet.main.commons.Pager;
import com.vet.main.emp.EmpVO;
import com.vet.main.medicine.MedicineVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TreatmentChartService {
	
	@Autowired
	private TreatmentChartDAO treatmentChartDAO;
	
	@Autowired 
	private FileManager fileManager;
	
//	@Value("${app.upload}")
//	private String uploadPath;
//		
//	@Value("${app.treatmentchart}")
//	private String contents;
	
	//진료차트목록
	public List<TreatmentChartVO> getList(Pager pager) throws Exception {
		Long totalCount = treatmentChartDAO.getTotal(pager);
		pager.makeNum(totalCount);
		pager.makeStartRow();
		
		return treatmentChartDAO.getList(pager);
	}
	
	//진료차트추가
	public int setAdd(TreatmentChartVO treatmentChartVO) throws Exception {
		int result = treatmentChartDAO.setAdd(treatmentChartVO);
		
		return result;
	}
	
	//진료차트상세
	public TreatmentChartVO getDetail(TreatmentChartVO treatmentChartVO) throws Exception {
		return treatmentChartDAO.getDetail(treatmentChartVO);
	}
	
	//진료차트수정
	public int setUpdate(TreatmentChartVO treatmentChartVO) throws Exception {
		return treatmentChartDAO.setUpdate(treatmentChartVO);
	}
	
	public List<MedicineVO> getMedicineList() throws Exception {
		return treatmentChartDAO.getMedicienList();
	}
	
//	//썸머노트 사진등록
//	public String contentsImgInsert(MultipartFile files, HttpSession session) throws Exception {
//		String fileName = fileManager.save(this.uploadPath + this.contents, files);
//		
//		return this.uploadPath + this.contents;
//	}
//	
//	//썸머노트 사진삭제
//	public boolean contentsImgDelete(TreatmentChartFileVO treatmentChartFileVO, HttpSession session) throws Exception {
//		treatmentChartFileVO.setFileName(this.contents.substring(this.contents.lastIndexOf("/") + 1));
//		
//		return fileManager.fileDelete(treatmentChartFileVO, uploadPath, session);	
//	}

}
