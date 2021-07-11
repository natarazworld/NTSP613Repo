package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.CoronaVaccine;
@Component("excel_view")
public class ExcelReportView extends AbstractXlsView {
	private  static int i=0;
	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//get Model attribute values
				List<CoronaVaccine> listVaccines=(List<CoronaVaccine>)map.get("vaccineList");
				
				//create Sheet
				Sheet sheet1=workbook.createSheet("Sheet1");
			// add cells to sheet
			   
				listVaccines.forEach(vaccine->{
					Row row=sheet1.createRow(i);
					row.createCell(0).setCellValue(vaccine.getRegNo());
					row.createCell(1).setCellValue(vaccine.getName());
					row.createCell(2).setCellValue(vaccine.getCompany());
					row.createCell(3).setCellValue(vaccine.getCountry());
					row.createCell(4).setCellValue(vaccine.getPrice());
					i++;
				});

	}

	

}
