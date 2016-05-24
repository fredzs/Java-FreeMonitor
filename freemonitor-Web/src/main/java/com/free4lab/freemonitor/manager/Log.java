package com.free4lab.freemonitor.manager;

import java.sql.Timestamp;

public class Log {
    private String type = null;
    private String inter = null;
    private String exceptMsg = null;
    private Timestamp from = null;
    private Timestamp to = null;
    private int state;
    public Log(){
    }
    public Log(String type, String inter, String exceptMsg, Timestamp from, Timestamp to, int state){
        this.type = type;
        this.inter = inter;
        this.exceptMsg = exceptMsg;
        this.from = from;  
        this.to = to; 
        this.state = state;
    }
    
    public Log(Log log){
        this.type = log.type;
        this.inter = log.inter;
        this.exceptMsg = log.exceptMsg;
        this.from = log.from;  
        this.to = log.to; 
        this.state = log.state;
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
     * @return the inter
     */
    public String getInter() {
        return inter;
    }
    /**
     * @param inter the inter to set
     */
    public void setInter(String inter) {
        this.inter = inter;
    }
    /**
     * @return the exceptMsg
     */
    public String getExceptMsg() {
        return exceptMsg;
    }
    /**
     * @param exceptMsg the exceptMsg to set
     */
    public void setExceptMsg(String exceptMsg) {
        this.exceptMsg = exceptMsg;
    }
    /**
     * @return the from
     */
    public Timestamp getFrom() {
        return from;
    }
    /**
     * @param from the from to set
     */
    public void setFrom(Timestamp from) {
        this.from = from;  
    }
    /**
     * @return the to
     */
    public Timestamp getTo() {
        return to;
    }
    /**
     * @param to the to to set
     */
    public void setTo(Timestamp to) {
        this.to = to; 
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
    
}
