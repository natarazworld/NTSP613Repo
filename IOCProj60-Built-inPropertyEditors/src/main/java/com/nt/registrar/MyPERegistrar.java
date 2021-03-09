package com.nt.registrar;

import java.text.SimpleDateFormat;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class MyPERegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		System.out.println("MyPERegistrar.registerCustomEditors()");
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 registry.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}

}
