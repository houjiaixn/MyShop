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
<title>新密码</title>
</head>
<body style="background-image:url(image/2.jpg);background-repeat:no-repeat;background-size:1600px 1024px;
background-position-x:50%">
<form method="post" action="updata_Shop.do">
<table align="center" border="1px" width="380px" height="10px">
<tr>
<td colspan="2" align="center">新账号密码
</td>
</tr>
<tr>
<td>账号</td>
<td>
<input type="text" name="uname">
</td>
</tr>
<tr>
<td>新密码</td>
<td>
<input type="text" name="upassword1">
</td>
</tr>
<tr>
<td>请再输入一次新密码</td>
<td>
<input type="text" name="upassword2">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="修改">
</td>
</tr>
</table>
</form>
        <div align="center" class="copyright" style="position:absolute;bottom:0;width:100%;height:100px;">
            Copyright&nbsp;&copy;&nbsp;2004-2019&nbsp;&nbsp;昔瞳&nbsp;版权所有
        </div>
</body>
</html>