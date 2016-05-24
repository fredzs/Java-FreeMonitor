<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="left">
<!--table><tr>
	<td width="60px" class="topveralign padding5">
		<img src='http://freedisk.free4lab.com/download?uuid=<s:property value="#session.avatar" />' width="50" height="50" border="0">
	</td>
	<td width="80px" class="padding5 topveralign">
		<div class="midsize parseline"><s:property value="#session.userName" /></div>
		<div><a class="blueletter" href="_avatar.jsp" rel="facebox" title="修改头像"> 修改头像</a></div>
	</td>
</tr></table-->
<div>
	<img src='http://freedisk.free4lab.com/download?uuid=<s:property value="#session.avatar" />' width="100" height="100" border="0">
</div>
<div><a class="blueletter" href="user/changeavatar" rel="facebox" title="修改头像"> 修改头像</a></div>
<dl>
	<dt class='${ param.menu=="psw"?"selected":"" }'>
		<a href="psw.jsp"><img src="images/psw.png" /></a>
	</dt>
	<dt class='${ param.menu=="userinfo"?"selected":"" }'>
		<a href="user/userinfo"><img src="images/info.png" /></a>
	</dt>
	<dt class='${ param.menu=="groups"?"selected":"" }'>
		<a href="group/groups"><img src="images/priv.png" /></a>
	</dt>
	<dt class='${ param.menu=="billing"?"selected":"" }'>
		<a href="user/billing"><img src="images/bill.png" /></a>
	</dt>
</dl>
</div><!--left-->