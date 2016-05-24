<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href='fullcalendar/fullcalendar/fullcalendar.css' rel='stylesheet' />
<link href='fullcalendar/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='fullcalendar/jquery/jquery-1.9.1.min.js'></script>
<script src='fullcalendar/jquery/jquery-ui-1.10.2.custom.min.js'></script>
<script src='fullcalendar/fullcalendar/fullcalendar.js'></script>
<script>

	$(document).ready(function() {
		alert();
		$.ajax
		({
			url : 'logshow',
			type : 'post',
			data : 
			{
				type : "<s:property value="firstId"/>",
			},
			success : function(data) 
			{
				alert (data.from);
				var date = new Date();
				var d = date.getDate();
				var m = date.getMonth();
				var y = date.getFullYear();
				
				var s = data.type+data.inter+data.exceptMsg;
				alert (data.type);
				var c = {title: s,start: new Date(y, m, 5)};
				var e = [
							{
								title: 'FreeSearch-getDoc-warning',
								start: new Date(y, m, 1),
								end: new Date(y, m, 2)
							},
							{
								title: 'FreeSearch-addDoc-warning',
								start: new Date(y, m, 1),
								end: new Date(y, m, 3)
							},
							{
								id: 999,
								title: 'FreeSearch-delDoc-warning',
								start: new Date(y, m-1, 29, 16, 0),
								end: new Date(y, m, 3),
								allDay: false
							},
							
						];
				e.push(c);
				var calendar = $('#calendar').fullCalendar({
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
					monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
					dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],  
					dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],  
					today: ["今天"],  
					buttonText: {today: '今天',month: '月', week: '周',  day: '日' },  
					slotMinutes: 20,
					
					selectable: true,
					selectHelper: true,
					select: function(start, end, allDay) {
						var title = prompt('Event Title:');
						if (title) {
							calendar.fullCalendar('renderEvent',
								{
									title: title,
									start: start,
									end: end,
									allDay: allDay
								},
								true // make the event "stick"
							);
						}
						calendar.fullCalendar('unselect');
					},
					editable: true,
					events : e
				});
			}
		});
		
		
		
		
	});
	
	

</script>
<style>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}

	#calendar {
		width: 900px;
		margin: 0 auto;
		}

</style>
</head>
<body>
<div id='calendar'></div>
</body>
</html>
