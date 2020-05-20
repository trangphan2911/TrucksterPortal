package com.dice.test;

import com.dice.stepDefinitions.HookStep;
import com.dice.testData.HomeTestData;
import com.dice.testData.LogInTestData;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.dice.base.BaseTest;
import com.dice.page.HomePage;
import com.dice.page.LogInPage;

public class LogInTest extends HookStep{
	private static Logger logger = Logger.getLogger(LogInTest.class.getSimpleName());
	@Test
	public void positiveLogInTest() {
		LogInPage logInPage = new LogInPage(getDriver());
		HomePage homePage = new HomePage(getDriver());

		logger.info("Open tiki website.");
		homePage.openHomePage();
		logger.info("Navigate to login form.");
		homePage.openLoginForm();
		logger.info("Enter Username and Password.");
		logInPage.enterUserNameAndPassword(LogInTestData.userNameOrEmail, LogInTestData.password);
		logger.info("Click login button.");
		logInPage.clickOnSignInButton();
		logger.info("Verify the user is logged in successfully.");
		homePage.verifyUserNameLoggedInDisplay(HomeTestData.userNameProfile);
		
	}

}
