<%@ page language="java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel ="stylesheet" href="css/bootstrap.css">
    <title>재고 추가하기</title>
</head>
<body>
    <form action="/object" method="post" data-="json">
        <div>
            <input type="text" class="form-control" placeholder="재고 이름" name="name" maxlength="30">
        </div>
        <div>
            <input type="text" class="form-control" placeholder="카테고리" name="category" maxlength="30">
        </div>
        <div>
            <input type="text" class="form-control" placeholder="개수" name="ea" maxlength="30">
        </div>

        <input type="submit" class="btn btn-primary form-control" value="등록하기">
        <script src = "https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </form>
</body>
</html>