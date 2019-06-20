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
<body style="background-color: #202020">
<div id="wrapper">
    <jsp:include page="/header.jsp"></jsp:include>

    <!-- 此处编写内容  -->
    
   <div id="page-wrapper">
        <div id="page-inner">
			
				 <table class="table table-border">
				  	<thead>
					<tr>
                    <th>编号</th>
                    <th>分类编号</th>
                    <th>管理员</th>
                    <th>图书名称</th>
                    <th>创建日期</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
				</thead>
	<tbody>
		<c:forEach items="${pageInfo.list}" var="books">
			 <tr>
                       <td>${books.bid}</td>
                       <td>${books.iid}</td>
                       <td>${books.aid}</td>
                       <td>${books.name}</td>
                       <td>${books.credate}</td>
                       <td>
                      
                           <c:if test="${books.status ==1}">
                               上架
                           </c:if>
                           <c:if test="${books.status ==2}">
                               下架
                           </c:if>
                       </td> 
                       <td> <a href="${pageContext.request.contextPath }/deleteBook?bid=${books.bid}">删除</a></td>
                   </tr>
		</c:forEach>
	</tbody>
				</table>
				
		
		
			 <div class="row"   style=" color:#FFF">
		<div class="col-md-5 col-md-offset-8">
			
			当前是第【${pageInfo.pageNum }】页，一共有【${pageInfo.pages }】页，总记录数为【${pageInfo.total}】
		</div>
		<div class="col-md-6 col-md-offset-5">
			<nav aria-label="Page navigation">
  <ul class="pagination">
  <c:choose>
  	<c:when test="${pageInfo.pageNum==1 }">
  		<li class="disabled"><a >首页</a></li>
  	</c:when>
  	<c:otherwise>
  		<li><a href="${pageContext.request.contextPath }/showBooks">首页</a></li>
  	</c:otherwise>
  </c:choose>
 
  	<c:choose>
  		<c:when test="${pageInfo.pageNum==1 }">
  			 <li class="disabled">
      <a aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  		</c:when>
  		<c:otherwise>
  			<li>
      <a href="${pageContext.request.contextPath }/showBooks?pn=${pageInfo.prePage}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  		</c:otherwise>
  	</c:choose>
  
   
    <c:forEach items="${pageInfo.navigatepageNums }" var="i">
    <c:choose>
    	<c:when test="${pageInfo.pageNum==i }">
    		<li class="active"><a href="${pageContext.request.contextPath }/showBooks?pn=${i}">${i}</a></li>
    	</c:when>
    	<c:otherwise>
    		<li><a href="${pageContext.request.contextPath }/showBooks?pn=${i}">${i}</a></li>
    	</c:otherwise>
    	
    </c:choose>
    		
    </c:forEach>
    <c:choose>
  		<c:when test="${pageInfo.pageNum==pageInfo.pages }">
  			 <li class="disabled">
     <a aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  		</c:when>
  		<c:otherwise>
  			<li>
      <a href="${pageContext.request.contextPath }/showBooks?pn=${pageInfo.nextPage}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  		</c:otherwise>
  	</c:choose>
   
   
  <c:choose>
  	<c:when test="${pageInfo.pageNum==pageInfo.pages }">
  		<li class="disabled"><a >末页</a></li>
  	</c:when>
  	<c:otherwise>
  		<li><a href="${pageContext.request.contextPath }/showBooks?pn=${pageInfo.pages+1}">末页</a></li>
  	</c:otherwise>
  </c:choose>
    
    
  </ul>
</nav>
		</div>
	</div>
		
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
