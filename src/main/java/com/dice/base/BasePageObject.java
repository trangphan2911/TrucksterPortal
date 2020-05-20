package com.dice.base;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	public WebDriver driver;
	public WebDriverWait wait;
	public Scenario scenario;


	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	protected BasePageObject(WebDriver driver, Scenario scenario) {
		this.scenario = scenario;
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		System.out.println("Navigate to the page: " + url);
		driver.get(url);
		return (T) this;
	}

	protected WebElement findElement (By element) {
		return driver.findElement(element);
	}
	
	protected void hoverElement(By element) {
		System.out.println("Hover an Element.");
        Actions action = new Actions(driver);
        action.moveToElement(findElement(element));
        action.perform();
	}
	
	protected void clickElement(By element) {
		System.out.println("Click on an Element.");
		findElement(element).click();
	}
	protected void clickElement(WebElement element) {
		System.out.println("Click on an Element.");
		element.click();
	}

	protected void sendText(By Element, String text) {
		System.out.println("Send a Text in an Element.");
		findElement(Element).sendKeys(text);
	}
	protected void sendText(WebElement Element, String text) {
		System.out.println("Send a Text in an Element.");
		Element.sendKeys(text);
	}

	protected void waitForVisibilityOf(WebElement element, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOf(element), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			attempts++;
		}

	}


	private void waitFor(ExpectedCondition<WebElement> expectedCondition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(expectedCondition);
	}
	
	/**
     * Author: Thuan Duong.
     *
     * @param element     element defined on page class
      @param elementName Name of element that we want to verify
      @Description In order to wait element to change Attribute value.
     */
    public boolean waitForAttributeValueChanged(WebElement element, String elementName, String attributeName,
                                                String attributeValue) {
//        logger.info("Try to waitForAtrributeValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualAttributeValue = null;
                    if (element.getAttribute(attributeName) != null) {
                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
                    } else {
//                        logger.info(String.format("Attribute %s is null", attributeName));
                        return false;
                    }
                    if (actualAttributeValue.equals(attributeValue))
                        return true;
                    else
                        return false;
                }
            });
            return true;
        } catch (Exception e) {
//            logger.info(e.getMessage());
            return false;
        }
    }
	
    
    public boolean waitForTextValueContains(WebElement element, String text) {
//        logger.info("Try to waitForAtrributeValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    if (element.getText() != null){
                    	System.out.println(element.getText());
                        return element.getText().contains(text);
                    }
                    return false;
                }
            });
            return true;
        } catch (Exception e) {
//            logger.info(e.getMessage());
            return false;
        }
    }
    
    public void waitSomeSecond(int time) {
    	try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
