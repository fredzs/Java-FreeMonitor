/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.free4lab.freemonitor.manager;

import com.free4lab.utils.enabler.MailSend;
import com.free4lab.freemonitor.common.Constants;
public class SendMailJavaManager {
    private static String from = null;
    private static String passWd = null;
    private static String host = null;
    private static String mailTo = null;
    private static String mailCc = null;
    private static String title = null;
    private static String content = null;
    public void mailTo(String mailTo, String title, String content) throws Exception {
        /**
         * 邮件服务器配置信息
         */
        from = "paas_accounts@free4lab.com";
        passWd = "telestar";
        host = "smtp.exmail.qq.com";
        MailSend mailSend = new MailSend();
        mailSend.setMailFrom(from);
        mailSend.setPassword(passWd);
        mailSend.setMailTo(mailTo);
        mailSend.setHost(host);
        mailSend.setSubject(title);
        mailSend.setMsgContent(content);
        mailSend.send(false);
    }
}
