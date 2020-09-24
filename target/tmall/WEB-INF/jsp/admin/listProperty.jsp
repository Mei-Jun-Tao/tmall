<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<script>
    $(function(){
        $(".addForm").submit(function(){
            if(!checkEmpty("name", "属性名称"))
                return false;

            return true;
        })
    })
</script>

<body>
<div id="category">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">${c.name}</a></li>
        <li class="active">属性管理</li>
    </ol>

    <table class="table table-striped table-bordered table-hover  table-condensed">
        <tr>
            <th width="30px">ID</th>
            <th>属性名称</th>
            <th width="50px">编辑</th>
            <th width="50px">删除</th>
        </tr>
        <c:forEach items="${ps}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td><a href="admin_property_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_property_delete?id=${p.id}" deleteLink="true"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="../include/admin/adminPage.jsp"%>

    <div class="panel panel-success">
        <div class="panel-heading">新增属性</div>
        <div class="panel-body">
            <form class="addForm" method="post" action="admin_property_add" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>属性名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" id="name">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="cid" value="${c.id}">
                            <button type="submit">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>