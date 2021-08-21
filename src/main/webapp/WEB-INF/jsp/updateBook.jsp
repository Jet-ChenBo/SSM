<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加书籍</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row_clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改书籍</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <input type="hidden" name="bookID" value="${books.bookID}">
            <div class="form-group">
                <lable>书籍名称</lable>
                <input type="text" name="bookName" class="form-control" value="${books.bookName}" required>
            </div>
            <div class="form-group">
                <lable>书籍数量</lable>
                <input type="text" name="bookCounts" class="form-control" value="${books.bookCounts}" required>
            </div>
            <div class="form-group">
                <lable>书籍详情</lable>
                <input type="text" name="detail" class="form-control" value="${books.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</body>
</html>