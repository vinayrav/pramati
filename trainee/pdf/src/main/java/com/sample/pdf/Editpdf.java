package com.sample.pdf;

import java.io.File;  
import java.io.IOException;   
import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.PDPage;  
  
public class Editpdf {  
  
    public static void main(String[] args)throws IOException {  
              
    //Loading an existing document   
          File file = new File("/home/vinayr/Desktop/Documents/pramati/trainee/pdf/my_docsigned.pdf");   
          PDDocument doc = PDDocument.load(file);   
      
         
      
    //Adding a blank page to the document   
    doc.addPage(new PDPage());    
  
    //Saving the document   
    doc.save("/home/vinayr/Desktop/Documents/pramati/trainee/pdf/my_docsigned.pdf");  
  
    //Closing the document    
    doc.close();  
    System.out.println("Page added"); 
    }  
}  
