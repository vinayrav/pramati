package com.docusign.docsend;


import java.util.Base64;
import java.io.*;
import java.io.File;

import org.apache.commons.io.*;

public class Base64File {
	public static  void main(String[] args) throws IOException {
		public void base(){
		
		
		String path="/home/vinayr/Desktop/demo.pdf";
		File f =new File(path);

		byte[] fileContent = FileUtils.readFileToByteArray(f);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
     System.out.println(encodedString);
    }
	}
}
	

