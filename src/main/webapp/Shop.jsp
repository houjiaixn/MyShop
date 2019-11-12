<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ include file="inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${pb.pagelist==null}">
	<c:redirect url="findAllPage_Shop.do"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商铺首页</title>
<script>
//更改每页记录数的函数
function docbangeRows(){
	var rows=document.form1.rows.value;
	if(isNaN(rows)){
	alter('输入正确数字！');
	document.form1.rows.value=${pb.rows};
	return;
	}
	window.location="findAllPage_Shop.do?rows="+rows;
}
//跳转页数的函数
function docbangePage(){
	var page=document.form1.page.value;
	if(isNaN(page)){
	alter('输入正确数字！');
	document.form1.page.value=${pb.page};
	return;
	}
	window.location="findAllPage_Shop.do?page="+page;
}
</script>
</head>
<body
	style="background-image: url(image/2.jpg); background-repeat: no-repeat; background-size: 1600px 1024px; background-position-x: 50%;margin-top:10%">
	<h1 align="center">商品展示</h1>
	<form action="" id="form1" name="form1" method="post">
		<table align="center" border="1px" width="650px" height="100px">
			<tr>
				<td colspan="9" align="center">商品展示</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>品名</td>
				<td>价格</td>
				<td>数量</td>
				<td>小计</td>
				<td>图片预览</td>
				<td>用户id</td>
				<td>用户账号</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pb.pagelist}" var="sp">
				<tr>
					<td>${sp.sid}</td>
					<td>${sp.sname}</td>
					<td>${sp.price}</td>
					<td>${sp.num}</td>
					<td>${sp.acount}</td>
					<td><a href="shop/${sp.imgname}"> <img width="110"
							height="110" alt="" src="shop/${sp.imgname}">
					</a></td>
					<td>${sp.userid}</td>
					<td>${sp.uname}</td>
					<td><a href="delById_Shop.do?sid=${sp.sid}">删除</a> <a
						href="findById_Shop.do?sid=${sp.sid}">修改</a></td>
				</tr>
			</c:forEach>

			<tr align="center" bgcolor="#FFFF99">
				<td><c:if test="${pb.page>1}">
						<a href="findAllPage_Shop.do?page=1">
					</c:if> 首页</a></td>
				<td><c:if test="${pb.page>1}">
						<a href="findAllPage_Shop.do?page=${pb.page-1}">
					</c:if> 上一页</a></td>
				<td><c:if test="${pb.page<pb.maxpage}">
						<a href="findAllPage_Shop.do?page=${pb.page+1}">
					</c:if> 下一页</a></td>
				<td><c:if test="${pb.page<pb.maxpage}">
						<a href="findAllPage_Shop.do?page=${pb.maxpage}">
					</c:if> 末页</a></td>
				<td colspan="2">跳转到 <input type="text" id="page" name="page"
					size="2" value="${pb.page}" /> 页 <input type="button"
					name="button" id="button" value="确定" onclick="docbangePage()" />
				</td>
				<td colspan="2">每页 <input type="text" id="rows" name="rows"
					size="2" value="${pb.rows}" /> 记录 <input type="button"
					name="button2" id="button2" value="确定" onclick="docbangeRows()" />
				</td>
				<td>${pb.page}/${pb.maxpage}</td>
			</tr>
		</table>
	</form>
	<div class="w" align="center">
		<div id="footer-2013">
		<input rel="nofollow" type="button" style="color: #FFFF66"
				onclick="location.href='add.jsp'" value="返回添加">
		 | 
			<input rel="nofollow" type="button" style="color: #FFFF66"
				onclick="location.href='login.jsp'" value=" 返回首页">
		</div>
		<div class="copyright"
			style="position: absolute; bottom: 0; width: 100%; height: 100px;">
			Copyright&nbsp;&copy;&nbsp;2004-2019&nbsp;&nbsp;昔瞳&nbsp;版权所有</div>
	</div>
	</div>
</body>
<%
	Object message = session.getAttribute("success");
	if (message != null && !"".equals(message)) {
%>
<script type="text/javascript">
          alert("<%=message%>
	");
</script>
<%
	session.invalidate();
	}
%>
</html>