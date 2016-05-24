package com.free4lab.freemonitor.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.Const;

public class TestBench implements Runnable {
    static Logger         logger      = Logger.getLogger(TestBench.class);
    public static String  PREFIX      = "test";

    String                db_host     = Const.db_host;
    String                db_name     = Const.db_name;
    String                db_password = Const.db_password;
    String                db_username = Const.db_username;
    String                db_table    = Const.db_table;
    protected OutputClient outputclient = newOutputClient();

    /*
     * <p>Title: run</p> <p>Description: </p>
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            Object tester = this.getClass().newInstance();

            Method[] methods = this.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (isToRunMethod(method)) {
                    method.invoke(tester, new Object[0]);
                }
            }
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    boolean isToRunMethod(Method method) {
        if (method.getModifiers() != Modifier.PUBLIC)
            return false;
        return method.isAnnotationPresent(RunTest.class) || method.getName().startsWith(PREFIX);
    }

    OutputClient newOutputClient() {
        return new MultipleClient(db_host, db_name, db_username, db_password, db_table);
    }
}