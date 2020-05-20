package com.dice.common;

import cucumber.api.DataTable;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by thuan.duong on 7/20/2018.
 */
public class Generic {

    public static String sBrowser = "Chrome";
    public static String sVersion = null;
    public static String sOS = null;
    private static Logger logger = Logger.getLogger(Generic.class.getSimpleName());
    /**
     * Description: Method to read the configuration from Config file.
     *
     * @param sFile FILE Destination
     * @param sKey  KeyWord to read value.
     * @return
     */
    public static String getConfigValue(String sFile, String sKey) {
        logger.info("**** Read Configuration file ****");
        Properties prop = new Properties();
        String sValue = null;
        try {
            InputStream input = new FileInputStream(sFile);
            prop.load(input);
            sValue = prop.getProperty(sKey);
            logger.info("***** Value from Properties file of Parameter: " + sKey + ": " + sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("***** Can not find the properties file ****" + sValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sValue;
    }

    /*
    note: Get form 1 to List size because first row is the header of file
    */
    public static List getTable(DataTable dataTable) {
        LinkedList<List<String>> listDataTable;
        listDataTable = new LinkedList<List<String>>(dataTable.raw());
        listDataTable.remove(0);
        return listDataTable;
    }

    /*
    note: Get form 1 to List size because first row is the header of file
    */
    public static List getList(DataTable dataTable) {

        LinkedList<String> listDataList;
        listDataList = new LinkedList<String>(dataTable.asList(String.class));
        listDataList.remove(0);
        return listDataList;
    }

    public static String GetTimeStampValue() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":", "");
        systime = systime.replace("-", "");
        return systime;
    }
}
