package com.dice.listener;

import com.dice.common.Generic;
import com.dice.pageData.GenericData;
import com.dice.report.GenerateReport;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thuan.duong on 7/26/2018.
 */
public class JUnitExecutionListener extends RunListener {
    private static Logger logger = Logger.getLogger(JUnitExecutionListener.class.getSimpleName());
    @Override
    public void testStarted(Description description) {
        logger.info("***** TestNG is staring the execution *****");
        try {
            initReportsFolder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void testRunFinished(Result _result) {
        logger.info("***** Generating the Master thought Report *****");
        // Generate HTML Report
        String timeStamp = Generic.GetTimeStampValue();
        Reportable result = GenerateReport.GenerateMasterthoughtReport(timeStamp);
//        File sDateReports = new File(Generic.sDirPath+"/Reports/ImageReports/" + timeStamp);
//        try {
//            logger.info("JUNIT");
//            if (!sDateReports.exists()) {
//                FileUtils.forceMkdir(sDateReports);
//            }
//            sPdfReports = new File(sPdfReports+"/PDFReports_"+ timeStamp +".pdf");
//            // Create Bar char
//            Generic.getFeaturesChart(result.getPassedFeatures(), result.getFailedFeatures(),0, timeStamp);
//            // Create Pie char
//            Generic.getScenariosChart(result.getPassedScenarios(), result.getFailedScenarios(),0, timeStamp);
//            // Create report result
//            ReportResult reportResult= GenerateReport.createReportDetail(timeStamp);
//            // Generate PDF File
//            pdf.toExecute(sPdfReports,timeStamp, reportResult);
//            //Send mail
//            Generic.writeToExcelfile(excelDatas, Generic.sDirPath+"/Reports/FailCase" + timeStamp + ".xlsx");
//            logger.info("BaseInit.sToEmail = " + BaseInit.sToEmail);
//            logger.info("BaseInit.sToEmail = " + BaseInit.sCcEmail);
//            if((null != BaseInit.sToEmail) || (null != BaseInit.sCcEmail)){
//                logger.info("Send Report Mail.");
//                SendReportMail.sendMail(sPdfReports,timeStamp, reportResult);
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        //Send Email

        logger.info("***** Junit has finished, the execution *****");
    }
    public static File sHtmlReports;
    public static File sPdfReports;
//    public static GeneratePDF pdf;
    public static Map<Integer, List<String>> excelDatas;
    public static int failCount;

    public void initReportsFolder() throws IOException {
        try {
            System.out.printf("JUNIT");
            logger.info("***** Start initialize Report folders *****\n");
            sHtmlReports = new File(GenericData.sDirPath + "/Reports/HTMLReports");
            sPdfReports = new File(GenericData.sDirPath + "/Reports/PDFReports");
            excelDatas = new HashMap<>();
            if (!sHtmlReports.exists()) {
                FileUtils.forceMkdir(sHtmlReports);
            }
            if (!sPdfReports.exists()) {
                FileUtils.forceMkdir(sPdfReports);
            }
        } catch (Exception e) {
            logger.info("***** Unable to create reportLB folders: " + e.getMessage());
        }
    }
}
