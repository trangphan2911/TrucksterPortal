package com.dice.page;

import com.dice.sandbox.ExcelColumn;
import com.dice.support.CustomFindBy;
import com.dice.support.CustomPageFactory;
import com.dice.support.FileBasedElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dice.base.BasePageObject;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class LogInPage extends BasePageObject<LogInPage>{
	
//	private By userNameField = By.xpath("//input[@id='email']");
//	private By passwordField = By.xpath("//input[@id='password']");
//	private By signInButton = By.xpath("//button[contains(@class,'UserModalstyle__RightButton') and text()='Đăng nhập']");

	@CustomFindBy(xpath="//input[@id='email']")
	private WebElement userNameField;

	@CustomFindBy(xpath="//input[@id='password']")
	private WebElement passwordField;

	@CustomFindBy(xpath="//button[contains(@class,'UserModalstyle__RightButton') and text()='Đăng nhập']")
	private WebElement signInButton;

	@CustomFindBy(xpath="//div[contains(@class,'UserModalstyle__RightButton') and text()='Đăng nhập1']")
	private WebElement testButton;
	
	public LogInPage (WebDriver driver){
		super(driver);
//		PageFactory.initElements(factory, this);
		ElementLocatorFactory factory = new FileBasedElementLocatorFactory(driver);
		PageFactory.initElements(factory, this);
//		CustomPageFactory.initElements(driver, this);
	}
	
	public void enterUserNameAndPassword(String userName, String password) {
//		sendText(userNameField, userName);
		System.out.println("enterUserNameAndPassword");
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
//		sendText(passwordField, password);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
}
