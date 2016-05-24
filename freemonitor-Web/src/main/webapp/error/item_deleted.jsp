<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自邮之翼-UserInfo</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
</head>

<body onload=jump()>
<div id="container">
  <s:include value="/template/_banner.jsp"></s:include>
  <div id="inner">
  <s:include value="/template/_left.jsp" />
    <div class="right">
      <!-- <div class="divline"> 当前位置： <span><a href="javascript:void(0)">我的团队</a></span> - <span><a href="javascript:void(0)">前端开发组</a></span> - <span>jQuery用户手册（英文版）[PDF]</span> </div> -->
      <!--divline-->
      <div class="contentline">
        <img src="css/images/notificationbk_tran.png" style="float:right"/>
        <h1> <img src="css/images/resource.png" border="0" />此资源不存在或已经被删除了！ </h1>
        <div class="introdution">
          <p></p>
          <p>返回应用，请点击 <a class="greyletter"  id="url" href="">这里</a> </p>
        </div>
       
      </div>
      <!--contentline--> 
    </div>
    <!--right--> 
  </div>
    <s:include value="/template/_footer.jsp" />
  <!--#inner-->
   <script type="text/javascript">
$(document).ready(function(){
    selected('#item1');
    $('.choose').css({'padding-left':'370px'});
});
/*
function jump(){
    setInterval(function(){
        var second = $("#second").html();
        if (second == 0){
            this.location = $("#url").attr("href");
        }else{
            $("#second").html(second-1);
        }
    }, 1000);
}*/
</script> 
</div>
<!--#container-->
</body>
</html>