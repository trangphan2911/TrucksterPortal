package com.dice.stepDefinitions;

import com.dice.base.BaseTest;
import com.dice.page.HomePage;
import com.dice.page.LogInPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

import java.util.List;

import static com.dice.common.Generic.getTable;

/**
 * Created by thuan.duong on 7/24/2018.
 */
public class LogInStepDefinition extends BaseTest {
    private static Logger logger = Logger.getLogger(LogInStepDefinition.class.getSimpleName());

    private LogInPage logInPage;
    private HomePage homePage;

    @And("^I open tiki website$")
    public void navigateToHomePage() throws Throwable {
        logger.info("Open tiki website.");
        homePage = new HomePage(getDriver());
        homePage.openHomePage();
    }

    @And("^I navigate to login form$")
    public void iClickBulkActionDropDownOnTodoPage() throws Throwable {
        logger.info("Navigate to login form.");
        homePage = new HomePage(getDriver(), scenario);
        homePage.openLoginForm();
    }

    @And("^I enter Username and Password$")
    public void iClickOnOptionsOnBulkActionDropdown(DataTable table) throws Throwable {
        logger.info("Enter Username and Password.");
        logInPage = new LogInPage(getDriver());
        List<List<String>> listUserNameAndPassword = getTable(table);
        for (List<String> userNameAndPassword: listUserNameAndPassword)
            logInPage.enterUserNameAndPassword(userNameAndPassword.get(0),userNameAndPassword.get(1));
    }

    @And("^I click login button$")
    public void iClickOnOptionsOnBulkActionDropdown() throws Throwable {
        logger.info("Click login button.");
        logInPage = new LogInPage(getDriver());
        logInPage.clickOnSignInButton();
    }

    @And("^I verify the user is logged in successfully: (.*)$")
    public void verifyTheUserIsLoggedInSuccessfully(String userNameProfile) throws Throwable {
        logger.info("Verify the user is logged in successfully.");
        homePage = new HomePage(getDriver(), scenario);
        homePage.verifyUserNameLoggedInDisplay(userNameProfile);
    }

}
