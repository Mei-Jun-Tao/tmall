<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<body>
<div id="category">
    <table class="table table-striped table-bordered table-hover  table-condensed">
        <tr>
            <th width="30px">ID</th>
            <th>用户名称</th>
            <th>用户密码</th>
        </tr>
        <c:forEach items="${us}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="../include/admin/adminPage.jsp"%>
</div>
</body>