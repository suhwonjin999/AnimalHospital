package com.vet.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// ***-context.xml과 같은 역할
@Configuration
public class FileMappingConfig implements WebMvcConfigurer {
	
	// local file 위치
	@Value("${app.upload.mapping}")
	private String filePath;
	// ▲
	// 아래의 경로로 들어오는 것은 위의 filePath로 가라는 의미
	// ▼
	// 요청 URL 경로
	@Value("${app.url.path}")
	private String urlPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// 요청 URL
		registry.addResourceHandler(urlPath)
		// Local file 위치(file://D://GDJ68/upload)
				.addResourceLocations(filePath);
	}
	
}
