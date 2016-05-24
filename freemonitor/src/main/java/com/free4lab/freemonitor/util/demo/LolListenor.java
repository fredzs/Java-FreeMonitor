package com.free4lab.freemonitor.util.demo;

import org.apache.hadoop.hbase.util.Bytes;

import com.free4lab.freemonitor.util.LolClient;
import com.free4lab.freemonitor.util.OutputClient;
import com.free4lab.lol.client.TimeLineScanner;
import com.free4lab.lol.message.Message;

/**
 * @ClassName: LolListenor
 * @Description: 说明lol的使用方法
 * @author wenchaoz361
 * @date 2013-4-10 上午11:10:22
 */
public class LolListenor {
    TimeLineScanner scanner; 
    private long endTime;
    /**
    * <p>Title: </p>
    * <p>Description: </p>
    * @param topic
    * @param startTime
    */ 
    public LolListenor(String type, String interfaceName, long startTime, long endTime) {
        String topic = type + ":" + interfaceName;
        this.endTime = endTime;
        scanner = new TimeLineScanner(topic, startTime);
    }

    public Message nextMes() {
        Message ms = scanner.nextMessage();
        if(ms != null) {
            long nowTime = ms.getOffset();
            if(nowTime < endTime) {
                return ms;
            }
        }
        return null;
    }

    
    public static void main(String[] args) {
        String type = "freesearch";
        String interfaceName = "addDoc";
        
        //record 10 records, last for one second;
       /*OutputClient outputClient = LolClient.getInstance();
        
        long startTime = System.currentTimeMillis();
        
        for(int i = 0; i < 10; i++) {
            outputClient.recordData(type, interfaceName, 1, "nothing:just a test");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
            }
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println(startTime + ":" + endTime);
        System.out.println(type + ":" + interfaceName);
        */
        
        //demo:try to get mes
        LolListenor listenor = new LolListenor(type, interfaceName, 1365575149163l, 13655751491630l);
        Message m = listenor.nextMes();
        while(m != null) {
            String content = Bytes.toString(m.getContent());
            System.out.println(content);
            m = listenor.nextMes();
        } 
        
        System.out.println("ok.");
    }
}
