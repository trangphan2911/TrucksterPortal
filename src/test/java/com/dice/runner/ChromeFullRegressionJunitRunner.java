package com.dice.runner;

import com.dice.common.Generic;
import com.dice.listener.CustomCucumberRunner;
import com.dice.listener.TestNGExecutionListener;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by thuan.duong on 7/30/2018.
 */

@RunWith(CustomCucumberRunner.class)
@Test
@CucumberOptions(features = {"src/test/java/com/dice/testScenario"}
        ,format={"json:target/cucumber-report.json","html:target/site/cucumber-pretty"}
        ,glue="com.dice.stepDefinitions"/*, tags = "@2713"*/)
public class ChromeFullRegressionJunitRunner {
    @BeforeClass
    public static void beforeSuite() {
        Generic.sBrowser = "chrome";
        Generic.sVersion = "60";
        Generic.sOS = "WIN10";
    }
}
