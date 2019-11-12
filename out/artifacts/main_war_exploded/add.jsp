<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="inc.jsp" %>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="sp" class="com.po.Shop" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="sp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品添加</title>
</head>
<body style="background-image:url(image/2.jpg);background-repeat:no-repeat;background-size:1600px 1024px;
background-position-x:50%">
<h1 align="center">欢迎使用超市管理系统</h1>
<form name="form" action="save_Shop.do" enctype="multipart/form-data" method="post">
<table align="center" border="1px" width="470px" height="100px">
<tr style="color:#faa755">
<td colspan="3" align="center">商品添加</td>
</tr>
<tr style="color:#faa755">
<td>商品名称</td>
<td>
<input type="text" name="sname">
</td>
<td width="140" rowspan="6"><img src="shop/default.jpg" width="138" height="142" /></td>
</tr>
<tr style="color:#faa755">
<td>商品单价</td>
<td>
<input type="text" name="price">
</td>
</tr>
<tr style="color:#faa755">
<td>商品数量</td>
<td>
<input type="text" name="num">
</td>
</tr>
<tr style="color:#faa755">
<td>商品图片</td>
<td><label for="pic"></label>
<input type="file" name = "pic" id="pic" >
</td>
</tr>
<tr style="color:#faa755">
<td>用户签名</td>
<td>
<input type="text" name = "userid">
</td>
</tr>
<tr  style="color:#faa755">
<td colspan="2" align="center">
<input type="submit" value="添加">
</td>
</tr>
</table>
</form>
<div class="w" align="center">
    <div id="footer-2013">
        <div class="links">
        <input rel="nofollow" type="button" style="color:#f26522"  onclick="location.href='findAllPage_Shop.do'" value="查看列表">
<!--            <a rel="nofollow" target="_blank" href="findAllPage_Shop.do">
                查看列表
            </a> -->
        </div>
        <div class="copyright" style="position:absolute;bottom:0;width:100%;height:100px;">
            Copyright&nbsp;&copy;&nbsp;2004-2019&nbsp;&nbsp;昔瞳&nbsp;版权所有
        </div>
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