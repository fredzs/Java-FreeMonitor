package com.free4lab.freemonitor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.Const;

/**
 * @ClassName: MysqlClient
 * @Description: mysql客户端输出
 * @author wenchaoz361
 * @date 2013-3-25 下午6:03:39
 */
public class MysqlClient implements OutputClient {
    Logger        logger = Logger.getLogger(MysqlClient.class);
    DriverManager manager;

    String        host;
    String        database;
    String        username;
    String        password;
    String        tablename;

    String        url;
    Connection    con;

    public MysqlClient(String host,
                       String database,
                       String username,
                       String password,
                       String tablename) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.tablename = tablename;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url = "jdbc:mysql://"
                  + host
                  + "/"
                  + database
                  + "?useUnicode=true&characterEncoding=GBK";
            con = java.sql.DriverManager.getConnection(url, username, password);

        }
        catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*
     * <p>Title: recordData</p> <p>Description: </p>
     * 
     * @param type
     * 
     * @param interfaceName
     * 
     * @param state
     * 
     * @param exceptionMsg
     * 
     * @see
     * com.free4lab.freemonitor.util.OutputClient#recordData(java.lang.String,
     * java.lang.String, int, java.lang.String)
     */
    @Override
    public void recordData(String type, String interfaceName, int state, String exceptionMsg) {
        try {
            if (checkData(type, interfaceName) == false) {
                insertData(type, interfaceName, state, exceptionMsg);
            } else {
                updateData(type, interfaceName, state, exceptionMsg);
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * @Title: updateData
     * @Description: TODO
     * @param type
     * @param interfaceName
     * @param isRight
     * @param exceptionMsg
     */
    void updateData(String type, String interfaceName, int state, String exceptionMsg) {

        String updateSQL = "update " + tablename + " set ";
        String values = "lastRunTime = CURRENT_TIMESTAMP,"
                        + "state="
                        + state
                        + ",exceptionMsg='"
                        + exceptionMsg
                        + "' where type='"
                        + type
                        + "' and interface='"
                        + interfaceName
                        + "';";

        String query = updateSQL + values;

        try {
            executeSql(query);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * @Title: checkData
     * @Description: 检测某一行数据是否存在在表格中
     * @param type
     * @param interfaceName
     * @return
     * @throws Exception
     */
    boolean checkData(String type, String interfaceName) throws Exception {
        String checkSQL = "select * from "
                          + tablename
                          + " where type='"
                          + type
                          + "' and interface='"
                          + interfaceName
                          + "';";
        Statement stmt;
        try {
            if (con != null) {
                stmt = con.createStatement();
                stmt.execute(checkSQL);
                ResultSet resultSet = stmt.getResultSet();
                boolean ret = resultSet.next();
                stmt.close();

                return ret;
            } else {
                logger.error("Connect db:" + host + " failed.");
            }
        }
        catch (SQLException e) {
            logger.error(e.getMessage());
        }
        throw new Exception("check data failed.");
    }

    /**
     * @Title: insertData
     * @Description: 将一行数据插入表格中
     * @param type
     * @param interfaceName
     * @param state
     * @param exceptionMsg
     */
    void insertData(String type, String interfaceName, int state, String exceptionMsg) {
        String insertSQL = "insert into " + tablename + "(type, interface, state, exceptionMsg)";
        String values = " values('"
                        + type
                        + "','"
                        + interfaceName
                        + "',"
                        + state
                        + ",'"
                        + exceptionMsg
                        + "');";

        String query = insertSQL + values;

        try {
            executeSql(query);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * @Title: executeSql
     * @Description: 执行插入操作，没有返回值
     * @param sql
     * @throws Exception
     */
    void executeSql(String sql) throws Exception {
        Statement stmt;

        if (con != null) {
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } else {
            throw new Exception("connect host:" + host + " failed.");
        }
    }

    public static void main(String[] args) {
        String host = "192.168.1.43";
        String database = "exercise";
        String username = "root";
        String password = "telestar";
        String table = "testResult";
        MysqlClient client = new MysqlClient(host, database, username, password, table);
        client.recordData("freesearch", "123", Const.RIGHT, "");
        client.recordData("freemessage", "234", Const.ERROR, "message");
        client.recordData("freedisk", "234", Const.ERROR, "message");
        System.out.println("ok");
    }

}
