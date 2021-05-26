<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>卡尔书架</title>
</head>
<body background="../image/a.jpg">
<div style="background-color: skyblue" align="center">


<form id="queryForm" action="/book/findAll">
    <h1>卡尔书架</h1>
    <input type="button" onclick="toAddView()" value="添加书籍">&nbsp;
    <input type="button" onclick="delAll()" value="批量删除"><br><br>

    <%--多条件查询之 条件 --%>
    书名：<input type="text" name="queryBookName" value="${queryVO.queryBookName}"> &nbsp;&nbsp;
    作者：<input type="text" name="queryAuthorName" value="${queryVO.queryAuthorName}"> &nbsp;&nbsp;
    类别：<select name="queryClassifyId">
    <option value="">请选择</option>
    <c:forEach items="${classifyList}" var="classify">
        <option value="${classify.id}"  ${classify.id==queryVO.queryClassifyId?"selected":""}  >${classify.name}</option>
    </c:forEach>
</select>
    <%--当前页码--%>
    <input type="hidden" name="pageNum" id="pageNum">
    <input type="submit" value="查询"><br><br>
</form>

<form id="showAll" action="/book/delAllIds">
    <%--展示书籍信息--%>
    <table width="680" border="1" cellspacing="0">
        <tr height="54">
            <th>
                <input type="checkbox" name="allNodes" id="allNodes" onclick="selectAll(this)" >
                <label for="allNodes">全选/反选</label>
                <%--<label><input type="checkbox" name="allNodes" id="allNodes" onclick="selectAll(this)" >quanxuan</label>--%>

            </th>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>描述</th>
            <th>图片</th>
            <th>类别</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="book">
            <tr height="52" align="center">
                <td>
                    <input type="checkbox" name="id" value="${book.id}" id="zi" onclick="fanxuan()" >
                </td>

                <td>${book.id}</td>
                <td>${book.bookname}</td>
                <td width="60">${book.author}</td>
                <td>${book.price}</td>
                <td>${book.descr}</td>
                <td>
                    <c:if test="${empty book.path}">
                        <img src="http://localhost:8080/upload/1.jpg" alt="这是头像" width="50" height="50">
                    </c:if>
                    <c:if test="${!empty book.path}">
                        <img src="http://localhost:8080/upload/${book.path}" alt="这是头像" width="50" height="50">
                    </c:if>

                </td >
                <td width="100">${book.classifyName}</td>
                <td width="80">
                    <a href="/book/toupdateBookView?id=${book.id}">修改</a>&nbsp;
                    <a href="/book/delAllIds?id=${book.id}">删除</a>&nbsp;
            </tr>
        </c:forEach>

    </table>

</form>
第 ${pageInfo.pageNum} 页
<a href="javascript:void(0)" onclick="byPage(1)">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="byPage(${pageInfo.pageNum-1})">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="byPage(${pageInfo.pageNum+1})">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="byPage(${pageInfo.pages})">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
共 ${pageInfo.pages} 页
</center>
</div>
<script src="/js/jquery-1.8.3.js"></script>
<script>
    function toAddView(){
        location.href="/book/toaddBookView";//定位资源
    }
    function byPage(num){
        $("#pageNum").val(num);//为隐藏域赋值
        $("#queryForm").submit();
    }
    function  delAll() {
        $("#showAll").submit();
    }
    function selectAll(obj) {
        // alert(obj.checked);//true/false
        $("input[name=id]").prop("checked",obj.checked);// 子选项由总的选修的选中情况决定
    }
    function fanxuan() {
        var ziList=$("input[name=id]");
        var f=true;//每一个子选项都是被选中的
        for(var i=0;i<ziList.length;i++){
            if(!ziList[i].checked ){
                f=false;
            }
        }
        $("#allNodes").prop("checked",f);
    }

</script>


</body>

</html>
