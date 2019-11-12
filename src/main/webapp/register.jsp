<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="inc.jsp" %>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body style="background-image:url(image/2.jpg);background-repeat:no-repeat;background-size:1600px 1024px;
background-position-x:50%;margin-top:10%">
<h1 align="center">欢迎使用超市管理系统</h1>
<form method="post" action="usave_Shop.do">
<table align="center" border="1px" width="260px" height="10px">
<tr>
<td colspan="4" align="center">账号注册
</td>
</tr>
<tr style="color:#faa755" >
<td colspan="2">账号</td>
<td colspan="2">
<input type="text" name="uname">
</td>
</tr>
<tr style="color:#faa755">
<td colspan="2">密码</td>
<td colspan="2">
<input type="password" name="upassword">
</td>
</tr>
<tr style="color:#faa755">
<td colspan="2">密保问题</td>
<td colspan="2">
<input type="text" name="queshion">
</td>
</tr>
<tr style="color:#faa755">
<td colspan="2">密保答案</td>
<td colspan="2">
<input type="text" name="answer">
</td>
</tr>
<tr style="color:#faa755">
<td colspan="4" align="center">
<input type="submit" style="color:#f47920" value="注册">
</td>
</table>
</form>
	<div class="w" align="center">
		<div class="links">
		<input rel="nofollow" type="button" style="color:#FFFF66" onclick="location.href='login.jsp'" value="登录">
			| 
			<input rel="nofollow" type="button" style="color:#faa755" onclick="location.href='deluser.jsp'" value="注销账户">
				| 
				<input rel="nofollow" type="button" style="color:#f26522"  onclick="location.href='upuser.jsp'" value="修改密码">
		</div>
		<div class="copyright" style="position:absolute;bottom:0;width:100%;height:100px;">
			Copyright&nbsp;&copy;&nbsp;2019-2020&nbsp;&nbsp;昔瞳&nbsp;版权所有</div>
	</div>
</body>
     <%
     Object message = session.getAttribute("message");
     if(message!=null && !"".equals(message)){
  %>
      <script type="text/javascript">
          alert("<%=message%>");
      </script>
  <%
  session.invalidate();
     } %>
</html>