package com.free4lab.freemonitor.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.free4lab.freemonitor.manager.LogManager;
import com.free4lab.freemonitor.model.dao.TestResult;
import com.free4lab.freemonitor.model.dao.TestResultDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GetLogsAction extends ActionSupport{
	
	/**
	 * 获取全部服务的工作状态
	 */
    private static final Logger logger = Logger.getLogger(LogManager.class);
	private static final long serialVersionUID = 1597845248940902378L;
	private List<TestResult> allLogList = new ArrayList<TestResult>();
	private List<TestResult> badLogList = new ArrayList<TestResult>();
    private String type;  
	public String execute(){
	    try {
	        logger.info("准备获取错误日志list");
	        allLogList = new TestResultDAO().getAllLogs(type);
	        badLogList = new TestResultDAO().getBadLogs(type);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return SUCCESS;
	}
    /**
     * @return the allLogList
     */
    public List<TestResult> getAllLogList() {
        return allLogList;
    }
    /**
     * @param allLogList the allLogList to set
     */
    public void setAllLogList(List<TestResult> allLogList) {
        this.allLogList = allLogList;
    }
    /**
     * @return the badLogList
     */
    public List<TestResult> getBadLogList() {
        return badLogList;
    }
    /**
     * @param badLogList the badLogList to set
     */
    public void setBadLogList(List<TestResult> badLogList) {
        this.badLogList = badLogList;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	
    
}
