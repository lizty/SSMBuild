<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <%--清除浮动--%>
    <div class="row clearfix">
        <%--分成12格--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--出现的问题：没有id，前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${QBooks.bookID}">
        <div class="form-group">
            <label>书名：</label>
            <input type="text" name="bookName" class="form-control" value="${QBooks.bookName}" placeholder="请输入书名" required>
        </div>
        <div class="form-group">
            <label>数量：</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBooks.bookCounts}" placeholder="请选择数量" required>
        </div>
        <div class="form-group">
            <label>简介：</label>
            <input type="text" name="detail" class="form-control" value="${QBooks.detail}" placeholder="请描述书籍内容" required>
        </div>

        <button type="submit" class="btn btn-default">修改</button>
    </form>
</body>
</html>
