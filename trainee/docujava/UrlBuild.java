package module2;

public class Web {
	import java.net.MalformedURLException;
	import java.net.URISyntaxException;
	import java.util.Base64;
		import org.json.JSONObject;
		import com.mashape.unirest.http.HttpResponse;
		import com.mashape.unirest.http.JsonNode;
		import com.mashape.unirest.http.Unirest;
		import com.mashape.unirest.http.exceptions.UnirestException;
		public class Access_token {	
		public static void main(String[] args) throws UnirestException {
				public String ReturnStatus() throws UnirestException, MalformedURLException, URISyntaxException {
					AuthCode b=new AuthCode();
					String auth_code=b.ReturnAuth();	
				String client_id="5af20934-a3a7-45de-a002-e89416aabce8";
				String secret_key="411f4c83-8848-41d4-80f4-86a6ccefe311";
				//String auth_code="eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQgAAAABAAYABwCAyxaASnHWSAgAgFedx0px1kgCAG3Tr024XZdBsUN30c1gEWIVAAEAAAAYAAEAAAAFAAAADQAkAAAANWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4MACAkCm9P3HWSA.O883CdNGZ5rI3wJ2FFrLLkdfKj9JACfJiM3ByzkgGTUP1u2N8hlamCvQYivoqBQQFOccDoWEUEwFisuDwSUVpknMe09QGjpZnmipv7zlZv5nzXeNu2L4gRuyybQq0kyKlk-_v6hzybZwraBahX1THh8-HHs7UkxCo8PM8Fiwjj5O4gUCpmG4XVse8b-bXTDXCPt17AaoBlQaFzNhyqDaFSOhWebZIcd9qzkc2TTc-JiOlIf1RiCgjAqPt4RdV2deEFiGoUenCxdSmclaTkDgCaw341iP-zPODHnTS9zA9D9hWHGaOuIWDOMKFstNevmt8nef2bhvV7LmJdv_gaAIRg&state\n";
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
			    return access_token;

		}
		}
