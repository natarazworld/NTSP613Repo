package com.nt.intializers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		  //create Parent IOC container
		 AnnotationConfigWebApplicationContext rootCtx=new AnnotationConfigWebApplicationContext();
		 rootCtx.register(RootAppConfig.class);
		 //create ContexstLoader class obj having parent IOC container
		 ContextLoaderListener listener=new ContextLoaderListener(rootCtx);
		  // register Listener with ServletContainer
		 sc.addListener(listener);
		 
		 
		 //create child IOC container
		 AnnotationConfigWebApplicationContext childCtx=new AnnotationConfigWebApplicationContext();
		 childCtx.register(WebMVCAppConfig.class);
		 //create DispatcherServlet class obj
		 DispatcherServlet  servlet=new DispatcherServlet(childCtx);
		  // register Listener with ServletContainer
		 ServletRegistration.Dynamic dynamic=sc.addServlet("dispatcher", servlet);
		  dynamic.addMapping("/");
		  dynamic.setLoadOnStartup(2);
	}
}
