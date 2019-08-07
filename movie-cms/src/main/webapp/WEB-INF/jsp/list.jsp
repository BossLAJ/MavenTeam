<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
	<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="page-header" style="text-align: center;"><h1>电影添加</h1></div>	
			</div>
			<div class="row">
				<div>
					<a href="toaddMovie.do">添加电影</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<form action="addMovie">
							<table class="table table-condensed table-bordered table-hover text-center" style="width:900px;margin: 0 auto;">
								<tr>
									<td>电影作者</td>
									<td>电影价格</td>	
									<td>电影时长</td>	
									<td>电影时间</td>	
									<td>电影类型</td>
									<td>电影年份</td>
									<td>电影国家</td>
									<td>电影状态</td>
									<td>操作</td>
								</tr>	
							<c:forEach items="${movie }" var="movie">
								<tr>
									<td>${movie.mauthor }</td>
									<td>${movie.mprice }</td>
									<td>${movie.mtime }</td>
									<td>${movie.mdate }</td>
									<td>${movie.mtype }</td>
									<td>${movie.myear }</td>
									<td>${movie.mcountry }</td>
									<td>
										<c:if test="${movie.mstatus==1 }">正在热映</c:if>
										<c:if test="${movie.mstatus==2 }">即将下架</c:if>
										<c:if test="${movie.mstatus==3 }">准备上映</c:if>
									</td>
									
								</tr>
							</c:forEach>		
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>