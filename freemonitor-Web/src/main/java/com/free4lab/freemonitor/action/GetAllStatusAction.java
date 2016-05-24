package com.free4lab.freemonitor.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.free4lab.freemonitor.model.dao.TestResultDAO;
import com.free4lab.freemonitor.manager.Status;
import com.free4lab.freemonitor.manager.TestResultManager;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllStatusAction extends ActionSupport{
	
	/**
	 * 获取全部服务的工作状态
	 */
	private static final long serialVersionUID = 1597845248940902378L;
	private List<Integer> interfacesStatus = new ArrayList<Integer>();
	private List<Status> serviceStatus = new ArrayList<Status>();
	private List<String> services = new ArrayList<String>();
	private List<String> describtions = new ArrayList<String>();
	public String execute(){
	    services = new TestResultDAO().findService();
	    describtions = new TestResultDAO().findDescribtion();
	    Long currentTime = System.currentTimeMillis();
        Long l = 20 * 60 * 1000L;//设定监控者超时时间为20mins
        Timestamp rtime = new Timestamp(currentTime - l);
	    for(int i = 0;i < services.size();i++)
	    {
	        String status = services.get(i);
	        String describtion = describtions.get(i);
	        Status service = new Status();
	        Timestamp lastTime = new TestResultDAO().findLastTime(status);
	        if ( ( lastTime !=null) && ( lastTime.compareTo(rtime) > 0) )
	        {
            	interfacesStatus = new TestResultDAO().findInterfaceStatus(status);
            	service.setState(TestResultManager.getServiceStatus(interfacesStatus));
    	    }
    	    else
    	    {
	            service.setState("TimeOut");
	        }
	        
	        service.setType(status);
	        service.setDescribtion(describtion);
            serviceStatus.add( service );
	    }
		return SUCCESS;
	}

	
    public static void main(String[] args){
        GetAllStatusAction m = new GetAllStatusAction();
        System.out.println(m.execute());
    }


    /**
     * @return the interfacesStatus
     */
    public List<Integer> getInterfacesStatus() {
        return interfacesStatus;
    }


    /**
     * @param interfacesStatus the interfacesStatus to set
     */
    public void setInterfacesStatus(List<Integer> interfacesStatus) {
        this.interfacesStatus = interfacesStatus;
    }


    /**
     * @return the serviceStatus
     */
    public List<Status> getServiceStatus() {
        return serviceStatus;
    }


    /**
     * @param serviceStatus the serviceStatus to set
     */
    public void setServiceStatus(List<Status> serviceStatus) {
        this.serviceStatus = serviceStatus;
    }


    /**
     * @return the services
     */
    public List<String> getServices() {
        return services;
    }


    /**
     * @param services the services to set
     */
    public void setServices(List<String> services) {
        this.services = services;
    }



    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    /**
     * @return the describtions
     */
    public List<String> getDescribtions() {
        return describtions;
    }


    /**
     * @param describtions the describtions to set
     */
    public void setDescribtions(List<String> describtions) {
        this.describtions = describtions;
    }
    
    
}
