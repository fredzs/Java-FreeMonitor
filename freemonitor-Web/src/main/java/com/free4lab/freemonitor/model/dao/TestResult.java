package com.free4lab.freemonitor.model.dao;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the TestResult database table.
 * 
 */
@Entity
@Table(name="TestResult")
public class TestResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",unique=true,nullable=false)
	private int id;
	@Column(name = "type")
	private String type;
	@Column(name = "interface")
	private String interfaceTested;
	private String exceptionMsg;
	private Timestamp lastRunTime;
	private int state;
	
	public TestResult()
	{}

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
     * @return the interfaceTested
     */
    public String getInterface() {
        return interfaceTested;
    }

    /**
     * @param interfaceTested the interfaceTested to set
     */
    public void setInterface(String interfaceTested) {
        this.interfaceTested = interfaceTested;
    }

    /**
     * @return the exceptionMsg
     */
    public String getExceptionMsg() {
        return exceptionMsg;
    }

    /**
     * @param exceptionMsg the exceptionMsg to set
     */
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    /**
     * @return the lastRunTime
     */
    public Timestamp getLastRunTime() {
        return lastRunTime;
    }

    /**
     * @param lastRunTime the lastRunTime to set
     */
    public void setLastRunTime(Timestamp lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


	

}