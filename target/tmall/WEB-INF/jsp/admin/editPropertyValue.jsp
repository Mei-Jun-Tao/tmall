<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<body>
<div id="edit">

    <ol class="breadcrumb">
        <li><a href="admin_propertyValue_list?cid=${c.id}">${p.name}</a></li>
        <li class="active">编辑属性值</li>
    </ol>

    <div class="panel panel-success">
        <div class="panel-heading">编辑属性</div>
        <div class="panel-body">
            <form method="post" action="admin_propertyValue_update" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>属性值名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" value="${p.name}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="cid" value="${c.id}">
                            <input type="hidden" name="id" value="${p.id}">
                            <button type="submit">提交</button>v
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>