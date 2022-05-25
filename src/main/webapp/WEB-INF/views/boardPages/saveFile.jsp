<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2022-05-25
  Time: 오후 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>saveFile.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <div class="py-5 text-center">
        <form action="/board/saveFile" method="post" enctype="multipart/form-data">
            <input class="form-control mb-2" type="text" name="boardTitle" placeholder="제목">
            <input class="form-control mb-2" type="text" name="boardWriter" placeholder="작성자">
            <input class="form-control mb-2" type="text" name="boardPassword" placeholder="비밀번호">
            <textarea class="form-control mb-2" name="boardContents"  cols="10" rows="5"></textarea>
            <input class="btn btn-primary" type="submit" value="글작성">
        </form>
    </div>
</div>

</body>
</html>
