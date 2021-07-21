package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;


@Controller
public class FileUploadAndDowloadOpearationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Value("${dest.store.path}")
	private  String destPath;
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/register")
	public String  showForm(@ModelAttribute("empForm") Employee emp) {
		//return  LVN
		return "employee_register";
	}
	
	@PostMapping("/register")
	public  String registerEmployee(@ModelAttribute("empForm") Employee emp,Map<String,Object> map)throws Exception {
		//use service
		String resultMsg=service.uploadFiles(destPath, emp);
		//keep the result in model attribute
		map.put("resultMsg",resultMsg);
		//return LVN
		return "show_results";
	}
	
	@GetMapping("/report")
	public  String  employeesReoport(Map<String,Object> map)throws Exception {
		//use serivce
		  List<String> fiesList=service.getAllFiles(destPath);
		  //add results to model attribute
		  map.put("listFiles",fiesList);
		  //return LVN
		  return "employee_report";
	}
	
	  @Autowired
	  private ServletContext sc;
	@GetMapping("/download")
		public  String downloadFile(@RequestParam("fileName")String fname,HttpServletResponse res)throws Exception {
		  //create java.io.File object poting to the file to downloaded
		  File file=new File(fname);
		  //get the length of the file and make it response content length
		  res.setContentLengthLong(file.length());
		  //take the file to be downloaded MIME type and make it response content type
		  String mimeType=sc.getMimeType(fname);
		  res.setContentType(mimeType==null?"application/octet-stream":mimeType);
		  //create InputStream pointing to the file to be download
		   InputStream is=new FileInputStream(file);
		  //make response obj disposing its content as downloaable file
		     res.addHeader("Content-Disposition", "attachment;fileName="+file.getName());
		    //create OutputStream pointing to response obj
		     OutputStream os=res.getOutputStream();
		     //write content of file to donwloaed to  response obj using sttreams
		     IOUtils.copy(is, os);
		     //close streams
		     is.close();
		     os.close();
		return null;
	}

}
