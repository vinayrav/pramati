package url;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.http.client.utils.URIBuilder;

public class UrlBuild {
	public String client_id = "5af20934-a3a7-45de-a002-e89416aabce8";
	 public String secret_key = "411f4c83-8848-41d4-80f4-86a6ccefe311";
	 private Scanner input;
	 //public static void main(String[] args) throws URISyntaxException, UnirestException, IOException {
	 public String ReturnAuth() throws MalformedURLException, URISyntaxException {
	  String auth_url = "https://account-d.docusign.com/oauth/auth";
	  //String token_url="https://account-d.docusign.com/oauth/token";
	  String callback_url = "https://www.docusign.com";
	  //String state="a39fh23hnf23";
	  URIBuilder b = new URIBuilder(auth_url);
	  b.addParameter("response_type", "code");
	  b.addParameter("scope", "signature");
	  b.addParameter("client_id", client_id);
	  b.addParameter("state", "a39fh23hnf23");
	  b.addParameter("redirect_uri", callback_url);
	  //Building url
	  java.net.URL url = b.build().toURL();
	  try {
	   Desktop.getDesktop().browse(url.toURI());
	  } catch (Exception E) {
	   System.err.println("Exp : " + E.getMessage());
	  }
	  input = new Scanner(System.in);
	  //Ask user to copy the url
	  System.out.println("enter url");
	  String authorization_response = input.nextLine();
	  // System.out.println("authorization_response = " + authorization_response);
	  String auth_code = authorization_response.split("\\=")[1];
	  //getting authcode
	  return auth_code;
	 }
	}
