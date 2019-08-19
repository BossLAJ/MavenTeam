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
				<div class="page-header" style="text-align: center;"><h1>修改</h1></div>	
			</div>	
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<form action="updateUser.do" method="post">
							<table class="table table-condensed table-bordered table-hover text-center" style="width:900px;margin: 0 auto;">
								<tr>
									<td>
										名称:<input type="text"  value="${userlist.name }">
									</td>
								</tr>			
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>