package com.dice.base;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public static WebDriver driver;
	public static List<WebDriver> driverList = new ArrayList<WebDriver>();

	public static Scenario scenario;

	public WebDriver getDriver() {
		return driver;
	}

	public void setUpFileWebDriver(){
		System.out.println("Method set up");
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		}else{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		}
	}

}
