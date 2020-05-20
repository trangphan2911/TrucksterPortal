package com.dice.report;

import com.dice.common.Generic;
import com.dice.pageData.GenericData;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuan.duong on 7/26/2018.
 */
public class GenerateReport {
    private static Logger logger = Logger.getLogger(GenerateReport.class.getSimpleName());

    public static Reportable GenerateMasterthoughtReport(String sExecuteTime) {
        Reportable result = null;
        try {
            logger.info("START");
            File reportOutputDirectory = new File("Reports/HTMLReports/Report_" + sExecuteTime);
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("./target/cucumber-report.json");
            //jsonFiles.add("cucumber-report-2.json");

            String projectName = "BDD Auvenir Automation Testing";

            Configuration configuration = createConfiguration(reportOutputDirectory, projectName);
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            result = reportBuilder.generateReports();
            logger.info("DONE REPORT");
            // and here validate 'result' to decide what to do
            // if report has failed features, undefined steps etc
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Configuration createConfiguration(File reportOutputDirectory, String projectName){
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        String buildNumber = "1";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        // optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);

        // addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", GenericData.sBrowser);
        configuration.addClassifications("Branch", "release/1.0");
        configuration.addClassifications("Created by","Doai Tran");

        return configuration;
    }
}
