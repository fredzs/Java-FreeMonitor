<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日志</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
<script src="http://front.free4lab.com/js/public.js"></script>

</head>
<body>
	 <div id="container">
	 <s:include value="/template/_banner.jsp" />
		<div id="inner">
			<div class="content">
				<div class="divline" style="margin-top:30px;margin-bottom:10px">
					<p>服务详情</p>
				</div>
				<div class="contentline">
					<table class="datatable">
					<tr>
						<td width="30">序号</td>
						<td width="80">服务名称</td>
						<td width="100">接口</td>
						<td>附加信息</td>
						<td width="120">监控时间</td>
						<td width="250">工作状态</td>
					</tr>	
					<s:iterator value="allLogList" id="list" status="log">
						<tr>
							<td><s:property value="#log.count" /></td>
							<td><s:property value="#list.type" /></td>
							<td><s:property value="#list.interface" /></td>
							<td><s:property value="#list.exceptionMsg" /></td>
                            <td><s:property value="#list.lastRunTime" /></td>
							<td><s:property value="#list.state"/></td>
						</tr>
					</s:iterator>
					</table>
				</div>
			</div>
			
		</div>
		<s:include value="/template/_footer.jsp" />
	</div>

</body>
</html>