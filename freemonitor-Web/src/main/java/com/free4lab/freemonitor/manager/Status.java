package com.free4lab.freemonitor.manager;

public class Status {
    private String type = null;
    private String state = null;
    private String describtion = null;
    public Status(){
    }
    public Status(String type, String state, String describtion){
        this.type = type;
        this.state = state;
        this.describtion = describtion;
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
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    public String getDescribtion() {
        return describtion;
    }
    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
    
    
    
}
