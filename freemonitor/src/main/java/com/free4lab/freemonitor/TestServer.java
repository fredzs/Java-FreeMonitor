package com.free4lab.freemonitor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @ClassName: TestServer
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-3-26 下午2:30:05
 */
public class TestServer implements Runnable {
    private Logger logger      = Logger.getLogger(TestServer.class);
    static String  config_file = "testers.json";
    static String  PREFIX      = "Test";

    /*
     * <p>Title: run</p> <p>Description: </p>
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            List<String> classNames = getClasses();
            for (String className : classNames) {
                Class<?> c = Class.forName(className);
                Runnable runnable = (Runnable) c.newInstance();
                runnable.run();
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @SuppressWarnings("rawtypes")
    List<String> getClasses() throws Exception {
        List<String> ret = new ArrayList<String>();

        InputStream is = ClassLoader.getSystemResourceAsStream(config_file);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (in.ready()) {
            sb.append(in.readLine());
        }

        JSONObject obj = new JSONObject(sb.toString());
        Iterator packageNames = obj.sortedKeys();
        while (packageNames.hasNext()) {
            String packageName = packageNames.next().toString();
            JSONArray classNames = obj.getJSONArray(packageName);

            for (int i = 0; i < classNames.length(); i++) {
                ret.add(packageName + "." + classNames.getString(i));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        TestServer server = new TestServer();
        while (true) {
            try {
                server.run();
                Thread.sleep(600000);
            }
            catch (InterruptedException e) {}
            catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
