package com.free4lab.freemonitor.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import com.free4lab.freemonitor.manager.TestResultManager;
import com.free4lab.freemonitor.model.dao.TestResult;
import com.free4lab.freemonitor.model.dao.TestResultDAO;
import com.free4lab.freemonitor.manager.Log;
public class LogManager {
    
    private List<Integer> interfacesStatus = new ArrayList<Integer>();
    private static final Logger logger = Logger.getLogger(LogManager.class);
    public void GetLogByDate(String type, Timestamp from, Timestamp to) throws Exception {
//        List<String> interfaces = new ArrayList<String>();
//        interfaces = new TestResultDAO().findInterface(type);
//        setInterfacesStatus(TestResultManager.getAllInterfaceStatus(type));
//        List<Log> logList = new ArrayList<Log>();
//        for(int i=0;i<interfaces.size();i++)
//        {
//            List<TestResult> list;
//            list= new TestResultDAO().getLogByDate(type,interfaces.get(i), from, to);
//            int badStateNum = 0;
//            Date date = new Date();
//            Timestamp currentTime = new Timestamp(date.getTime());
//            Log log = new Log("","","",currentTime,currentTime,0);
//            for(int j=0;j<list.size();j++)
//            {
//                if(list.get(j).getState() != 0)
//                {
//                    if( j != list.size()-1)
//                    {
//                        if(badStateNum == 0)
//                        {
//                            log.setTo(list.get(j).getLastRunTime());
//                            log.setType(type);
//                            log.setInter(list.get(j).getInterface());
//                            log.setFrom(list.get(j).getLastRunTime());
//                            log.setExceptMsg(list.get(j).getExceptionMsg());
//                            log.setState(list.get(j).getState());
//                            badStateNum ++;
//                        }
//                        else
//                        {
//                            log.setTo(list.get(j).getLastRunTime());
//                            badStateNum ++;
//                        }
//                    }
//                    else
//                    {
//                        if(badStateNum == 0)
//                        {
//                            log.setType(type);
//                            log.setInter(list.get(j).getInterface());
//                            log.setExceptMsg(list.get(j).getExceptionMsg());
//                            log.setFrom(list.get(j).getLastRunTime());
//                            log.setTo(currentTime);
//                            log.setState(list.get(j).getState());
//                        }
//                        else
//                        {
//                            log.setTo(currentTime);
//                        }
//                        logList.add(log);
//                        log = new Log();
//                        badStateNum = 0; 
//                    }
//                }
//                else
//                    if(badStateNum != 0)
//                    {
//                        log.setTo(list.get(j).getLastRunTime());
//                        logList.add(log);
//                        log = new Log();
//                        badStateNum = 0; 
//                    }
//            }
//        }
//        int size = logList.size();
//        for(int bubble1=1;bubble1<size;bubble1++)
//            for(int bubble2=size-1;bubble2>bubble1-1;bubble2--)
//            {
//                if(logList.get(bubble2).getFrom().compareTo(logList.get(bubble2-1).getFrom())<0)
//                {
//                    Log l = new Log(logList.get(bubble2));
//                    logList.get(bubble2).setExceptMsg(logList.get(bubble2-1).getExceptMsg());
//                    logList.get(bubble2).setFrom     (logList.get(bubble2-1).getFrom());
//                    logList.get(bubble2).setType     (logList.get(bubble2-1).getType());
//                    logList.get(bubble2).setInter    (logList.get(bubble2-1).getInter());
//                    logList.get(bubble2).setTo       (logList.get(bubble2-1).getTo());
//                    logList.get(bubble2).setState    (logList.get(bubble2-1).getState());
//                    
//                    logList.get(bubble2-1).setExceptMsg(l.getExceptMsg());
//                    logList.get(bubble2-1).setFrom(     l.getFrom());
//                    logList.get(bubble2-1).setType(     l.getType());
//                    logList.get(bubble2-1).setInter(    l.getInter());
//                    logList.get(bubble2-1).setTo(       l.getTo());
//                    logList.get(bubble2-1).setState(    l.getState());
//                }
//            }
//            
        //return logList;
    }

    public List<Integer> getInterfacesStatus() {
        return interfacesStatus;
    }
    public void setInterfacesStatus(List<Integer> interfacesStatus) {
        this.interfacesStatus = interfacesStatus;
    }
    
      public static void main(String[] args) throws Exception{
      List<Log> list;
      String tsStr1 = "2013-03-27 16:49:45";  
      String tsStr2 = "2013-04-02 13:49:45";  
      Timestamp from = Timestamp.valueOf(tsStr1);  
      Timestamp to = Timestamp.valueOf(tsStr2);  
      //list = new LogManager().GetLogByDate("freesearch",from,to);
      System.out.println("2013-04-02 13:49:45");
    }
}
