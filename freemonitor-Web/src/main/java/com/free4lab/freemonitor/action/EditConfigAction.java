package com.free4lab.freemonitor.action;

import com.free4lab.freemonitor.account.BaseAction;
import com.free4lab.freemonitor.model.dao.ManagerDAO;

public class EditConfigAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private int id;
	private String service;
	private String describtion;
    
    private String firstResponser;
    private int firstWaiting;
    private String secondResponser;
    private int secondWaiting;
    private String thirdResponser;
    private int thirdWaiting;
    
    private int good = 0;

	public String execute() {
		boolean good1= new ManagerDAO().editManager(id, service, describtion, firstResponser, firstWaiting, secondResponser, secondWaiting, thirdResponser, thirdWaiting);
		if (good1)
		    setGood(1);
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
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the describtion
     */
    public String getDescribtion() {
        return describtion;
    }

    /**
     * @param describtion the describtion to set
     */
    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    /**
     * @return the firstResponser
     */
    public String getFirstResponser() {
        return firstResponser;
    }

    /**
     * @param firstResponser the firstResponser to set
     */
    public void setFirstResponser(String firstResponser) {
        this.firstResponser = firstResponser;
    }

    /**
     * @return the firstWaiting
     */
    public int getFirstWaiting() {
        return firstWaiting;
    }

    /**
     * @param firstWaiting the firstWaiting to set
     */
    public void setFirstWaiting(int firstWaiting) {
        this.firstWaiting = firstWaiting;
    }

    /**
     * @return the secondResponser
     */
    public String getSecondResponser() {
        return secondResponser;
    }

    /**
     * @param secondResponser the secondResponser to set
     */
    public void setSecondResponser(String secondResponser) {
        this.secondResponser = secondResponser;
    }

    /**
     * @return the secondWaiting
     */
    public int getSecondWaiting() {
        return secondWaiting;
    }

    /**
     * @param secondWaiting the secondWaiting to set
     */
    public void setSecondWaiting(int secondWaiting) {
        this.secondWaiting = secondWaiting;
    }

    /**
     * @return the thirdResponser
     */
    public String getThirdResponser() {
        return thirdResponser;
    }

    /**
     * @param thirdResponser the thirdResponser to set
     */
    public void setThirdResponser(String thirdResponser) {
        this.thirdResponser = thirdResponser;
    }

    /**
     * @return the thirdWaiting
     */
    public int getThirdWaiting() {
        return thirdWaiting;
    }

    /**
     * @param thirdWaiting the thirdWaiting to set
     */
    public void setThirdWaiting(int thirdWaiting) {
        this.thirdWaiting = thirdWaiting;
    }

    /**
     * @return the good
     */
    public int getGood() {
        return good;
    }

    /**
     * @param good the good to set
     */
    public void setGood(int good) {
        this.good = good;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	
}
