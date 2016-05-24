<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>自邮之翼-UserInfo</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
</head>
<body>
<div class="indexbg">
  <div id="inner">
    <!--logo-->
    <div class="errorbanner">
      <br />
      <br />
      <br />
      <h1 style="font-size: xx-large">404 ⊙﹏⊙! 真找不到相关资源哦！</h1>
      <br />
      <br />
      <br />      
      <p>返回应用，请点击<a class="greyletter" href="">这里</a></p>
    </div>    
  </div>
  <!--#inner-->
  <s:include value="/template/_footer.jsp" />
</div>
</body>
</html>
