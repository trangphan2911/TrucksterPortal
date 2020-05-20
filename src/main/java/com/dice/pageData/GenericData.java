package com.dice.pageData;

import org.apache.log4j.Logger;

/**
 * Created by thuan.duong on 7/26/2018.
 * This provide data for Generic Class
 */
public class GenericData {
    private static Logger logger = Logger.getLogger(GenericData.class.getSimpleName());
    public static String sDirPath = System.getProperty("user.dir");
    public static String sUserPath = System.getProperty("user.home");
    public static String sBrowser = "Chrome";
}
