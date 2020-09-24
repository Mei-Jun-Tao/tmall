<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<body>
<div id="edit">

    <ol class="breadcrumb">
        <li><a href="admin_category_list">${c.name}</a></li>
        <li class="active">编辑分类</li>
    </ol>

    <div class="panel panel-success">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <form method="post" action="admin_category_update" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>分类名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" value="${c.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>分类图片</span>
                        </td>
                        <td>
                            <input type="file" accept="image/*" class="file" name="image">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="id" value="${c.id}">
                            <button type="submit">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>