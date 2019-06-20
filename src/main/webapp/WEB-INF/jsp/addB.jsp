<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>优乐图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />


	
</head>
<body>
<div id="wrapper">
    <jsp:include page="/header.jsp"></jsp:include>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                <div  id="add_admin">
                    <h1 class="h1">增加图书操作</h1>
                    </div>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
                <form action="${pageContext.request.contextPath }/addBook" method="get" class="form-horizontal" id="insertForm">
                    <%--图书名称--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">图书名称</label>
                        <div class="col-md-6">
                            <input type="text" name="name" id="name" class="form-control input-sm">
                        </div>
                    </div>

                      
                            <%--aid--%>
                            <div class="form-group">
                                <label for="aid" class="col-md-3 control-label">管理员ID</label>
                                <div class="col-md-6">
                                     <select class="form-control"id="aid" name="aid">
                                       <c:forEach items="${admins}" var="admin">
                                           <option value="${admin.aid}">${admin.aid}</option>
                                       </c:forEach>
                                    </select>
                                </div>
                            </div>
                       

                       
                            <%--aid--%>
                            <div class="form-group">
                                <label for="iid" class="col-md-3 control-label">分类名称</label>
                                <div class="col-md-6">
                                    <select class="form-control"id="iid" name="iid">
                                        <c:forEach items="${items}" var="item">
                                            <option value="${item.iid}">${item.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                      

                        <!--内容简介-->
                        <div class="form-group">
                            <label for="note" class="col-md-3 control-label">内容简介</label>
                            <div class="col-md-6">
                                <textarea name="note" id="note" class="form-control"></textarea>
                            </div>
                        </div>



                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</div>


<jsp:include page="/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>

<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
</body>
</html>
