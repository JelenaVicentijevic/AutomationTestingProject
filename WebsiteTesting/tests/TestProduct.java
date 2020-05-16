package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import objects.LogIn;
import objects.Product;
import utility.ExcelUtils;

public class TestProduct extends TestWebDriverSet{

	@BeforeClass // log in user to asses products
	public void logInUser() {
		LogIn.openLogInPage(wd);
		LogIn.logIn(wd, "Jelena10", "jeLena257");
	}

	@AfterClass // log out user
	public void logOutUser() {
		LogIn.logOut(wd);
	}

	// adding 5 products and check if they are added successfully
	@Test(priority = 0)
	public void addProducts() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ExcelUtils.setExcell("Products.xlsx");
		ExcelUtils.setWorkSheet(0);

		SoftAssert sa = new SoftAssert();

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			Product.goToPageForAddingNewProduct(wd);
			Product.insertProductName(wd, ExcelUtils.getDataAt(i, 0));
			Product.insertProductId(wd, ExcelUtils.getDataAt(i, 1));
			Product.insertProductShortDescription(wd, ExcelUtils.getDataAt(i, 2));
			Product.insertProductLongDescription(wd, ExcelUtils.getDataAt(i, 3));
			Product.insertPrice(wd, ExcelUtils.getDataAt(i, 4));
			Product.tangibleRadioButton(wd, Boolean.parseBoolean(ExcelUtils.getDataAt(i, 5)));
			boolean additionalFields = Product.recurringRadioButton(wd,
					Boolean.parseBoolean(ExcelUtils.getDataAt(i, 6)));
			if (additionalFields) {
				Product.insertBillEvery(wd, ExcelUtils.getDataAt(i, 7), ExcelUtils.getDataAt(i, 8));
				Product.insertContinueBillingFor(wd, ExcelUtils.getDataAt(i, 9), ExcelUtils.getDataAt(i, 10));
			}
			Product.insertProductURL(wd, ExcelUtils.getDataAt(i, 11));
			Product.submitProduct(wd);

			String expectedNotification = "Update successful";
			String actualNotification = Product.addedProductNotification(wd);

			sa.assertEquals(actualNotification, expectedNotification);

		}

		// view all added products
		Product.goToViewPage(wd);

		// check if product IDs match added products IDs
		List<String> idList = Product.getProductsIds(wd);

		String expectedId;
		String actualId;

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			expectedId = ExcelUtils.getDataAt(i, 1);
			actualId = idList.get(i - 1);
			sa.assertEquals(actualId, expectedId);
		}

		sa.assertAll();
	}

	// increase product prices and check if they are changed successfully
	@Test(priority = 1)
	public void changeProductPrice() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Product.goToEditPage(wd);

		// get current product prices
		List<Double> oldPrices = Product.getProductPrices(wd);

		// increase product prices +100
		double incrementation = 100;
		Product.increaseProductPrice(wd, incrementation);

		// save all price changes
		Product.savePrices(wd);

		SoftAssert sa = new SoftAssert();

		String expectedNotification = "All updates succeeded";
		String actualNotification = Product.changedPricesNotification(wd);

		sa.assertEquals(actualNotification, expectedNotification);

		// get new increased product prices
		List<Double> newPrices = Product.getProductPrices(wd);

		String expectedPrice;
		String actualPrice;

		// check if every new product price is incremented
		for (int i = 0; i < oldPrices.size(); i++) {
			expectedPrice = String.valueOf(oldPrices.get(i) + incrementation);
			actualPrice = String.valueOf(newPrices.get(i));
			sa.assertEquals(actualPrice, expectedPrice);
		}
		sa.assertAll();
	}
}
