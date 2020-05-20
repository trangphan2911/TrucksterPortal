package com.dice.page;


import com.dice.base.BasePageObject;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPortalPage extends BasePageObject<LogInPortalPage> {
    private static Logger logger = Logger.getLogger(LogInPortalPage.class.getSimpleName());
    private static final String URL = "http://portal-dev.gotruckster.com/";
    private By Username = By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div[1]/input");
    private By Password = By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div[1]/input");
    private By submitButton= By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button");

    public LogInPortalPage(WebDriver driver) {
        super(driver);
    }

    public LogInPortalPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }
    public void openLoginPortalPage ()
    {
        logger.info("Navigate to Portal Website.");
        getPage(URL);
    }
    public void loginasAdmin(String email, String password)
    {
        logger.info(("Log in to Website"));
        sendText(Username,email);
        sendText(Password,password);
        clickElement(submitButton);
    }
}

