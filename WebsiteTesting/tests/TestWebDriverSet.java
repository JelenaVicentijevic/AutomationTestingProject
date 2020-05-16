package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebDriverSet {

	protected static WebDriver wd;
	
  @BeforeSuite //set driver
  public void setDriver() {
	  WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
  }
  
  @AfterSuite //close driver
  public void closeDriver() {
	  wd.quit();
  }
  
}
