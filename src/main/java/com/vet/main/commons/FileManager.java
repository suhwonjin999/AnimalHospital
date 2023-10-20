package com.vet.main.commons;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	// 파일 저장 후 파일명을 리턴
	public String save(String path, MultipartFile multipartFile) throws Exception {
		
		// 어떤 파일을? / 어디에 저장할지?
		// 1. 파일 객체 생성
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 2. 저장할 파일명을 생성
		String fileName = UUID.randomUUID().toString()+'_'+multipartFile.getOriginalFilename();

		// 3. 파일을 저장
		file = new File(file, fileName);	// 아래의 두 방법 모두 새 객체 생성해야됨
		// FileCopyUtils.copy
		// FileCopyUtils.copy(multipartFile.getBytes(), file);
		// transferTo
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
