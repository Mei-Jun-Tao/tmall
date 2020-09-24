<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeate.jsp"%>

<script>
    $(function(){
        $(".addForm").submit(function(){
            if(!checkEmpty("name", "产品名称"))
                return false;
            if(!checkEmpty("subTitle", "小标题"))
                return false;
            if(!checkEmpty("orignalPrice", "原价"))
                return false;
            if(!checkEmpty("promotePrice", "促销价"))
                return false;
            if(!checkEmpty("stock", "库存"))
                return false;

            return true;
        })
    })
</script>

<body>
<div id="category">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">${c.name}</a></li>
        <li class="active">产品管理</li>
    </ol>

    <table class="table table-striped table-bordered table-hover  table-condensed">
        <tr>
            <th width="30px">ID</th>
            <th width="90px">产品图片</th>
            <th>产品名称</th>
            <th>小标题</th>
            <th>原价</th>
            <th>促销价</th>
            <th>库存</th>
            <th width="120px">产品图片管理</th>
            <th width="100px">属性值管理</th>
            <th width="50px">编辑</th>
            <th width="50px">删除</th>
        </tr>
        <c:forEach items="${ps}" var="p">
            <tr>
                <td>${p.id}</td>
                <td><img width="50px" height="40px" src="img/single/${p.productImage.id}.jpg"></td>
                <td>${p.name}</td>
                <td>${p.subTitle}</td>
                <td>${p.orignalPrice}</td>
                <td>${p.promotePrice}</td>
                <td>${p.stock}</td>
                <td><a href="admin_productImage_list?pid=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_propertyValue_list?pid=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_product_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="admin_product_delete?id=${p.id}" deleteLink="true"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="../include/admin/adminPage.jsp"%>

    <div class="panel panel-success">
        <div class="panel-heading">新增产品</div>
        <div class="panel-body">
            <form class="addForm" method="post" action="admin_product_add" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td width="100px">
                            <span>产品名称</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="name" id="name">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>小标题</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="subTitle" id="subTitle">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>原价</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="orignalPrice" id="orignalPrice">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>促销价</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="promotePrice" id="promotePrice">
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">
                            <span>库存</span>
                        </td>
                        <td>
                            <input type="text" class="txt" name="stock" id="stock">
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