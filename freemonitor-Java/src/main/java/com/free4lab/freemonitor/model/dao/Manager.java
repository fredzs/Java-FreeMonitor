package com.free4lab.freemonitor.model.dao;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TestResult database table.
 * 
 */
@Entity
@Table(name="Manager")
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",unique=true,nullable=false)
	private int id;
	private String service;
	private String describtion;
	private String firstResponser;
	private int firstWaiting;
	private String secondResponser;
    private int secondWaiting;
    private String thirdResponser;
    private int thirdWaiting;

	public Manager(int id, String service, String describtion, String firstResponser, int firstWaiting, String secondResponser, int secondWaiting, String thirdResponser, int thirdWaiting)
	{
	    this.id = id;
        this.service = service;
        this.describtion = describtion;
        this.firstResponser = firstResponser;
        this.firstWaiting = firstWaiting;
        this.secondResponser = secondResponser;
        this.secondWaiting = secondWaiting;
        this.thirdResponser = thirdResponser;
        this.thirdWaiting = thirdWaiting;
	}
	public Manager(){
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
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    
}