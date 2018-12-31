package com.docusign.base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.io.*;
import org.apache.commons.io.*;

import java.util.*;

public class b64 {
	public static void main(String[] args) throws IOException {
		String path="/home/vinayr/Desktop/demo.pdf";
		File f =new File(path);

		byte[] fileContent = FileUtils.readFileToByteArray(f);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
     System.out.println(encodedString);
    }
	}
