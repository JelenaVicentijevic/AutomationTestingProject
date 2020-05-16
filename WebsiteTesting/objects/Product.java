package objects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.TxtRead;

public class Product {
	
	private static WebElement el;
	private static double oldPrice;
	private static double newPrice;

	// go to product adding page
	public static void goToPageForAddingNewProduct(WebDriver wd) {
		wd.findElement(By.xpath(TxtRead.readText("PRODUCT_ICON_XPATH"))).click();
		wd.findElement(By.xpath(TxtRead.readText("ADD_PRODUCT_XPATH"))).click();
	}

	// product name
	public static void insertProductName(WebDriver wd, String productName) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRODUCT_NAME_XPATH")));
		el.clear();
		el.sendKeys(productName);
	}

	// product id
	public static void insertProductId(WebDriver wd, String id) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRODUCT_ID_XPATH")));
		el.clear();
		el.sendKeys(id);
	}

	// product short description
	public static void insertProductShortDescription(WebDriver wd, String shortDescription) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRODUCT_SHORT_DESCRIPTION_XPATH")));
		el.clear();
		el.sendKeys(shortDescription);
	}

	// product long description
	public static void insertProductLongDescription(WebDriver wd, String longDescription) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRODUCT_LONG_DESCRIPTION_XPATH")));
		el.clear();
		el.sendKeys(longDescription);
	}

	// product price
	public static void insertPrice(WebDriver wd, String price) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRICE_XPATH")));
		el.clear();
		el.sendKeys(price);
	}

	// tangible radio button
	public static void tangibleRadioButton(WebDriver wd, boolean rButton) {
		if (rButton)
			wd.findElement(By.xpath(TxtRead.readText("TRBTN_YES_XPATH"))).click();
		else
			wd.findElement(By.xpath(TxtRead.readText("TRBTN_NO_XPATH"))).click();
	}

	// recurring radio button
	public static boolean recurringRadioButton(WebDriver wd, boolean rButton) {
		if (rButton) {
			wd.findElement(By.xpath(TxtRead.readText("RRBTN_YES_XPATH"))).click();
			return true;
		} else {
			wd.findElement(By.xpath(TxtRead.readText("RRBTN_NO_XPATH"))).click();
			return false;
		}
	}

	// bill every
	public static void insertBillEvery(WebDriver wd, String num, String time) {
		el = wd.findElement(By.xpath(TxtRead.readText("BILL_XPATH")));
		el.clear();
		el.sendKeys(num);

		switch (time) {
		case "week":
			wd.findElement(By.xpath(TxtRead.readText("BILL_WEEK_XPATH"))).click();
			break;
		case "month":
			wd.findElement(By.xpath(TxtRead.readText("BILL_MONTH_XPATH"))).click();
			break;
		case "year":
			wd.findElement(By.xpath(TxtRead.readText("BILL_YEAR_XPATH"))).click();
			break;
		default:
			break;
		}
	}

	// continue billing for
	public static void insertContinueBillingFor(WebDriver wd, String num, String time) {
		el = wd.findElement(By.xpath(TxtRead.readText("CONTINUE_BILL_XPATH")));
		el.clear();
		el.sendKeys(num);

		switch (time) {
		case "week":
			wd.findElement(By.xpath(TxtRead.readText("CBILL_WEEK_XPATH"))).click();
			break;
		case "month":
			wd.findElement(By.xpath(TxtRead.readText("CBILL_MONTH_XPATH"))).click();
			break;
		case "year":
			wd.findElement(By.xpath(TxtRead.readText("CBILL_YEAR_XPATH"))).click();
			break;
		case "forever":
			wd.findElement(By.xpath(TxtRead.readText("CBILL_FOREVER_XPATH"))).click();
			break;
		default:
			break;
		}
	}

	// product URL
	public static void insertProductURL(WebDriver wd, String productURL) {
		el = wd.findElement(By.xpath(TxtRead.readText("PRODUCT_URL_XPATH")));
		el.clear();
		el.sendKeys(productURL);
	}

	// submit
	public static void submitProduct(WebDriver wd) {
		wd.findElement(By.xpath(TxtRead.readText("SUBMIT_BTN_XPATH"))).click();
	}

	// notification
	public static String addedProductNotification(WebDriver wd) {
		return wd.findElement(By.xpath(TxtRead.readText("PRODUCT_ADDED_XPATH"))).getText();
	}

	// go to view products page
	public static void goToViewPage(WebDriver wd) {
		wd.findElement(By.xpath(TxtRead.readText("VIEW_XPATH"))).click();
	}

	// get all products IDs
	public static List<String> getProductsIds(WebDriver wd){
		List<WebElement> elements = wd.findElements(By.xpath(TxtRead.readText("IDS_XPATH")));
		List<String> idList = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			idList.add(i,elements.get(i).getText());
		}
		return idList;
	}

	// go to view products page
		public static void goToEditPage(WebDriver wd) {
			wd.findElement(By.xpath(TxtRead.readText("EDIT_XPATH"))).click();
		}
	
	// get all product prices
	public static List<Double> getProductPrices(WebDriver wd) {
		List<WebElement> elements = wd.findElements(By.xpath(TxtRead.readText("PRICES_XPATH")));
		List<Double> prices = new ArrayList<Double>();
		
		for (int i = 0; i < elements.size(); i++) {
			prices.add(Double.parseDouble(elements.get(i).getAttribute("value")));
		}
		return prices;
	}

	// increase all product prices
	public static void increaseProductPrice(WebDriver wd, double incrementation) {

		List<WebElement> elements = wd.findElements(By.xpath(TxtRead.readText("PRICES_XPATH")));
		for (int i = 0; i < elements.size(); i++) {
			oldPrice = Double.parseDouble(elements.get(i).getAttribute("value"));
			newPrice = oldPrice + incrementation;
			System.out.println(newPrice);
			elements.get(i).click();
			elements.get(i).clear();
			elements.get(i).sendKeys(String.valueOf(newPrice));
		}

	}
	
	// save changed prices
		public static void savePrices(WebDriver wd) {
			wd.findElement(By.xpath(TxtRead.readText("SAVE_BTN_XPATH"))).click();
		}
		
	// save prices notification
		public static String changedPricesNotification(WebDriver wd) {
			return wd.findElement(By.xpath(TxtRead.readText("SAVE_NOTIFICATION_XPATH"))).getText();
		}
}
