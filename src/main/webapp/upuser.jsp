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
<title>修改账户</title>
</head>
<body style="background-image:url(image/2.jpg);background-repeat:no-repeat;background-size:1600px 1024px;
background-position-x:50%;margin-top:10%">
<form method="post" action="findByUn_Shop.do">
<table align="center" border="1px" width="260px" height="10px">
<tr>
<td colspan="2" align="center">账号修改
</td>
</tr>
<tr>
<td>账号</td>
<td>
<input type="text" name="uname">
</td>
</tr>
<tr>
<td>密码</td>
<td>
<input type="text" name="upassword">
</td>
</tr>
<tr>
<td>密保问题</td>
<td>
<input type="text" name="queshion">
</td>
</tr>
<tr>
<td>密保答案</td>
<td>
<input type="text" name="answer">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" style="color:#f26522" value="修改密码">
</td>
</tr>
</table>
</form>
<div class="w" align="center">
    <div id="footer-2013">
        <div class="links">
		<input rel="nofollow" type="button" style="color: #FFFF66"
				onclick="location.href='register.jsp'" value="返回注册">
				            |
		<input rel="nofollow" type="button" style="color: #FFFF66"
				onclick="location.href='login.jsp'" value="返回登录">
        </div>
        <div class="copyright" style="position:absolute;bottom:0;width:100%;height:100px;">
            Copyright&nbsp;&copy;&nbsp;2004-2019&nbsp;&nbsp;昔瞳&nbsp;版权所有
        </div>
                </div>
    </div>
</body>
</html>