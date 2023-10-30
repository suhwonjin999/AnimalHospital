package com.vet.main.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.commons.FileManager;
import com.vet.main.customer.CustomerFileVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService implements UserDetailsService{

	@Value("${app.upload}")
	private String uploadPath;
	
	@Value("${app.emp}")
	private String username;
	
	@Autowired
	private FileManager fileManger;
	
	@Autowired
	private EmpDAO empDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String empNo) throws UsernameNotFoundException {
		log.info("=========로그인 시도 중==========");
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo(empNo);
		try {
			empVO = empDAO.getLogin(empNo);
		} catch (Exception e) {
			e.printStackTrace();
			empVO=null;
		}
		
		return empVO;

	}

	// 마이페이지
	public EmpVO mypage(EmpVO empVO) throws Exception{
		return empDAO.mypage(empVO);
	}
	
	//마이페이지 수정
	public int mypageUpdate(EmpVO empVO, MultipartFile[] files)throws Exception{
		
		int result = empDAO.mypageUpdate(empVO);
		
		for(MultipartFile multipartFile:files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManger.save(this.uploadPath+this.username, multipartFile);
			empVO.setEmail(empVO.getEmail());
			empVO.setPhone(empVO.getPhone());
			empVO.setFileName(fileName);
			empVO.setOriginalFileName(multipartFile.getOriginalFilename());
			
			log.info("경로 : {}",uploadPath);
			result = empDAO.mypageUpdate(empVO);
			
			
		}
		
		return result;
	}
	
	// 비밀번호 변경
	public int pwUpdate(EmpVO empVO)throws Exception{
		empVO.setPassword(passwordEncoder.encode(empVO.getPassword()));
		int result = empDAO.pwUpdate(empVO);
		
		return result;
	}

	
	// 사원 관리(직원 목록)
	public List<EmpVO> empList()throws Exception{
		return empDAO.empList();
	}
	
	// 신규직원 등록
	@Transactional(rollbackFor = Exception.class)
	public int empAdd(EmpVO empVO) throws Exception{
		empVO.setPassword(passwordEncoder.encode("animal"));
		int result = empDAO.empAdd(empVO);
		Map<String, Object> map = new HashMap<>();
		map.put("roleNum", 2);
		map.put("username", empVO.getUsername());
		result = empDAO.empRole(map);
		
		return result;
	}
	
	// 직원 상세
	public EmpVO empDetail(EmpVO empVO) throws Exception{
		
		return empDAO.empDetail(empVO);
	}
	
	// 직원 수정
	public int empUpdate(EmpVO empVO) throws Exception{
		empVO.setEmpName(empVO.getEmpName());
		empVO.setDeptNo(empVO.getDeptNo());
		empVO.setPositionNo(empVO.getPositionNo());
		empVO.setState(empVO.getState());
		
		int result = empDAO.empUpdate(empVO);
		
		return result;
		
	}
	
	
}
