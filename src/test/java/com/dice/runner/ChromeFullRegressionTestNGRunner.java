package com.dice.runner;

import com.dice.listener.TestNGExecutionListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by thuan.duong on 7/24/2018.
 */
@Listeners(TestNGExecutionListener.class)
@Test
@CucumberOptions(features = {"src/test/java/com/dice/testScenario"}
        ,format={"json:target/cucumber-report.json","html:target/site/cucumber-pretty"}
        ,glue="com.dice.stepDefinitions"/*, tags = "@2713"*/)

public class ChromeFullRegressionTestNGRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void beforeSuite() {
        System.out.println("");
//        Generic.sBrowser = "chrome";
//        Generic.sVersion = "60";
//        Generic.sOS = "WIN10";
    }
}
