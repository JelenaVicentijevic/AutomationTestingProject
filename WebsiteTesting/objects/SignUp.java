package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.TxtRead;

public class SignUp {
	private static final String SIGN_UP_URL = "https://sandbox.2checkout.com/sandbox/signup";
	private static final String LOGGED_IN_URL = "https://sandbox.2checkout.com/sandbox/home/dashboard";

	private static WebElement el;

	public static String getSignUpUrl() {
		return SIGN_UP_URL;
	}

	public static String getLoggedInUrl() {
		return LOGGED_IN_URL;
	}

	public static String getAccountAvatarXpath() {
		return TxtRead.readText("ACCOUNT_AVATAR_XPATH");
	}

	// go to registration page
	public static void openSignUpPage(WebDriver wd) {
		LogIn.openLogInPage(wd);
		wd.findElement(By.linkText(TxtRead.readText("SIGN_UP_LINK"))).click();
	}

	// username
	public static void insertUsername(WebDriver wd, String username) {
		el = wd.findElement(By.xpath(TxtRead.readText("USERNAME_XPATH")));
		el.clear();
		el.sendKeys(username);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// email
	public static void insertEmail(WebDriver wd, String email) {
		el = wd.findElement(By.id(TxtRead.readText("EMAIL_ID")));
		el.clear();
		el.sendKeys(email);
	}

	// password
	public static void insertPassword(WebDriver wd, String password) {
		el = wd.findElement(By.cssSelector(TxtRead.readText("PASSWORD_CSS")));
		el.clear();
		el.sendKeys(password);
	}

	public static void confirmPassword(WebDriver wd, String confirmPass) {
		el = wd.findElement(By.xpath(TxtRead.readText("CONFIRM_XPATH")));
		el.clear();
		el.sendKeys(confirmPass);
	}

	// about you
	public static boolean chooseAboutYou(WebDriver wd, int indexNum) {
		Select aboutYou = new Select(wd.findElement(By.xpath(TxtRead.readText("ABOUT_XPATH"))));
		aboutYou.selectByIndex(indexNum);
		if (indexNum == 1)
			return true;
		return false;
	}

	public static void insertWebsiteUrl(WebDriver wd, String webUrl) {
		el = wd.findElement(By.xpath(TxtRead.readText("WEBSITE_XPATH")));
		el.clear();
		el.sendKeys(webUrl);
	}

	// click on submit button
	public static void submitRegistration(WebDriver wd) {
		wd.findElement(By.id(TxtRead.readText("SUBMIT_BTN_ID"))).click();
	}

	public static String accountUsername(WebDriver wd) {
		wd.findElement(By.xpath(TxtRead.readText("ACCOUNT_AVATAR_XPATH"))).click();
		return wd.findElement(By.xpath(TxtRead.readText("ACCOUNT_USERNAME_XPATH"))).getText();
	}
}
