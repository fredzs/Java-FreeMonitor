package com.free4lab.freemonitor.util;

/**
 * @ClassName: MultipleOutput
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-4-10 上午10:02:22
 */
public class MultipleClient implements OutputClient {

    LolClient lolClient; 
    MysqlClient mysqlClient;
    
    public MultipleClient(String host,
                          String database,
                          String username,
                          String password,
                          String tablename) {
        lolClient = LolClient.getInstance();
        mysqlClient = new MysqlClient(host, database, username, password, tablename);
    }
    
    /* 
    * <p>Title: recordData</p>
    * <p>Description: </p>
    * @param type
    * @param interfaceName
    * @param state
    * @param exceptionMsg
    * @see com.free4lab.freemonitor.util.OutputClient#recordData(java.lang.String, java.lang.String, int, java.lang.String)
    */ 
    @Override
    public void recordData(String type, String interfaceName, int state, String exceptionMsg) {
        lolClient.recordData(type, interfaceName, state, exceptionMsg);
        mysqlClient.recordData(type, interfaceName, state, exceptionMsg);
    }

}
