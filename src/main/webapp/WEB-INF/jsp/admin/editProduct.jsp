<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<body>
<div id="edit">

    <ol class="breadcrumb">
        <li><a href="admin_product_list?cid=${c.id}">${p.name}</a></li>
        <li class="active">编辑产品</li>
    </ol>

    <div class="panel panel-success">
        <div class="panel-heading">新增产品</div>
        <div class="panel-body">
            <form method="post" action="admin_product_update" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>产品名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" value="${p.name}" id="name">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>小标题</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="subTitle" value="${p.subTitle}" id="subTitle">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>原价</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="orignalPrice" value="${p.orignalPrice}" id="orignalPrice">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>促销价</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="promotePrice" value="${p.promotePrice}" id="promotePrice">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>库存</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="stock" value="${p.stock}" id="stock">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="id" value="${p.id}">
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