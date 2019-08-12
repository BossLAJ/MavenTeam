<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="page-header" style="text-align: center;"><h1>链接展示</h1></div>	
			</div>	
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
							<table class="table table-condensed table-bordered table-hover text-center" style="width:1000px;margin: 0 auto;">
								<tr>
									<td>
										<a href="addlink.do"><input type="button" class="btn btn-success" value="添加链接"></a>
									</td>
								</tr>
								<tr>
									<td>
										<form action="search.do" method="post">
											<input type="text" name="name" value="${name }">
											<input type="submit" class="btn btn-success" name="搜索">
										</form>										
									</td>
								</tr>
							</table>
							<table class="table table-condensed table-bordered table-hover text-center" style="width:1000px;margin: 0 auto;">
								<tr>
									<td>id</td>
									<td>链接介绍</td>
									<td>链接地址</td>
									<td>创建时间</td>
									<td>权重</td>
									
									<td>操作</td>
								</tr>
							<c:forEach items="${link }" var="links">
								<tr>
									<td>${links.substr }</td>
									<td>${links.name }</td>
									<td>${links.link }</td>
									<td>${links.create }</td>
									<td>${links.score }</td>
									
									<td>
										<a href="updateDown.do?id=${links.id }"><input type="button" class="btn btn-warning" value="下移"> </a>
										<a href="updateUp.do?id=${links.id }"><input type="button" class="btn btn-info" value="上移"> </a>
										<a href="delete.do?id=${links.id }"><input type="button" class="btn btn-danger" value="删除"> </a>
									</td>
								</tr>
							</c:forEach>
							</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>