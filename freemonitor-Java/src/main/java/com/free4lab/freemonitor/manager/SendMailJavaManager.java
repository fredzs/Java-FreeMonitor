/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.free4lab.freemonitor.manager;

import com.free4lab.utils.enabler.MailSend;
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
    /**
     * @return the from
     */
    public static String getFrom() {
        return from;
    }
    /**
     * @param from the from to set
     */
    public static void setFrom(String from) {
        SendMailJavaManager.from = from;
    }
    /**
     * @return the passWd
     */
    public static String getPassWd() {
        return passWd;
    }
    /**
     * @param passWd the passWd to set
     */
    public static void setPassWd(String passWd) {
        SendMailJavaManager.passWd = passWd;
    }
    /**
     * @return the host
     */
    public static String getHost() {
        return host;
    }
    /**
     * @param host the host to set
     */
    public static void setHost(String host) {
        SendMailJavaManager.host = host;
    }
    /**
     * @return the mailTo
     */
    public static String getMailTo() {
        return mailTo;
    }
    /**
     * @param mailTo the mailTo to set
     */
    public static void setMailTo(String mailTo) {
        SendMailJavaManager.mailTo = mailTo;
    }
    /**
     * @return the mailCc
     */
    public static String getMailCc() {
        return mailCc;
    }
    /**
     * @param mailCc the mailCc to set
     */
    public static void setMailCc(String mailCc) {
        SendMailJavaManager.mailCc = mailCc;
    }
    /**
     * @return the title
     */
    public static String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public static void setTitle(String title) {
        SendMailJavaManager.title = title;
    }
    /**
     * @return the content
     */
    public static String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public static void setContent(String content) {
        SendMailJavaManager.content = content;
    }
    
}
