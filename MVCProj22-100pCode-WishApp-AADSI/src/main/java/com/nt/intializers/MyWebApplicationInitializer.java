package com.nt.intializers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.jmx.export.assembler.AbstractConfigurableMBeanInfoAssembler;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};  //For ContextLoaderListener started IOC container 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCAppConfig.class};   //for DS Started IOC container
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};   //for DS url pattern.
	}

	
}
