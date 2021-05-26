<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘月胜
  Date: 2021/5/24
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改书籍信息</title>
</head>
<body>
<center>
<h1>修改书籍信息</h1>
    <form action="/book/updateBook" method="post"enctype="multipart/form-data">
        <input type="hidden" name="id" value="${book.id}">
      <table width="500" border="1" cellpadding="0" height="200" align="center">
    <tr>
    <td>书名：<input type="text" name="bookname" value="${book.bookname}"></td>
    </tr>
          <tr>
              <td>书名：<input type="text" name="author" value="${book.author}"></td>
          </tr>
          <tr>
              <td>书名：<input type="text" name="price" value="${book.price}"></td>
          </tr>
    <tr>
        <td>类名:</td>
        <td>
            <select name="classid">

           <option value="">-请选择-</option>
            <c:forEach items="${classifyList}" var="classify">
                 <option value="${classify.id}" ${classify.id==book.classid?"selected":""}> ${classify.name}</option>
            </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>简介：<input type="text" name="descr" value="${book.descr}"></td>
    </tr>
    <tr>
        <td>
            <input type="hidden" name="path" value="${book.path}">
            <c:if test="${!empty book.path}">
                <img src="http://localhost:8080/upload/${book.path}" alt="封面" width="50" height="50">
            </c:if>
            修改封面：<input type="file" name="photo"></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="修改">
        </td>
    </tr>
</table>
    </form>
</center>
</body>
</html>
