package com.free4lab.freemonitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @ClassName: Const
 * @Description: 常量类
 * @author wenchaoz361
 * @date 2013-3-25 下午5:52:56
 */
public class Const {
    static Logger        logger              = Logger.getLogger(Const.class);
    public static int    RIGHT               = 0;
    public static int    WARNING             = 1;
    public static int    ERROR               = 2;

    public static String db_host             = "192.168.1.43";
    public static String db_name             = "exercise";
    public static String db_password         = "telestar";
    public static String db_username         = "root";
    public static String db_table            = "TestResult";

    public static String configure_file_name = "db.properties";

    static {

        URL url = Const.class.getClassLoader().getResource(configure_file_name);
        InputStream inputStream;
        if (url != null) {
            try {
                inputStream = url.openStream();
                Properties properties = new Properties();
                properties.load(inputStream);

                db_host = properties.getProperty("db_host", db_host);
                db_name = properties.getProperty("db_name", db_name);
                db_password = properties.getProperty("db_password", db_password);
                db_username = properties.getProperty("db_username", db_username);
                db_table = properties.getProperty("db_table", db_table);

                inputStream.close();
            }
            catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

}
