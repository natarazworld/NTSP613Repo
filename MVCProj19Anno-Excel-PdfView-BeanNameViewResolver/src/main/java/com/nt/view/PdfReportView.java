package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.CoronaVaccine;

@Component("pdf_view")
public class PdfReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //get Model attribute values
		List<CoronaVaccine> listVaccines=(List<CoronaVaccine>)map.get("vaccineList");
		// add Paragraph
				Paragraph para=new Paragraph("Vaccine Report", new Font(Font.BOLDITALIC));
				document.add(para);
				//add table 
				Table table=new  Table(5,listVaccines.size());
				for(CoronaVaccine vacc:listVaccines) {
					table.addCell(String.valueOf(vacc.getRegNo()));
					table.addCell(vacc.getName());
					table.addCell(vacc.getCompany());
					table.addCell(vacc.getCountry());
					table.addCell(String.valueOf(vacc.getPrice()));
				}
				document.add(table);
	}//method
}//class
