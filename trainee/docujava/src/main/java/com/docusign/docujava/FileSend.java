package com.docusign.docujava;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FileSend{		 
private static Scanner input;

public static void main(String[] args) throws URISyntaxException, UnirestException, IOException {	
String auth_url="https://account-d.docusign.com/oauth/auth";
String client_id="5af20934-a3a7-45de-a002-e89416aabce8";
String callback_url="https://www.docusign.com";
String secret_key="411f4c83-8848-41d4-80f4-86a6ccefe311";
    	 
//String  response_type="code";
//String scope="signature";


URIBuilder b = new URIBuilder(auth_url);
b.addParameter("response_type", "code");
b.addParameter("scope", "signature");
b.addParameter("client_id", client_id);
b.addParameter("state", "a39fh23hnf23");
b.addParameter("redirect_uri", callback_url);

java.net.URL url = b.build().toURL();
        try{          
            Desktop.getDesktop().browse(url.toURI());
        }
        catch(Exception E){
            System.err.println("Exp : "+E.getMessage());
        }
        
    input = new Scanner(System.in);
    //String authorization_response
    System.out.println("enter url");
   
     String authorization_response =input.nextLine();
    // System.out.println("authorization_response = " + authorization_response);
     
     String auth_code = authorization_response.split("\\=")[1];
     
     //getting authcode
     System.out.println(auth_code);
     
    // BASE64_COMBINATION_OF_INTEGRATOR_AND_SECRET_KEYS
     String encodeBytes = Base64.getEncoder().encodeToString((client_id+":"+secret_key).getBytes());
  System.out.println("encoded value is " + encodeBytes);
  //String  grant_type="authorization_code";
  //Getting access token
  HttpResponse<JsonNode> response = Unirest.post("https://account-d.docusign.com/oauth/token")
		  .header("Authorization", "Basic "+encodeBytes)
		  .header("Content-Type", "application/x-www-form-urlencoded")
		  .body("grant_type=authorization_code&code="+auth_code)
		  .asJson(); 
    JSONObject tokenResponse=response.getBody().getObject();
    //System.out.println(tokenResponse);
    String access_token=tokenResponse.getString("access_token");
    //System.out.println(access_token);
   
    //Getting userinfo i.e baseuri and accountid
    HttpResponse<JsonNode> user_response = Unirest.get("https://account-d.docusign.com/oauth/userinfo")
  		  .header("Authorization", "Bearer "+access_token)
  		  .asJson();
    
      JSONObject user_info=user_response.getBody().getObject();
     // System.out.println(user_info);

     JSONArray accounts = user_info.getJSONArray("accounts");
      String base_uri=accounts.getJSONObject(0).getString("base_uri");
      String account_id=accounts.getJSONObject(0).getString("account_id");
      System.out.println(base_uri);
      System.out.println(account_id);
           
    System.out.println("enter recipient email: ");
  	String mail=input.next();
  	System.out.println("enter recipient name: ");
  	String name=input.next();
  	System.out.println("enter the full path of the file you want to send: ");
  	String file_path=input.next();
          
     // path="/home/vinayr/Desktop/demo.pdf";
		File f =new File(file_path);
		String file_name = f.getName();
	    String fname = file_name.substring(0, file_name.lastIndexOf('.'));
	    System.out.println(fname);
	    String ext = FilenameUtils.getExtension(file_path);
	   System.out.println(ext);
	   byte[] fileContent = FileUtils.readFileToByteArray(f);
		
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
  // System.out.println(encodedString);
		

		HttpResponse<JsonNode> acc_response = Unirest.post(base_uri+"/restapi/v2/accounts/"+account_id+"/envelopes")
				  .header("Authorization", "Bearer "+access_token)
				  .header("Content-Type", "application/json")
				  .body("{\n  \"documents\": [\n    {\n      \"documentBase64\": \""+encodedString+"\",\n      \"documentId\": \"1\",\n      \"fileExtension\": \""+ext+"\",\n      \"name\": \""+fname+"\"\n    }\n  ],\n  \"emailSubject\": \"Please sign the sample file\",\n  \"recipients\": {\n    \"signers\": [\n      {\n        \"email\": \""+mail+"\",\n        \"name\":\""+name+"\",\n        \"recipientId\": \"1\",\n        \"routingOrder\": \"1\",\n        \"tabs\": {\n          \"signHereTabs\": [\n            {\n              \"xPosition\": \"450\",\n              \"yPosition\": \"650\",\n              \"documentId\": \"1\",\n              \"pageNumber\": \"1\"\n            }\n          ]\n        }\n      }\n    ]\n  },\n  \"status\": \"sent\"\n  }")
				  .asJson();
		
		JSONObject env_info=acc_response.getBody().getObject();
	      System.out.println(env_info);
	
 //System.out.println(acc_response);
}
	
}
