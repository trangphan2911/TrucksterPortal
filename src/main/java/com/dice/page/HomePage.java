package com.dice.page;

import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dice.base.BasePageObject;

public class HomePage extends BasePageObject<HomePage> {
	private static Logger logger = Logger.getLogger(HomePage.class.getSimpleName());
	private static final String URL = "https://tiki.vn/";

	private By headerUser = By.xpath("//span[text()='Đăng nhập']");
	private By loginButton = By.xpath("//button[text()='Đăng nhập']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
	}

	public void openHomePage() {
		logger.info("Navigate to Tiki Website.");
		getPage(URL);
	}

	public void openLoginForm() {
		logger.info("Open Login Form.");
		hoverElement(headerUser);
		clickElement(loginButton);
		scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	public void verifyUserNameLoggedInDisplay(String userName) {
		logger.info("Verify User Name logged in the system displayed correctly.");
		waitForTextValueContains(findElement(headerUser), userName);
//		Scenario scenario;
		scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		Assert.assertTrue(findElement(headerUser).getText().contains(userName),
				String.format("It should be contains %s", userName));
		System.out.println("User Name: " + findElement(headerUser).getText());
	}

}
