package com.free4lab.freemonitor.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.free4lab.freemonitor.model.dao.ManagerDAO;

public class EmailManager {
	
	public void sendGoodEmail(String type, int num) 
	{
	    Map<String,String> map=new HashMap<String,String>();
	    SendMailJavaManager mail = new SendMailJavaManager();
        String mailTitle = type+"服务已恢复正常。";
        String str = null;
	    if (num == 1) 
	    {
	        String first = new ManagerDAO().findManager(type).getFirstResponser();
	        map = new EmailManager().getNameEmailFromResponser(first);
	        str = "监控";
        } 
	    else if (num == 2)
	    {
	        String second = new ManagerDAO().findManager(type).getSecondResponser();
            map = new EmailManager().getNameEmailFromResponser(second);
            str = "开发";
        }
	    else 
	    {
	        String third = new ManagerDAO().findManager(type).getThirdResponser();
            map = new EmailManager().getNameEmailFromResponser(third);
            str = "项目";
        }

	    try 
	    {
	        Set<String> set = new HashSet<String>();
	        set= map.keySet();
	        for(String s:set)
	        {
	            String mailContent = s + " 您好，经过" + str + "负责人的及时处理，"+ type +"服务目前已恢复正常，请登录云海管理员门户的服务状态监控页面查看详细日志。";
	            String mailTo = map.get(s);
	            mail.mailTo(mailTo, mailTitle, mailContent);
	        }
	        System.out.println("[" + type + "子线程]--邮件模块--" + "向" + str + "负责人发送成功!");
        }
        catch (Exception e) {
            System.out.println("[" + type + "子线程]--邮件模块--" + "向" + str + "负责人发送失败!请检查邮箱配置。");
        }
	    
    }
    public void sendBadEmail(String type, int num)
    {
        Map<String,String> map=new HashMap<String,String>();
        SendMailJavaManager mail = new SendMailJavaManager();
        String mailTitle = type+"服务工作不正常，请检查。";
        String str = null;
        if (num == 1) 
        {
            String first = new ManagerDAO().findManager(type).getFirstResponser();
            map = new EmailManager().getNameEmailFromResponser(first);
            str = "监控";
        } 
        else if (num == 2)
        {
            String second = new ManagerDAO().findManager(type).getSecondResponser();
            map = new EmailManager().getNameEmailFromResponser(second);
            str = "开发";
        }
        else 
        {
            String third = new ManagerDAO().findManager(type).getThirdResponser();
            map = new EmailManager().getNameEmailFromResponser(third);
            str = "项目";
        }

        try 
        {
            Set<String> set = new HashSet<String>();
            set= map.keySet();
            for(String s:set)
            {
                String mailContent = s + " 您好，根据云海服务状态监控模块的报告，"+ type +"服务目前的工作状态不正常，请登录云海管理员门户的服务状态监控页面查看详细日志，以便及时解决问题。";
                String mailTo = map.get(s);
                mail.mailTo(mailTo, mailTitle, mailContent);
            }
            System.out.println("[" + type + "子线程]--邮件模块--" + "向" + str + "负责人发送成功!");
        }
        catch (Exception e) {
            System.out.println("[" + type + "子线程]--邮件模块--" + "向" + str + "负责人发送失败!请检查邮箱配置。");
            e.printStackTrace();
        }
        
    }
    public void sendTimeoutEmail(String type)
    {
        Map<String,String> map=new HashMap<String,String>();
        SendMailJavaManager mail = new SendMailJavaManager();
        String mailTitle = type+"服务工作不正常，请检查。";
        String second = new ManagerDAO().findManager(type).getSecondResponser();
        map = new EmailManager().getNameEmailFromResponser(second);
        try 
        {
            Set<String> set = new HashSet<String>();
            set= map.keySet();
            for(String s:set)
            {
                String mailContent = s + " 您好，根据云海服务状态监控模块的报告，"+ type +"服务已经超过20分钟没有最新状态汇报，请及时检查服务的测试模块工作情况。";
                String mailTo = map.get(s);
                mail.mailTo(mailTo, mailTitle, mailContent);
            }
            System.out.println("[" + type + "子线程]--邮件模块--" + "向开发负责人发送成功!");
        }
        catch (Exception e) {
            System.out.println("[" + type + "子线程]--邮件模块--" + "向开发负责人发送失败!请检查邮箱配置。");
        }
    }
	public Map<String,String> getNameEmailFromResponser(String responser) 
    {
	    
	    String[] ss=responser.split(",");
        Map<String,String> map=new HashMap<String,String>();
        for(String s:ss)
        {
            int i=s.indexOf('<');
            String name=s.substring(0,i);
            String email=s.substring(i+1,s.length()-1);
            map.put(name, email);
        }
        return map;
    }

	public static void main(String[] args) 
	{  
    	String str = "张晟<fred_zs@163.com>,郑文超<fred_zs@163.com>,徐鹏<fred_zs@163.com>";
    	Map<String,String> map=new HashMap<String,String>();
    	map = new EmailManager().getNameEmailFromResponser(str);
    	Set<String> set = new HashSet<String>();
    	set= map.keySet();
    	for(String s:set)
    	{
    	    System.out.println(map.get(s));  
    	}
    	System.out.println(map);  
        new EmailManager().sendBadEmail("freesearch",3);

	}
}
