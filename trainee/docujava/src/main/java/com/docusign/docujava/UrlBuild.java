package com.docusign.docujava;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlBuild {
 public String client_id = "5af20934-a3a7-45de-a002-e89416aabce8";
 public String secret_key = "411f4c83-8848-41d4-80f4-86a6ccefe311";
 public String ReturnAuth() throws MalformedURLException, URISyntaxException {
  String auth_url = "https://account-d.docusign.com/oauth/auth";
  String callback_url = "https://www.docusign.com";
  URIBuilder b = new URIBuilder(auth_url);
  b.addParameter("response_type", "code");
  b.addParameter("scope", "signature");
  b.addParameter("client_id", client_id);
  b.addParameter("state", "a39fh23hnf23");
  b.addParameter("redirect_uri", callback_url);
  //Building url
  URL url = b.build().toURL();
  System.setProperty("webdriver.chrome.driver", "//home/vinayr/Desktop//chromedriver");
  WebDriver driver = new ChromeDriver();
  driver.get(url.toString());
  driver.findElement(By.id("username")).sendKeys("krohithvarma1997@gmail.com");
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  driver.findElement(By.id("password")).sendKeys("Mappingman123@");
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  String ur=driver.getCurrentUrl();
  String auth_code = ur.split("\\=")[1];
  //getting authcode
  return auth_code;
 }
}