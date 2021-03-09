package com.nt.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.beans" )
public class AppConfig {
	
	@Bean
	public  CustomEditorConfigurer  createCEC() {
		CustomEditorConfigurer configurer=new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> map=new HashMap();
		map.put(com.nt.beans.IntrestAmountDetails.class,com.nt.editor.IntrestAmountDetailsEditor.class);
		configurer.setCustomEditors(map);
		return configurer;
	}

}
