package com.sample.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;  
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;  
import java.io.File;   
import java.io.IOException;   
  
public class EncryptPDF {  
      
        public static void main(String[] args)throws IOException {  
                  
        //Loading an existing PDF document  
          File file = new File("/home/vinayr/Desktop/Documents/pramati/trainee/pdf/my_doc.pdf");  
          PDDocument document = PDDocument.load(file);   
  
    //Creating access permission object  
          AccessPermission ap = new AccessPermission();           
  
    //Creating StandardProtectionPolicy object  
  StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", "abcd", ap);  
  
    //Setting the length of the encryption key  
    spp.setEncryptionKeyLength(40);  
  
    //Setting the access permissions  
    spp.setPermissions(ap);  
  
    //Protecting the document  
    document.protect(spp);  
  
          System.out.println("PDF Document encrypted Successfully.");  
  
    //Saving the document  
    document.save("/home/vinayr/Desktop/Documents/pramati/trainee/pdf/enc.pdf");  
    //Closing the document  
    document.close();  
    }  
}  