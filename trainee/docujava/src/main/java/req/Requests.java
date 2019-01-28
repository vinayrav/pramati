package req;

import url.UrlBuild;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class Requests {
public String[] ar;
 //public static void main(String[] args) throws UnirestException {
 
 public String ReturnStatus() throws UnirestException, MalformedURLException, URISyntaxException {
  UrlBuild b = new UrlBuild();
  String auth_code = b.ReturnAuth();
  //combine and encoding client and secret key into base 64
  String encodeBytes = Base64.getEncoder().encodeToString((b.client_id + ":" + b.secret_key).getBytes());
  System.out.println("encoded value is " + encodeBytes);
  System.out.println(b.client_id);
  //Getting access token
  HttpResponse < JsonNode > response = Unirest.post("https://account-d.docusign.com/oauth/token")
   .header("Authorization", "Basic " + encodeBytes)
   .header("Content-Type", "application/x-www-form-urlencoded")
   .body("grant_type=authorization_code&code=" + auth_code)
   .asJson();
  JSONObject tokenResponse = response.getBody().getObject();
  //System.out.println(tokenResponse);
  String access_token = tokenResponse.getString("access_token");
  return access_token;
 }
 
 public String[] ReturnUser() throws UnirestException, MalformedURLException, URISyntaxException {
  Requests c = new Requests();
  String token = c.ReturnStatus();
  HttpResponse < JsonNode > user_response = Unirest.get("https://account-d.docusign.com/oauth/userinfo")
   .header("Authorization", "Bearer " + token)
   .asJson();
  JSONObject user_info = user_response.getBody().getObject();
  /* System.out.println(user_info);
  getting user info i.e
  baseuri
  account id*/
  JSONArray accounts = user_info.getJSONArray("accounts");
  String base_uri = accounts.getJSONObject(0).getString("base_uri");
  String account_id = accounts.getJSONObject(0).getString("account_id");
  String ar[] = new String[3];
  ar[0] = base_uri;
  ar[1] = account_id;
  ar[2] = token;
  return ar;
 }
}

