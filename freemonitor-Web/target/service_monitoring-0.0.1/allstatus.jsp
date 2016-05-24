<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当前各服务状态</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
<style type="text/css">
	.bigfont{ background: #ff80c0;}
</style>
</head>
<body>
	 <div id="container">
	 <s:include value="/template/_banner.jsp" />
		<div id="inner">
			<div class="content">
				<div class="divline" style="margin-left:100px;margin-top:30px;margin-bottom:10px">
					<p>服务状态监控</p>
				</div>
				<div class="contentline">
					<table class="datatable" style="width:80%">
					<tr>
						<td width="80">当前状态</td>
						<td>服务名称</td>
						<td>服务描述</td>
						<td width="50">操作</td>
						<td width="50"></td>
					</tr>	
					
					<s:iterator value="serviceStatus" id="list" status="status">
						<tr>
							<s:if test="#list.state=='Normal'">
								<td><img src="images/status0.gif"></td>
							</s:if>
							<s:elseif test="#list.state=='Warning'">
								<td><img src="images/status1.gif"></td>
							</s:elseif>
							<s:elseif test="#list.state=='TimeOut'">
								<td><img src="images/status2.gif"></td>
							</s:elseif>
							<s:else>
								<td><img src="images/status3.gif"></td>
							</s:else>
							<td><s:property value="#list.type" /></td>
							<td><s:property value="#list.describtion" /></td>
							<td><a href="logs?type=<s:property value="#list.type" />" title="监控日志" target="_balnk">日志</a></td>
							<td><a href="oldconfig?type=<s:property value="#list.type" />" rel="facebox" title="监控配置">配置</a></td>
						</tr>
					</s:iterator>
					</table>
					<div class="divline" style="margin-left:100px;margin-top:30px;margin-bottom:10px">
						<p>图例</p>
					</div>
					<table class="datatable" style="width:80%;">
						<tbody>
							<tr>
							<td width="80">状态</td>
							<td>说明</td>
							<td></td>
							</tr>
							<tr>
							<td width="20"><img src="images/status0.gif"></td>
							<td>服务的全部接口工作正常</td>
							<td></td>
							</tr>
							<tr>
							<td width="20"><img src="images/status1.gif"></td>
							<td>服务的一个或多个接口提示警告</td>
							<td></td>
							</tr>
							<tr>
							<td width="20"><img src="images/status2.gif"></td>
							<td>在规定时间内没有收到服务最新的监控信息,或该服务没有状态监控记录</td>
							<td></td>
							</tr>
							<tr>
							<td width="20"><img src="images/status3.gif"></td>
							<td>服务的一个或多个接口工作不正常</td>
							<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<s:include value="/template/_footer.jsp" />
	</div>

   

<script src="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"js/public.js"%>"></script>
</body>
</html>