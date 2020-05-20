package com.dice.page;
import com.dice.base.BasePageObject;
import com.dice.support.CustomFindBy;
import com.dice.support.CustomPageFactory;
//import jdk.internal.jline.internal.Log;
import com.dice.support.FileBasedElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TruckPage extends BasePageObject<TruckPage> {

    @CustomFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/button[1]")
    private WebElement addSearchButton;
    @CustomFindBy(xpath = "//button[contains(@class,'el-button filter-item')][2]")
    private WebElement addTruckButton;
    @CustomFindBy(xpath = "//input[@placeholder='Please input name']")
    private WebElement NameTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Keyword']")
    private WebElement SearchTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input Description']")
    private WebElement CompanyTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input phone']")
    private WebElement PhoneTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input contact name']")
    private WebElement ContactNameTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input contact email']")
    private WebElement ConatctEmailTxtBox;
    @CustomFindBy(xpath = "//Please input website url']")
    private WebElement WebsiteTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input facebook url']")
    private WebElement FacebookTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input instagram url']")
    private WebElement InstagramTxtBox;
    @CustomFindBy(xpath = "//input[@placeholder='Please input twitter_url']")
    private WebElement TwitterTxtBox;
    @CustomFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/section/div/div[4]/div/div[2]/div/form/div[7]/div[1]/div/div/div/i")
    private WebElement LogoUpload;
    @CustomFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/section/div/div[4]/div/div[2]/div/form/div[7]/div[2]/div/div/div/i")
    private WebElement CoverUpload;
    @CustomFindBy(xpath = "//*[@id=\"myVueDropzone\"]/div")
    private WebElement PhotoUpload;
    @CustomFindBy(xpath = "//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']")
    private WebElement CuisinesArrow;
    @CustomFindBy(xpath = "//i[@class='el-select__caret el-input__icon el-icon-arrow-up']")
    private WebElement City;
    @CustomFindBy(xpath = "//button[@class='el-button el-button--default el-button--medium']")
    private WebElement CancelButton;
    @CustomFindBy(xpath = "(//*[@class='form-container']//div[@class='dialog-footer']//span)[2]")
    private WebElement ConfirmButton;
    @CustomFindBy(xpath = "//i[@class='el-dialog__close el-icon el-icon-close']")
    private WebElement XButton;
    @CustomFindBy(xpath = "//div[@class='el-select-dropdown__wrap el-scrollbar__wrap el-scrollbar__wrap--hidden-default']")
    private WebElement Select;


    public TruckPage(WebDriver driver) {
        super(driver);
//		PageFactory.initElements(factory, this);
        ElementLocatorFactory factory = new FileBasedElementLocatorFactory(driver);
        PageFactory.initElements(factory, this);
//		CustomPageFactory.initElements(driver, this);
    }

    public void ClickConfirmButton()
    {
        clickElement(ConfirmButton);
//        Log.info("Scroll to Bottom");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        //This will scroll the web page till end.
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    //        WebElement outside = findElement(By.xpath("//*[@class='form-container']/../.."));
//
//        scrollToInsideWebElement(outside, ConfirmButton);
//        waitSomeSecond(5);
//        WebElement addFile = findElement(By.xpath("//*[@class='form-container']//*[@id='myVueDropzone']"));
//        clickElement(addFile);
//        waitSomeSecond(5);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_9);
//        robot.delay(10);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.delay(10);
//        robot.keyPress(KeyEvent.VK_G);
//        robot.delay(10);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(10);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.delay(10);
//        robot.keyRelease(KeyEvent.VK_9);
////        robot.keyRelease(KeyEvent.VK_PAGE_UP);
//        waitSomeSecond(5);
//        waitForVisibilityOf(ConfirmButton);


}


    public void ClickAddButton()
    {
        //addTruckhButton = findElement(By.xpath("//button[contains(@class,'el-button filter-item')][2]"));
        clickElement(addTruckButton);
    }
}

