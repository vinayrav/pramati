package com.sample.pdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Editpdf {
	public static void main(String[] args) throws IOException{
		File documentFile=new File("/home/vinayr/Desktop/Documents/pdf/examplesigned.pdf");
		PDDocument doc=PDDocument.load(documentFile);
		PDPage page = new PDPage();
		doc.addPage(page);
		PDPageContentStream content=new PDPageContentStream(doc,page);
		content.beginText();
		content.setFont(PDType1Font.COURIER, 22);
		content.showText("edited");
		content.endText();
		content.close();
		doc.save(documentFile);
		doc.close();
		System.out.println("pdf is edited");
		
	}

}
