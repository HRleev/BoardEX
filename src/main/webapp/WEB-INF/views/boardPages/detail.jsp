<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2022-05-24
  Time: 오후 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail.jsp</title>
</head>
<body>
글번호: ${board.id} <br>
제목: ${board.boardTitle} <br>
작성자: ${board.boardWriter} <br>
비밀번호: ${board.boardPassword} <br>
내용: ${board.boardContents} <br>
작성일자: ${board.boardCreatedDate} <br>
조회수: ${board.boardHits} <br>
<button onclick="boardUpdate()">수정</button>
<button onclick="boardDelete()">삭제</button>
<button onclick="findAll()">목록</button>
</body>
<script>
    const boardUpdate=()=>{
        location.href="/board/update?id=${board.id}";
    }
    const boardDelete=()=>{
        location.href="/board/passwordCheck?id=${board.id}";
    }
    const findAll=()=>{
        location.href="/board/findAll";
    }
</script>
</html>
