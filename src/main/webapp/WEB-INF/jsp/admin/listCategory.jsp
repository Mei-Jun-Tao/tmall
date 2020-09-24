<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<script>
    $(function(){
        $(".addForm").submit(function(){
            if(!checkEmpty("name", "分类名称"))
                return false;
            if(!checkEmpty("file", "分类图片"))
                return false;

            return true;
        })
    })
</script>

<body>
<div id="category">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li class="active">分类管理</li>
    </ol>

    <table class="table table-striped table-bordered table-hover  table-condensed">
        <tr>
            <th width="30px">ID</th>
            <th width="90px">分类图片</th>
            <th>分类名称</th>
            <th width="90px">产品管理</th>
            <th width="90px">属性管理</th>
            <th width="50px">编辑</th>
            <th width="50px">删除</th>
        </tr>
        <c:forEach items="${cs}" var="c">
            <tr>
                <td>${c.id}</td>
                <td><img width="50px" height="40px" src="img/category/${c.id}.jpg"></td>
                <td>${c.name}</td>
                <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_category_delete?id=${c.id}" deleteLink="true"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="../include/admin/adminPage.jsp"%>

    <div class="panel panel-success">
        <div class="panel-heading">新增分类</div>
        <div class="panel-body">
            <form class="addForm" method="post" action="admin_category_add" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>分类名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" id="name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>分类图片</span>
                        </td>
                        <td>
                            <input type="file" accept="image/*" class="file" name="image" id="file">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>