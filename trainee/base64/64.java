package module1;

import java.io.IOException;
import java.util.Base64;
import java.io.*;
import org.apache.commons.io.*;

public class B64 {
	public static void main(String[] args) throws IOException {
		private void file() {
		String path="/home/vinayr/Desktop/demo.pdf";
		File f =new File(path);

		byte[] fileContent = FileUtils.readFileToByteArray(f);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
     System.out.println(encodedString);
    }
	}
}