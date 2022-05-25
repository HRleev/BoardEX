<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2022-05-24
  Time: 오후 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<form action="/board/update" method="post" name="updateForm">
  <input type="text" name="id" value="${boardUpdate.id}" class="form-control" readonly>
  <input type="text" name="boardTitle" value="${boardUpdate.boardTitle}" class="form-control">
  <input type="text" name="boardPassword" id="passwordConfirm" class="form-control">
  <input type="text" name="boardWriter" value="${boardUpdate.boardWriter}" class="form-control" readonly>
  <input type="text" name="boardContents" value="${boardUpdate.boardContents}" class="form-control">
  <textarea name="boardContents" cols="30" rows="10">${boardUpdate.boardContents}</textarea>
  <input type="button" class="btn btn-danger" value="수정" onclick="boardUpdate()">
</form>
</body>
<script>
    const boardUpdate=()=>{
        const passwordConfirm=document.getElementById("passwordConfirm").value;
        const passwordDB='${boardUpdate.boardPassword}';
        console.log(passwordConfirm);
        console.log(typeof passwordConfirm);
        console.log(passwordDB);
        console.log(typeof passwordDB);

        if(passwordConfirm==passwordDB){
            updateForm.submit();
        }else{
            alert("워링워링");
        }
    }
</script>
</html>
