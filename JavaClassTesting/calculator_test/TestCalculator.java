package calculator_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import calculator.Calculator;

public class TestCalculator {

	private Calculator calc = new Calculator();
	private double expectedValue;
	private double actualValue;
	private double value;
	
	// test method getValue
	@Test (priority = 1)
	public void testCalculatorGetValue() {
		value = -33.33;
		actualValue = calc.getValue();
		expectedValue = value;
		Assert.assertEquals(actualValue, expectedValue);
	}

	// test method setValue
	@Test
	public void testCalculatorSetValue() {
		value = -33.33;
		calc.setValue(value);
		actualValue = calc.getValue();
		expectedValue = value;	
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	// test method add with different values
	@Test(dataProvider = "Provider", priority = 2)
	public void testCalculatorAdd(double num) {
		value = calc.getValue();
		calc.add(num);
		actualValue = calc.getValue();
		expectedValue = value + num;
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	// test method div with different values
	@Test(dataProvider = "Provider", priority = 3)
	public void testCalculatorDiv(double num) {
		value = calc.getValue();
		calc.div(num);
		if (num == 0.00)
			expectedValue = value;
		else
			expectedValue = value / num;
		actualValue = calc.getValue();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@DataProvider(name = "Provider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { 150.0 }, { -50.0 }, { 0.0 } };

	}
}
