package com.free4lab.freemonitor.testers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.free4lab.freemonitor.Const;
import com.free4lab.freemonitor.util.RunTest;
import com.free4lab.freemonitor.util.TestBench;
import com.free4lab.utils.http.SearchClient;

/**
 * @ClassName: TestSearch
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-3-26 上午9:56:32
 */
public class TestSearch extends TestBench {
    public static String  TYPE         = "freesearch";

    private static Logger logger       = Logger.getLogger(TestSearch.class);

    private static String search_host  = "http://testsearch.free4lab.com";
    SearchClient          searchclient = new SearchClient(search_host);
    static {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("url.properties");
            Properties properties = new Properties();
            properties.load(is);
            search_host = properties.getProperty("search_host", "http://testsearch.free4lab.com");
            logger.info("load search host:" + search_host);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void testAddDoc() {
        String interfaceName = "addDoc";
        try {
            searchclient.addDoc("www.test.com", "test", "test", new ArrayList<String>());
            outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    public void testDelDoc() {
        String interfaceName = "delDoc";
        try {
            searchclient.delDoc("www.test.com");
            outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    public void testUpdateDoc() {
        String interfaceName = "updateDoc";
        try {
            searchclient.updateDoc("www.test.com", "test", "test", null, null, "0", "0");
            outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    public void testWordTip() {
        String interfaceName = "wordTip";
        try {
            searchclient.getWordTip("a");
            outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    public void testGetDoc() {
        String interfaceName = "getDoc";
        String url = "item?id=8";
        try {
            String doc = searchclient.getDoc(url);
            if (doc != null)
                outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
            else
                outputclient.recordData(TYPE, interfaceName, Const.WARNING, "Try to get "
                                                                           + url
                                                                           + " failed.");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    public void testSearchKeyword() {
        String interfaceName = "searchkeyword";
        try {
            String result = searchclient.search("测试", null, null, 0, 100, "json");
            JSONObject obj = new JSONObject(result);
            JSONArray array = obj.getJSONArray("result");
            if (array.length() > 0)
                outputclient.recordData(TYPE, interfaceName, Const.RIGHT, "");
            else
                outputclient.recordData(TYPE,
                                       interfaceName,
                                       Const.WARNING,
                                       "Test get keyword(\"测试\"), but no result.");
        }
        catch (Exception e) {
            outputclient.recordData(TYPE, interfaceName, Const.ERROR, e.getMessage());
        }
    }

    @RunTest
    public void myTest() {
        System.out.println("ok, it' runned.");
    }

    public static void main(String[] args) {
        TestSearch testSearch = new TestSearch();
        testSearch.run();
        System.out.println("ok");
    }

}
