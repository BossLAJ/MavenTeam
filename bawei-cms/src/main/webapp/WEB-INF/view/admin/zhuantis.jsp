<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="howsun">

    <title>CMS后台管理系统</title>

    <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
    <script type="text/javascript">
    function audit(id){
    	$.ajax({
            url :'/admin/auditArticle?id=' + id,
            dataType : 'json',
            type : 'post',
            success : function(data){
                if(data){
                	alert("审核成功");
                	window.location.reload();
                } else {
                	alert("审核失败");
                }
            }
        }); 
    }
    </script>
  </head>

  <body id="page-top">

	<!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>

    <div id="wrapper">

 		<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="/admin/">后台管理</a>
            </li>
            <li class="breadcrumb-item active">文章列表</li>
          </ol>

          <!-- Icon Cards-->
          <br/>
          <a href="/admin/zhuantis/add">添加</a>
          <br/>
                    <!-- 主体内容区 -->
			    <div class="container">
			        <div class="row">
			            <div class="col-md-9">
			                <div class="panel panel-default">
			                  <div class="panel-body">
			                        <table class="table table-striped table-bordered table-hover">
			                            <thead>
			                                <tr class="info">
			                              		<th>编号</th>
			                                    <th>名称</th>
			                                    <th>操作</th>
			                                </tr>
			                            </thead>
			                            <tbody class="">
			                            <c:forEach items="${list}" var="zhuanti">
			                                <tr>
			                                    <td>${zhuanti.id}</td>
			                                    <td>${zhuanti.name}</td>
			                                    <td>
			                                    	<a href="/admin/zhauntis/edit?id=${zhuanti.id }"><span class="glyphicon glyphicon-edit">修改</span></a>&nbsp;&nbsp;
			                                    	<a href="/admin/zhauntis/del?id=${zhuanti.id }"><span class="glyphicon glyphicon-edit">删除</span></a>&nbsp;&nbsp;
			                                    	<a href="/admin/zhuantis/addZhuantiArticle?id=${zhuanti.id}"><span class="glyphicon glyphicon-edit">添加文章</span></a>&nbsp;&nbsp;
			                                    </td>
			                                </tr>
			                            </c:forEach>
			                            </tbody>
			                        </table>
			                        ${page}
			                  </div>
			                </div>
			                
			            </div>
			        </div>
			    </div>
			     <!-- 主体内容区 -->
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright Â© Your Website 2019</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>
  </body>

</html>
