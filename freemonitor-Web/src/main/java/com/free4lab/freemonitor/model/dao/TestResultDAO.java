package com.free4lab.freemonitor.model.dao;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Query;

import com.free4lab.utils.sql.*;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;


/**
 * The persistent class for the TestResult database table.
 * 
 */
    public class TestResultDAO  extends AbstractDAO<TestResult> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
    @Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return TestResult.class;
	}
	public String getClassName() {
		return getEntityClass().getName();
	}
	@Override
	public IEntityManagerHelper getEntityManagerHelper() {
		// TODO Auto-generated method stub
		return new NoCacheEntityManagerHelper();
	}
	public static final String PU_NAME = "RESULTPU";
	@Override
	public String getPUName() {
		// TODO Auto-generated method stub
		return PU_NAME;
	}
	
	//根据服务名称和每一个接口名，在数据库中查询该接口最新的工作状态
	@SuppressWarnings("unchecked")
    public List<Integer> findInterfaceStatus(String type) {
        String queryString = "select state from TestResult where type =:type";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("type", type);
        List<Integer> interfaceStates = query.getResultList();
        return interfaceStates;
    }
    
	//根据服务名称，在数据库中查询对应的服务描述列表
    @SuppressWarnings("unchecked")
    public List<String> findDescribtion() {
        String queryString = "select describtion from Manager" ;
        Query query = getEntityManager().createQuery(queryString);
        List<String> i = query.getResultList();
        return i;
    }
	
	//找出目前数据库中所有的服务名称列表
	@SuppressWarnings("unchecked")
    public List<String> findService() {
        String queryString = "SELECT DISTINCT service FROM Manager" ;
        Query query = getEntityManager().createQuery(queryString);
        List<String> i = query.getResultList();
        return i;
    }
	
	//根据服务名称，找到该服务状态最新一次写入时间
	public Timestamp findLastTime(String type) {
        String queryString = "select max(lastRunTime) from TestResult where type=:type" ;
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("type", type);
        Timestamp i = (Timestamp) query.getResultList().get(0);
        return i;
    }
	
	//根据服务名称、对应接口、查看日志
	@SuppressWarnings("unchecked")
    public List<TestResult> getAllLogs(String type) {
        String queryString = "SELECT model FROM TestResult model where type =:type ORDER BY lastRunTime DESC " ;
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("type", type);
        List<TestResult> i = query.getResultList();
        return i;
    }
	//根据服务名称、对应接口、查看日志
    @SuppressWarnings("unchecked")
    public List<TestResult> getBadLogs(String type) {
        String queryString = "SELECT model FROM TestResult model where type =:type and state!=0 ORDER BY lastRunTime DESC " ;
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("type", type);
        List<TestResult> i = query.getResultList();
        return i;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}