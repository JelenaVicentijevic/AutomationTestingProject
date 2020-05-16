package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TxtRead;

public class LogIn {
	
	private static final String URL = "https://sandbox.2checkout.com/sandbox";
	private static final String LOG_IN_URL = "https://sandbox.2checkout.com/sandbox/login";
		
	public static String getLogInUrl() {
		return LOG_IN_URL;
	}

	public static String getNOTIFICATION_MISSING_XPATH() {
		return TxtRead.readText("NOTIFICATION_MISSING_XPATH");
	}

	public static String getNOTIFICATION_INCORRECT_XPATH() {
		return TxtRead.readText("NOTIFICATION_INCORRECT_XPATH");
	}

	public static String getLogInBtnXpath() {
		return TxtRead.readText("LOG_IN_BTN_XPATH");
	}

	// method for opening page
	public static void openLogInPage(WebDriver wd) {
		wd.get(URL);
		wd.manage().window().maximize();
	}
	
	public static void logIn (WebDriver wd, String username, String password) {
		
		WebElement el = wd.findElement(By.name(TxtRead.readText("USERNAME_NAME")));
		el.click();
		el.sendKeys(username);

		el = wd.findElement(By.id(TxtRead.readText("PASSWORD_ID")));
		el.click();
		el.sendKeys(password);

		el = wd.findElement(By.xpath(TxtRead.readText("LOG_IN_BTN_XPATH")));
		el.click();
	}
	
	public static void logOut(WebDriver wd) {
		
		wd.findElement(By.xpath(SignUp.getAccountAvatarXpath())).click();
		wd.findElement(By.xpath(TxtRead.readText("LOG_OUT_BTN_XPATH"))).click();
	}
}
