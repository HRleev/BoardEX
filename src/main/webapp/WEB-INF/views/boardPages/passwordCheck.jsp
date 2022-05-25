<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2022-05-24
  Time: 오후 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>passwordCheck</title>

</head>
<body>
<form action="/board/delete" method="post">
    <label for="passwordConfirm"></label>
    <input type="text" id="passwordConfirm"><br>
    <input type="button" onclick="passwordCheck()" value="확인">
</form>
</body>
<script>
    const passwordCheck=()=>{
        const passwordConfirm =document.getElementById("passwordConfirm").value;
        const passwordDB=${board.boardPassword};
        if(passwordConfirm==passwordDB){
            location.href="/board/delete?id=${board.id}";
        }else{
            alert("확인");
            location.href="/board/detail?id=${board.id}";
        }
    }
</script>
</html>
