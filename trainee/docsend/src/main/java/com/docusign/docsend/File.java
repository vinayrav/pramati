package com.docusign.docsend;
//import com.docusign.docsend.Base64File;
import java.awt.Desktop;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.URIBuilder;
import org.json.*;

import java.util.Base64;
import org.apache.commons.io.FileUtils;
import java.util.Map;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.Unirest.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Base64;
import java.io.*;
import org.apache.commons.io.*;


public class File{
	
  
public File(String path) {
		// TODO Auto-generated constructor stub
	}

public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException, UnirestException {

	
String auth_url="https://account-d.docusign.com/oauth/auth";
String client_id="5af20934-a3a7-45de-a002-e89416aabce8";
String token_url="https://account-d.docusign.com/oauth/token";
String callback_url="https://www.docusign.com";
String secret_key="411f4c83-8848-41d4-80f4-86a6ccefe311";
    	 
/*String[] auth_query_params= {"response_type"="code","scope"="signature","client_id"=client_id,"state"="a39fh23hnf23","redirect_uri"=callback_url};
// construct the authorization url
String final_auth_url = auth_url+"?{}".format(urllib.urlencode(auth_query_params));
   */  
String  response_type="code";
String scope="signature";
String state="a39fh23hnf23";
//String url = "https://account-d.docusign.com/oauth/auth?response_type=,scope=,state" + URLEncoder.encode(response_type, "UTF-8");
URIBuilder b = new URIBuilder(auth_url);
b.addParameter("response_type", "code");
b.addParameter("scope", "signature");
b.addParameter("client_id", client_id);
b.addParameter("state", "a39fh23hnf23");
b.addParameter("redirect_uri", callback_url);

URL url = b.build().toURL();
        try{          
            Desktop.getDesktop().browse(url.toURI());
        }
        catch(Exception E){
            System.err.println("Exp : "+E.getMessage());
        }
        
    Scanner input = new Scanner(System.in);
    //String authorization_response
    System.out.println("enter url");
   
     String authorization_response =input.nextLine();
     System.out.println("authorization_response = " + authorization_response);
     
     String auth_code = authorization_response.split("\\=")[1];
     //String stat = authorization_response.split("\\&")[1];
     //getting authcode
     System.out.println(auth_code);
    // System.out.println(stat);
     
     
     //System.out.println("code = " + url.getcode());
//String  response_type="code";
     
     
    // BASE64_COMBINATION_OF_INTEGRATOR_AND_SECRET_KEYS
     String encodeBytes = Base64.getEncoder().encodeToString((client_id+":"+secret_key).getBytes());
  System.out.println("encoded value is " + encodeBytes);
  String  grant_type="authorization_code";
  //String  code=" auth_code";
  HttpResponse<JsonNode> response = Unirest.post("https://account-d.docusign.com/oauth/token")
		  .header("Authorization", "Basic NWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4OjQxMWY0YzgzLTg4NDgtNDFkNC04MGY0LTg2YTZjY2VmZTMxMQ==")
		  .header("Content-Type", "application/x-www-form-urlencoded")
		  .body("grant_type=authorization_code&code="+auth_code)
		  .asJson();
  
    JSONObject tokenResponse=response.getBody().getObject();
    System.out.println(tokenResponse);
    String access_token=tokenResponse.getString("access_token");
    System.out.println(access_token);
    
    HttpResponse<JsonNode> user_response = Unirest.get("https://account-d.docusign.com/oauth/userinfo")
  		  .header("Authorization", "Bearer "+access_token)
  		  .asJson();
    
      JSONObject user_info=user_response.getBody().getObject();
      System.out.println(user_info);

     JSONArray accounts = user_info.getJSONArray("accounts");
      String base_uri=accounts.getJSONObject(0).getString("base_uri");
      String account_id=accounts.getJSONObject(0).getString("account_id");
      System.out.println(base_uri);
      System.out.println(account_id);
      
      
      String path="/home/vinayr/Desktop/demo.pdf";
		File f =new File(path);

		byte[] fileContent = FileUtils.readFileToByteArray(f);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
   System.out.println(encodedString);
	
}
	
}


	

	

	