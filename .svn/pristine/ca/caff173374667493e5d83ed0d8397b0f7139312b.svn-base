<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form >
		UserId：<input type="text" id="userId"/><br/>
		<input type="button" value="查找" id="sender"> 
	</form>
	<div id="messageDiv"></div>
	
	<script>
	$('#sender').click(function(){
		var id=document.getElementById('userId').value;
		var url="SearchUserById";
		
		$.post(url, JSON.stringify(user), function(data) {
			  console.log(data);
             var json=JSON.parse(data);
             alert(json);
         });
	});
	</script>
</body>
</html>