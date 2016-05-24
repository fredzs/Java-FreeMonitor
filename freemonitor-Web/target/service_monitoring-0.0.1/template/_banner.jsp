<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pub_banner" sys="user" user="<s:property value="#session.email"/>" userid="<s:property value="#session.userIntId"/>" acctoken="<s:property value="#session.accessToken"/>"
		index="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>"
		handleurl="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login"%>">
</div>
<div class="banner">
    <a href=""><img id="logo" src="images/logo.png" border="0" /></a>
</div><!--banner-->