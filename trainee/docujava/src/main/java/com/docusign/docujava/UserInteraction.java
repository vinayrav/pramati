package com.docusign.docujava;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UserInteraction {
 private static Scanner input;
 public static void main(String[] args) throws UnirestException, URISyntaxException, IOException {
  Requests c = new Requests();
  String data[] = c.ReturnUser();
  //System.out.println(data[0]);
  //System.out.println(data[1]);
  input = new Scanner(System.in);
  System.out.println("enter recipient email: ");
  String mail = input.next();
  System.out.println("enter recipient name: ");
  String name = input.next();
  System.out.println("enter the full path of the file you want to send: ");
  String file_path = input.next();
  //Provide the complete path of file to be signed
  // eg:"/home/vinayr/Desktop/demo.pdf";
  File f = new File(file_path);
  String file_name = f.getName();
  String fname = file_name.substring(0, file_name.lastIndexOf('.'));
  System.out.println(fname);
  String ext = FilenameUtils.getExtension(file_path);
  System.out.println(ext);
  //converting the file into base64
  byte[] fileContent = FileUtils.readFileToByteArray(f);
  String encodedString = Base64.getEncoder().encodeToString(fileContent);
  // System.out.println(encodedString);
  HttpResponse < JsonNode > acc_response = Unirest.post(data[0] + "/restapi/v2/accounts/" + data[1] + "/envelopes")
   .header("Authorization", "Bearer " + data[2])
   .header("Content-Type", "application/json")
   .body("{\n  \"documents\": [\n    {\n      \"documentBase64\": \"" + encodedString + "\",\n      \"documentId\": \"1\",\n      \"fileExtension\": \"" + ext + "\",\n      \"name\": \"" + fname + "\"\n    }\n  ],\n  \"emailSubject\": \"Please sign the sample file\",\n  \"recipients\": {\n    \"signers\": [\n      {\n        \"email\": \"" + mail + "\",\n        \"name\":\"" + name + "\",\n        \"recipientId\": \"1\",\n        \"routingOrder\": \"1\",\n        \"tabs\": {\n          \"signHereTabs\": [\n            {\n              \"xPosition\": \"450\",\n              \"yPosition\": \"650\",\n              \"documentId\": \"1\",\n              \"pageNumber\": \"1\"\n            }\n          ]\n        }\n      }\n    ]\n  },\n  \"status\": \"sent\"\n  }")
   .asJson();
  JSONObject env_info = acc_response.getBody().getObject();
  System.out.println(env_info);
  //System.out.println(acc_response);
 }
}