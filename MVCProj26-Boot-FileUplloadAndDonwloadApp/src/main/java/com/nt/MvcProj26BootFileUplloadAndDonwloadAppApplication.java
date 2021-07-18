package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class MvcProj26BootFileUplloadAndDonwloadAppApplication {
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver  createCommonsMPResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(-1);
	    return resolver;	
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(MvcProj26BootFileUplloadAndDonwloadAppApplication.class, args);
	}

}
