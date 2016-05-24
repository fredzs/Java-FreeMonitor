package com.free4lab.freemonitor.action;

import com.free4lab.freemonitor.model.dao.Manager;
import com.free4lab.freemonitor.model.dao.ManagerDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GetOldConfigAction extends ActionSupport{
	
	/**
	 * 获取reserve表中全部预订信息
	 */
	private static final long serialVersionUID = 1597845248940902378L;
	private int id;
	private String type;
	private String describtion;
	private Manager manager;
	public String execute(){
	    setManager(new ManagerDAO().findManager(type));
	    setId(getManager().getId());
	    setType(getManager().getService());
	    System.out.printf(getManager().getDescribtion());
	    setDescribtion(getManager().getDescribtion());
		return SUCCESS;
	}
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the manager
     */
    public Manager getManager() {
        return manager;
    }
    /**
     * @param manager the manager to set
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getDescribtion() {
        return describtion;
    }
    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
	

}
