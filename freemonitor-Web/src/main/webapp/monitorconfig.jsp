<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监控配置</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
<script src="http://front.free4lab.com/js/public.js"></script>

</head>
<body>
     <table >
     	 <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td width="150" valign="top">
            	<div align="right" style="margin-top:10px;">监控负责人：</div>
            </td>
            <td width="400">
            	<textarea id="firstResponser" class="editbox" style="width:400px"><s:property value="manager.firstResponser" /></textarea>
            </td>
         </tr>
         <tr>
         	<td width="120">
            		
            </td>
            <td width="50">
         		服务故障
            	<input id="firstWaiting" style="width:50px" type="text" value="<s:property value="manager.firstWaiting" />" class="editline" />
         		分钟后发送邮件 
         	</td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td width="120" valign="top">
            	<div align="right" style="margin-top:10px;">开发负责人：</div>
            </td>
            <td width="400">
            	<textarea id="secondResponser" class="editbox" style="width:400px"><s:property value="manager.secondResponser" /></textarea>
            </td>
         </tr>
         <tr>
         	<td width="120">
            		
            </td>
            <td width="50">
         		服务故障
            	<input id="secondWaiting" style="width:50px" type="text" value="<s:property value="manager.secondWaiting" />" class="editline" />
         		分钟后发送邮件
         	</td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td width="120" valign="top">
            	<div align="right" style="margin-top:10px;">项目负责人：</div>
            </td>
            <td width="400">
            	<textarea id="thirdResponser" class="editbox" style="width:400px"><s:property value="manager.thirdResponser" /></textarea>
            </td>
         </tr>
         <tr>
         	<td width="120">
            		
            </td>
            <td width="50">
         		服务故障
            	<input id="thirdWaiting" style="width:50px" type="text" value="<s:property value="manager.thirdWaiting" />" class="editline" />
         		分钟后发送邮件
         	</td>
         </tr>
         
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
         	<td width="120">
            		
            </td>
            <td width="80">
            	监控时间间隔：<input readonly id="1" style="width:50px" type="text" value="10" class="editline" />分钟
            </td>
         	<td width="80">
            </td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td><div>&nbsp;</div></td>
         </tr>
         <tr>
            <td><div><input id="des" class="hidden" type="text" value="<s:property value="describtion"/>" class="editline" /></div></td>
         </tr>
         <tr>
            <td><div align="left"></div></td>
            <td><div align="left"></div></td>
            <td>
              <input type="button" class="button" value="保存" onClick="submit()" />
            </td>
            <td><div align="left"></div></td>
            <td>
           	  <input type="button" class="button" value="取消" onClick="cancle()" />
            </td>
         </tr>
     </table>
</body>

<script>

function submit( ) 
{
	var reg = new RegExp("^[0-9]*$");
    var min1 = document.getElementById("firstWaiting");
    var min2 = document.getElementById("secondWaiting");
    var min3 = document.getElementById("thirdWaiting");
	if (($('#firstResponser').val()!="")&&($('#secondResponser').val()!="")&&($('#thirdResponser').val()!=""))
	{
		if (($('#firstWaiting').val()!="")&&($('#secondWaiting').val()!="")&&($('#thirdWaiting').val()!=""))
		{
			if((reg.test(min1.value))&&(reg.test(min2.value))&&(reg.test(min3.value)))
			{
				$.ajax
				({
					url : 'editconfig',
					type : 'post',
					data : 
					{
						id : "<s:property value="id"/>",
						
						firstResponser : $('#firstResponser').val(),
						secondResponser : $('#secondResponser').val(),
						thirdResponser : $('#thirdResponser').val(),
						
						firstWaiting : $('#firstWaiting').val(),
						secondWaiting : $('#secondWaiting').val(),
						thirdWaiting : $('#thirdWaiting').val(),
						
						service : "<s:property value="type"/>",
						describtion : $('#des').val(),
					},
					success : function(data) 
					{
						if (data.good == 1)
						{
							$(document).trigger('close.facebox');
							alert("配置成功！");
						}
						else
							alert("配置失败，请稍后重试！");
					}
				});
			}
			else
				alert("输入的时间必须为数字！");
			
		}
		else
			alert("时间不能为空！");
	}
	else
		alert("姓名不能为空！");
}
function cancle()
{
	$(document).trigger('close.facebox');
}
</script>
</html>