<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>图片上传和下载</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/uploadFile2" enctype="multipart/form-data">
        <input  type="file" name="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>