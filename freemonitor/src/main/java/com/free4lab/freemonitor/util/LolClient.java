package com.free4lab.freemonitor.util;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.free4lab.lol.client.Messenger;
import com.free4lab.lol.message.Message;
import com.free4lab.lol.message.MessageFactory;

/**
 * @ClassName: LolClient
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-4-9 下午8:48:00
 */
public class LolClient implements OutputClient {
    private long offset;
    private Messenger messager = new Messenger();
    private static Logger logger = Logger.getLogger(LolClient.class);
    private static LolClient instance = new LolClient();
    
    private LolClient() {};
    
    static public LolClient getInstance() {
        return instance;
    }

    /* 
    * <p>Title: updateData</p>
    * <p>Description: </p>
    * @param type
    * @param interfaceName
    * @param state
    * @param exceptionMsg
    * @see com.free4lab.freemonitor.util.OutputClient#updateData(java.lang.String, java.lang.String, int, java.lang.String)
    */ 
    public void recordData(String type, String interfaceName, int state, String exceptionMsg) {
        
        try {
            byte[] contentBytes = getContentBytes(state, exceptionMsg);
            long offset = getOffset();
            String topic = type + ":" + interfaceName;
            Message m = MessageFactory.getInstance().createMessage(topic, contentBytes, "monitor", offset);
            messager.send(m);
        }
        catch (JSONException e) {
            logger.error(e.getMessage());
        }

        
    }
    
    byte[] getContentBytes(int state, String exceptionMsg) throws JSONException {
        
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("state", state);
        if(exceptionMsg != null) {
            jsonobj.put("exception", exceptionMsg);
        }
        
        return jsonobj.toString().getBytes();
    }
    
    synchronized long getOffset() {
        long time = System.currentTimeMillis();
        if(time <= offset) {
            time = offset;
            time ++;
        }
        
        offset = time;
        
        return offset;
    }


}
