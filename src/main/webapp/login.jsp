<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body
	style="background-image: url(image/2.jpg); background-repeat: no-repeat; background-size: 1600px 1024px; background-position-x: 50%;margin-top:10%">
	<h1 align="center">欢迎使用超市管理系统</h1>
	<form method="post" action="UfindById_Shop.do">
		<table align="center" border="1px" width="230px" height="10px">
			<tr>
				<td colspan="4" align="center">账号登录</td>
			</tr>
			<tr>
				<td colspan="2">账号</td>
				<td colspan="2"><input type="text" name="uname"></td>
			</tr>
			<tr style="color: #faa755">
				<td colspan="2">密码</td>
				<td colspan="2"><input type="password" name="upassword">
				</td>
			</tr>
			<tr style="color: #faa755">
				<td colspan="4" align="center"><input type="submit"
					style="color: #FFFF66" value="登录"></td>
			</tr>
		</table>
	</form>
	<div class="w" align="center">
		<div id="footer-2013">
			<div class="links">
				<input rel="nofollow" type="button" style="color: #FFFF66"
					onclick="location.href='register.jsp'" value="返回注册"> | <input
					rel="nofollow" type="button" style="color: #FFFF66"
					onclick="location.href='deluser.jsp'" value="注销账户"> | <input
					rel="nofollow" type="button" style="color: #FFFF66"
					onclick="location.href='upuser.jsp'" value="修改密码">
			</div>
			<div class="copyright"
				style="position: absolute; bottom: 0; width: 100%; height: 100px;">
				Copyright&nbsp;&copy;&nbsp;2004-2019&nbsp;&nbsp;昔瞳&nbsp;版权所有</div>
		</div>
	</div>
</body>
<%
     Object message = session.getAttribute("success");
     if(message!=null && !"".equals(message)){
 
  %>
<script type="text/javascript">
          alert("<%=message%>");
      </script>
<%
  session.invalidate();
     } %>
</html>