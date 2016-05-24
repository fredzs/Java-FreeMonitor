package com.free4lab.freemonitor.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.free4lab.freemonitor.action.GetOldConfigAction;
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
    public List<Integer> findMinute(String service) {
        String queryString = "select model.minute from " + getClassName()+ " model where model.service=:service";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("service", service);
        List<Integer> i = query.getResultList();
        return i;
    }
	
	@SuppressWarnings("unchecked")
    public List<String> findEmail(String service) {
        String queryString = "select model.email from " + getClassName()+ " model where model.service=:service";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("service", service);
        List<String> i = query.getResultList();
        return i;
    }
	
	public List<Manager> findAll(){
    	return super.findAll();
    }
	
//	public static void main(String[] args) throws Exception{
//        List<Manager> managerList;
//        new GetOldConfigAction();
//        managerList= new ManagerDAO().findManager("freesearch");
//        System.out.println(managerList);
//    }
}