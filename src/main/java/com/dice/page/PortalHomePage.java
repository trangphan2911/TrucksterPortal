package com.dice.page;
import com.dice.base.BasePageObject;
import com.dice.support.CustomFindBy;
import com.dice.support.CustomPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalHomePage extends BasePageObject<PortalHomePage> {
    @CustomFindBy(xpath="//*[@id=\"app\"]/div/div[1]/div[1]/div/ul/div[2]/li/ul/a[1]/li")
    private WebElement truckButton;
    @CustomFindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div/ul/div[2]/li/div")
    private WebElement foodTruckButton;


    public PortalHomePage(WebDriver driver) {
        super(driver);
        CustomPageFactory.initElements(driver, this);
    }
    public void gotoTruckPage()
    {
        foodTruckButton.click();
       waitForVisibilityOf(truckButton,3);
        truckButton.click();
    }
}

