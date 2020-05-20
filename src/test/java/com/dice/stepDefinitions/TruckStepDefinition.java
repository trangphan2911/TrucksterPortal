package com.dice.stepDefinitions;

import com.dice.base.BasePageObject;
import com.dice.base.BaseTest;
import com.dice.page.PortalHomePage;
import com.dice.page.LogInPortalPage;
import com.dice.page.TruckPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.apache.log4j.Logger;
import com.dice.page.TruckPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class TruckStepDefinition extends BaseTest {
    private static Logger logger = Logger.getLogger(LogInStepDefinition.class.getSimpleName());
    private LogInPortalPage logInPortalPage;
    private PortalHomePage homePortalPage;
    private TruckPage truckPage;


    @Given("^I was on Truck Page$")
    public void i_was_on_Truck_Page() throws Throwable {
        logger.info("Open Truckster Portal website.");
        logInPortalPage = new LogInPortalPage(getDriver());
        logInPortalPage.openLoginPortalPage();
        logInPortalPage.loginasAdmin("portal@gotruckster.com","Launchdeck123");

    }
    @When("^I click on Add button$")
    public void i_click_on_Add_button() throws Throwable {
        logger.info("I click on Add Truck button");
        homePortalPage = new PortalHomePage(getDriver());
        homePortalPage.gotoTruckPage();
        truckPage = new TruckPage(getDriver());
        truckPage.ClickAddButton();

    }

    @And("^I click on Confirm button$")
    public void i_click_on_Confirm_button() throws Throwable {
        logger.info("I click on Confirm button");
        Thread.sleep(3000);
        truckPage.ClickConfirmButton();
    }

    @Then("^Displaying error messages for missing fields$")
    public void displaying_error_messages_for_missing_fields() throws Throwable {
        logger.info("Check error");
        Thread.sleep(3000);
        assertEquals("Name is required3333", driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[4]/div/div[2]/div/form/div[1]/div/div[2]")).getText());
        System.out.println("Finish");
    }


}
