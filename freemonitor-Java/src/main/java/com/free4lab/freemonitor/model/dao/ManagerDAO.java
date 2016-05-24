package com.free4lab.freemonitor.model.dao;

import java.util.List;
import javax.persistence.Query;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class ManagerDAO extends AbstractDAO<Manager>{
	public String getClassName() {
	    return getEntityClass().getName();
	}
	
	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return Manager.class;
	}

	public static final String PU_NAME = "RESULTPU";
	public String getPUName() {
		return PU_NAME;
	}

	public IEntityManagerHelper getEntityManagerHelper() {
		return new NoCacheEntityManagerHelper();
	}
	/*add other methods behind*/

	public boolean editManager(int id, String service, String describtion, String firstResponser, int firstWaiting, String secondResponser, int secondWaiting, String thirdResponser, int thirdWaiting){
		Manager Manager = new Manager(id, service, describtion, firstResponser, firstWaiting, secondResponser, secondWaiting, thirdResponser, thirdWaiting);
		update(Manager);	
		return true;
	}
	
	public Manager findManager(String service) {
		String queryString = "select model from " + getClassName()+ " model where model.service=:service";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("service", service);
		Manager i = (Manager) query.getResultList().get(0);
		return i;
	}
	
	@SuppressWarnings("unchecked")
    public int findFirstMinute(String service) {
        String queryString = "select model.firstWaiting from " + getClassName()+ " model where model.service=:service";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("service", service);
        List<Integer> i = query.getResultList();
        return i.get(0);
    }
	
	@SuppressWarnings("unchecked")
    public int findSecondMinute(String service) {
        String queryString = "select model.secondWaiting from " + getClassName()+ " model where model.service=:service";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("service", service);
        List<Integer> i = query.getResultList();
        return i.get(0);
    }
	
	@SuppressWarnings("unchecked")
    public int findThirdMinute(String service) {
        String queryString = "select model.thirdWaiting from " + getClassName()+ " model where model.service=:service";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("service", service);
        List<Integer> i = query.getResultList();
        return i.get(0);
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
	
	public List<Manager> findAll(){
    	return super.findAll();
    }
	
}