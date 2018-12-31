package com.docusign.docsend;
import com.docusign.docsend.File;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.Base64;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.Unirest.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Token {
	public static void main(String[] args) throws UnirestException,FileNotFoundException{
		String client_id="5af20934-a3a7-45de-a002-e89416aabce8";
		String secret_key="411f4c83-8848-41d4-80f4-86a6ccefe311";
		String encodeBytes="NWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4OjQxMWY0YzgzLTg4NDgtNDFkNC04MGY0LTg2YTZjY2VmZTMxMQ==";
	//	String encodeBytes = Base64.getEncoder().encodeToString((client_id+":"+secret_key).getBytes());
	//String state="a39fh23hnf23";
	//String auth_code="eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQgAAAABAAYABwAA3UOiHG7WSAgAAGnK6Rxu1kgCAG3Tr024XZdBsUN30c1gEWIVAAEAAAAYAAEAAAAFAAAADQAkAAAANWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4MAAAz5UHGW7WSA.QuDsAmOSzRKYNHmxxcUrbyig6xjYwM2NzfNJtunIer4u7XL0DyRuHZwzr5Gg0lg7JyT6KnEfHv9pzlWRIQokCmpjXVBDslmVT1yFSqbfFjjb0vRfPmMEKrYapyQjo5Y59CVBVJ3iCFRg9gskNUg2w5o-wubePyO-ptl8o54-Gj522piHp7aG-6pqgrwfrXBxspdZxHAjOuPvt-yOO3QmtLbBNVZRZL_hys7SzpB7iznPzeUJ1HqQx_ompPGb9TE_odOw_VZgTsQlHpMDz79R6QURNCd7A2hQsFkWTNaniKHmpfWBtg0XGZM0_zLsLPZ91G6n3SYHoCTbQwmnaCQrvA";
	HttpResponse<JsonNode> response = Unirest.post("https://account-d.docusign.com/oauth/token")
			  .header("Authorization","Basic NWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4OjQxMWY0YzgzLTg4NDgtNDFkNC04MGY0LTg2YTZjY2VmZTMxMQ==")
			  .body("{\"grant_type\":\"authorization_code\",\"code\":\"eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQgAAAABAAYABwAAoechSW7WSAgAAC1uaUlu1kgCAG3Tr024XZdBsUN30c1gEWIVAAEAAAAYAAEAAAAFAAAADQAkAAAANWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4MAAAz5UHGW7WSA.NAIuw8vnsTQ3Y37vDnm-eYYhPdWsOU9f5r7RclQ7JpOorm44Y4zwSXAQ_sXeMlCMGk87vOtlpFRpnJo1yzxVce85xD4Gyjm4h2Ch1rt0EWKSckYwa4svBEsu8-U9ckaQBJxc8aROPdiFChQGZ3MdE2HgIEl6y4I8HeOCAZFjpYAQY0KwzUH3iKr2gh3JYA29tJa4GJ64Hc7Gvr11XLXyD48ekjjfqNb4iOY_f9ci3g_FchueKygpJaYz4gwPs1npCeSxASAuwPLoqejJ6pCAAbVIyMGkYzrYE9oGJfeIs91AntEcfd8UKFR819JTToJU9FPHNGsL01mZI9bJg6OCAA\",\"state\":\"a39fh23hnf23\"}")
			  .asJson();
	  
	    JSONObject tokenResponse=response.getBody().getObject();
	    System.out.println(tokenResponse);
	    String access_token=tokenResponse.getString("access_token");
	    System.out.println(access_token);

}
}
