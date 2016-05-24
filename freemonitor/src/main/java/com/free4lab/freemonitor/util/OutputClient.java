package com.free4lab.freemonitor.util;

/**
 * @ClassName: OutputClient
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-4-9 下午8:46:28
 */
public interface OutputClient {
    
    public void recordData(String type, String interfaceName, int state, String exceptionMsg);
    
}
