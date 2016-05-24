package com.free4lab.freemonitor.manager;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.free4lab.freemonitor.model.dao.ManagerDAO;
import com.free4lab.freemonitor.model.dao.TestResultDAO;


class MyThread implements Runnable {
    private static final int INTERVAL_TIME = 10;
    private static final int UNIT_TIME = 60000;
    private CountDownLatch downLatch;  
    private String type;  
    public MyThread()
    {
    }
    public MyThread(CountDownLatch downLatch, String type)
    {
        this.setDownLatch(downLatch);  
        this.type = type;  
    }
    public static String checkStatus(String type) {
        String state = null;
        Long currentTime = System.currentTimeMillis();
        Long l = 20 * 60 * 1000L;//设定监控者超时时间为20mins
        Timestamp rtime = new Timestamp(currentTime - l);
        Timestamp lastTime = new TestResultDAO().findLastTime(type);
        List<Integer> interfacesStatus = new ArrayList<Integer>();
        if ( ( lastTime !=null) && ( lastTime.compareTo(rtime) > 0) )
        {
            interfacesStatus = new TestResultDAO().findInterfaceStatus(type);
            state = TestResultManager.getServiceStatus(interfacesStatus);
        }
        else
        {
            state= "TimeOut";
        }
        Date date = new Date();
        Timestamp currentTime2 = new Timestamp(date.getTime());
        System.out.println("[" + type + "子线程]--" + "在" + currentTime2 + "的状态:" + state);
        return state;
    }
    
    public void run() 
    {
        int firstWaiting = 0;
        int secondWaiting = 0;
        int thirdWaiting = 0;
        new ConfigManager();
        String state;
        System.out.println("[" + type + "子线程]--" + "创建成功。");
//        while (true) 
//        {
//            try 
//            {
//                state = checkStatus(type);
//                if (state == "Error") 
//                {
//                    firstWaiting = new ManagerDAO().findFirstMinute(type);
//                    System.out.println("[" + type + "子线程]--" + "状态不正常，正在等待，" + firstWaiting + "分钟后获取" + type + "的工作状态。");
//                    Thread.sleep(firstWaiting * UNIT_TIME);
//                    if (checkStatus(type) == "Error") {
//                        new EmailManager().sendBadEmail(type,1);
//                        secondWaiting = new ManagerDAO().findSecondMinute(type);
//                        System.out.println("[" + type + "子线程]--" + "正在等待监控负责人修复，" + (secondWaiting - firstWaiting) + "分钟后再次获取" + type + "工作状态。");
//                        Thread.sleep((secondWaiting - firstWaiting) * UNIT_TIME);
//                        if (checkStatus(type) == "Error") {
//                            new EmailManager().sendBadEmail(type,2);
//                            thirdWaiting = new ManagerDAO().findThirdMinute(type);
//                            System.out.println("[" + type + "子线程]--" + "正在等待开发负责人修复，" + (thirdWaiting - secondWaiting) + "分钟后再次获取" + type + "工作状态。");
//                            Thread.sleep((thirdWaiting - secondWaiting) * UNIT_TIME);
//                            if (checkStatus(type) == "Error") {
//                                new EmailManager().sendBadEmail(type,3);
//                                System.out.println("[" + type + "子线程]--" + "正在等待项目负责人修复，" + (INTERVAL_TIME) + "分钟后再次获取" + type + "工作状态。");
//                                while (checkStatus(type) == "Error") {
//                                    Thread.sleep(INTERVAL_TIME * UNIT_TIME);
//                                }
//                                System.out.println("[" + type + "子线程]--" + "错误已在通知项目负责人后得到修复!");
//                                new EmailManager().sendGoodEmail(type,3);
//    
//                            } else {
//                                System.out.println("[" + type + "子线程]--" + "错误已在通知开发负责人后得到修复!");
//                                new EmailManager().sendGoodEmail(type,2);
//                            }
//                        } else {
//                            System.out.println("[" + type + "子线程]--" + "错误已在通知监控负责人后得到修复!");
//                            new EmailManager().sendGoodEmail(type,1);
//                        }
//                    }
//                }
//                else if(state == "TimeOut")
//                {
//                    System.out.println("[" + type + "子线程]--" + "较长时间没有新的工作状态写入，需要通知开发负责人。");
//                    new EmailManager().sendTimeoutEmail(type);
//                    System.out.println("----------------------------------------------------------------");
//                }
//                else 
//                {
//                    System.out.println("[" + type + "子线程]--" + "工作正常，进入下一个周期。");
//                    System.out.println("[" + type + "子线程]--" + "正在等待，" + INTERVAL_TIME + "分钟后获取" + type + "的工作状态。");
//                    System.out.println("----------------------------------------------------------------");
//                    Thread.sleep(INTERVAL_TIME * UNIT_TIME);
//                }
//            }
//            catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
        //System.out.println(Thread.currentThread().getName() + "正在卖票");
    }
    public CountDownLatch getDownLatch() {
        return downLatch;
    }
    public void setDownLatch(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }
}
public class ConfigManager {
    public static String checkStatus(String type) {
        String state = null;
        Long currentTime = System.currentTimeMillis();
        Long l = 20 * 60 * 1000L;//设定监控者超时时间为20mins
        Timestamp rtime = new Timestamp(currentTime - l);
        Timestamp lastTime = new TestResultDAO().findLastTime(type);
        List<Integer> interfacesStatus = new ArrayList<Integer>();
        if ( ( lastTime !=null) && ( lastTime.compareTo(rtime) > 0) )
        {
            interfacesStatus = new TestResultDAO().findInterfaceStatus(type);
            state = TestResultManager.getServiceStatus(interfacesStatus);
        }
        else
        {
            state= "TimeOut";
        }
        Date date = new Date();
        Timestamp currentTime2 = new Timestamp(date.getTime());
        System.out.println("[" + type + "子线程]--" + "在" + currentTime2 + "的状态:" + state);
        return state;
    }

    public static void main(String[] args) throws Exception {
        
        List<String> services = new ArrayList<String>();
        System.out.println("[主线程]--"+"监控程序初始化成功！");
//        services = new TestResultDAO().findType();
//        System.out.println("[主线程]--"+"得到所有被监控的服务列表：" + services);
//        final int UNIT_TIME = 60000;
//        
//        CountDownLatch latch = new CountDownLatch(services.size());  
//        int wait = 0;
//        for (String service : services) 
//        {
//            System.out.println("[主线程]--"+"等待" + wait + "分钟后" + "启动" + service+ "的监控线程。");
//            Thread.sleep(wait * UNIT_TIME);
//            MyThread monitor = new MyThread(latch,service);
//            new Thread(monitor,service).start();
//            wait ++;
//            System.out.println("[主线程]--" + "成功启动" + service+ "的监控线程。");
//        }
//        
//        latch.await();
//        System.out.println("[主线程]--"+"所有子线程都结束，程序退出。");
    }

}
