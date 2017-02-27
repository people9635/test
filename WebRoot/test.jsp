<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	
  </head>
  
  <body>
	<div>
        <textarea name="text" id="text"  rows="3" cols="20"></textarea>
		<input type="submit" value="send" onclick="start()" />
	</div>
	<div id="messages"></div>
	<script type="text/javascript">
		var name ='tom'
		var webSocket = 
			new WebSocket('ws://localhost:8080/tccp/websocket/'+name);

		webSocket.onerror = function(event) {
			onError(event)
		};

		webSocket.onopen = function(event) {
			onOpen(event)
		};

		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		function onMessage(event) {
			document.getElementById('messages').innerHTML 
				+= '<br />' + event.data;
		}

		function onOpen(event) {
			document.getElementById('messages').innerHTML 
				= 'Connection established';
		}

		function onError(event) {
			alert(event.data);
		}

		function start() {
            var text =document.getElementById('text').value;
			webSocket.send(text);
			return false;
		}
		</script>
	</body>
</html>
