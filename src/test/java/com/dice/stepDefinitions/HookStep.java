package com.dice.stepDefinitions;

import com.dice.base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan.duong on 7/24/2018.
 */
public class HookStep extends BaseTest{
    private static Logger logger = Logger.getLogger(HookStep.class.getSimpleName());

    @Before
    @BeforeMethod
    public void methodSetUp(Scenario scenario) {
        super.scenario = scenario;
        setUpFileWebDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            driver.manage().window().fullscreen();
        }else{
            driver.manage().window().maximize();
        }
        driverList.add(driver);
    }

    @After
    @AfterMethod
    public void methodTearDown(Scenario scenario) {
        logger.info("Method tear down");
        try {
            logger.info("***** Scenario Status: " + scenario.getStatus());
            if (scenario.isFailed() || scenario.getStatus().equals("undefined")) {
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
                //For mobile automation.
//                if (mobileDriver != null)
//                    scenario.embed(((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES), "image/png");
                scenario.write("Scenario failed.");
                logger.info(">>>>>>>>>>>>>> Scenario Status: FAILED <<<<<<<<<<<");
//                getExportFailTestCase(getFeatureName(scenario), scenario.getName());
            } else {
                scenario.write("Scenario Passed");
                logger.info(">>>>>>>>>>>>>> Scenario Status: PASSED <<<<<<<<<<<");
            }
            for (WebDriver dv : driverList){
                driver = dv;
                driver.close();
                driver.quit();
            }
            driverList.clear();
            logger.info("***** Closed browser *****");
            logger.info("||||||||||||||||||||||||||||| End scenario: " + scenario.getName() + ": " + scenario.getStatus() + " |||||||||||||||||||||||||||||");
        }catch (Exception e){
            logger.error("***** There are some errors when closing browser: \n"+e.getMessage() + " ******");
        }

//        System.out.println("Method tear down");
//        driver.quit();
    }
}
