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
				<div class="page-header" style="text-align: center;"><h1>列表</h1></div>	
			</div>	
			<div class="row">
				<div class="col-md-12">
					<form action="search.do" method="post">
					<table class="table table-condensed table-bordered table-hover text-center" style="width:900px;margin: 0 auto;">
						<tr>
							<td>
								名称:<input type="text" name="name" value="${name }">
									<input class="btn btn-info" type="submit" value="搜索">
							</td>
						</tr>
					</table>
					</form>
					<div class="table-responsive">
						<form action="">
							<table class="table table-condensed table-bordered table-hover text-center" style="width:900px;margin: 0 auto;">
								<tr>
									<td>编号</td>
									<td>名称</td>
									<td>地址</td>
									<td>专业</td>
									<td>操作</td>
								</tr>
							<c:forEach items="${list }" var="user">
								<tr>
									<td>${user.id }</td>
									<td>${user.name }</td>
									<td>${user.addr }</td>
									<td>${user.pname }</td>
									<td>
										<a href="delete.do?id=${user.id }"><input type="button" value="删除" class="btn btn-success"> </a>
										<a href="update.do?id=${user.id }"><input type="button" value="修改" class="btn btn-danger"> </a>
									</td>
								</tr>
							</c:forEach>
							<div class="col-md-6">
								<table class="table table-condensed table-bordered table-hover text-center" style="width:900px;margin: 0 auto;">
									<tr>
										<td>
											<input class="btn btn-warning" type="button" value="首页"><a href="list.do/${plist.firstPage }"></a>
											<input class="btn btn-warning" type="button" value="上一页"><a href="list.do/${plist.prePage }"></a>
											<input class="btn btn-warning" type="button" value="下一页"><a href="list.do/${plist.nextPage }"></a>
											<input class="btn btn-warning" type="button" value="尾页"><a href="list.do/${plist.lastPage }"></a>
										</td>
										
									</tr>
								</table>
							</div>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>