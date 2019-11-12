<%@ page language="java" import="com.po.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品修改页面</title>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
Shop oldsp=(Shop)session.getAttribute("oldsp");
%>
</head>
<body style="background-image:url(image/2.jpg);background-repeat:no-repeat;background-size:1600px 1024px;
background-position-x:50%">
<form action="update_Shop.do" enctype="multipart/form-data" method="post">
<table align="center" border="1px" width="450px" height="100px">
<tr>
<td colspan="2" align="center">修改商品信息</td>
</tr>
<tr align="center">
<td>商品名称</td>
<td>
<input type="text" name="sname" value="<%=oldsp.getSname()%>">
</td>
</tr>
<tr  align="center">
<td>商品单价</td>
<td>
<input type="text" name="price" value="<%=oldsp.getPrice()%>">
</td>
</tr>
<tr align="center">
<td>商品数量</td>
<td>
<input type="text" name="num" value="<%=oldsp.getNum()%>">
</td>
</tr>
<tr align="center">
<td>商品图片</td>
<td>
<a href="shop/<%=oldsp.getImgname()%>">
<img width="110" height="110" alt="" src="shop/<%=oldsp.getImgname()%>">
<input type="file" name="pic">
</a>
</td>
</tr>
<tr align="center">
<td>用户签名</td>
<td>
<input type="text" name="userid" value="<%=oldsp.getUserid()%>">
</td>
</tr>
<tr align="center">
<td colspan="2" align="center">
<input type="hidden" name="sid" value="<%=oldsp.getSid()%>">
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