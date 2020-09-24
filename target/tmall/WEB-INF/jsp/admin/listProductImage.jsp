<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<head>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <style>
        body{
            background-color: rgb(244, 244, 244);
        }
        div.productImage{
            padding: 0px 150px;
        }
        div.single{
            width: 440px;
            float: left;
        }
        div.details{
            width: 440px;
            float: right;
        }
        div.panel{
            width: 440px;
            margin: 50px auto;
        }
        table.table tr:nth-of-type(1){
            background-color: rgb(3, 174, 132);
        }
        table.table td,th{
            text-align: center;
        }
        ol.breadcrumb{
            width: 1200px;
            height: 50px;
            font-size: 18px;
            color: rgb(50, 50, 50);
            margin: 30px auto;
            padding-top: 13px;
            border-radius: 5px;
            background: white;
        }
        ol.breadcrumb a{
            font-size: 18px;
            color: rgb(3, 174, 132);
        }
        ol.breadcrumb a:hover{
            color: rgb(50, 50, 50);
        }
        div.panel input.file{
            border: none;
            outline: none;
        }
        div.panel button{
            width: 300px;
            height: 40px;
            margin-left: 55px;
            border: none;
            border-radius: 5px;
            background-color: rgb(3, 174, 132);
            color: white;
            font: 18px bolder;
            outline: none;
        }
    </style>
</head>

<script>
    $(function(){
        function checkEmpty(id, name){
            var value = $("#"+id).val();
            if(value.length==0){
                alert(name+ "不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        $("#single").submit(function(){
            if(!checkEmpty("image", "单个图片"))
                return false;

            return true;
        })
        $("#detall").submit(function(){
            if(!checkEmpty("images", "详情图片"))
                return false;

            return true;
        })
    })
</script>

<body>
<div class="productImage">

    <ol class="breadcrumb">
        <li><a href="admin_category_list">${c.name}</a></li>
        <li><a href="admin_product_list?cid=${c.id}">${p.name}</a></li>
        <li class="active">产品图片管理</li>
    </ol>

    <div class="single">
        <div class="panel panel-success">
            <div class="panel-heading">新增单个图片</div>
            <div class="panel-body">
                <form method="post" id="single" action="admin_productImage_add" enctype="multipart/form-data">
                    <input type="file" name="image" id="image">
                    <input type="hidden" name="type" value="single">
                    <input type="hidden" name="pid" value="${p.id}">
                    <button type="submit">提交</button>
                </form>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <tr>
                <th width="40px">ID</th>
                <th>单个图片</th>
                <th width="50px">删除</th>
            </tr>
            <c:forEach items="${single}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>
                        <img width="60px" height="40px" src="img/single/${s.id}.jpg">
                    </td>
                    <td><a href="admin_productImage_delete?id=${s.id}" deleteLink="true"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="details">
        <div class="panel panel-success">
            <div class="panel-heading">新增详情图片</div>
            <div class="panel-body">
                <form method="post" id="detall" action="admin_productImage_add" enctype="multipart/form-data">
                    <input type="file" name="image" id="images">
                    <input type="hidden" name="type" value="detall">
                    <input type="hidden" name="pid" value="${p.id}">
                    <button type="submit">提交</button>
                </form>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <tr>
                <th width="40px">ID</th>
                <th>详情图片</th>
                <th width="50px">删除</th>
            </tr>
            <c:forEach items="${detall}" var="d">
                <tr>
                    <td>${d.id}</td>
                    <td>
                        <img width="60px" height="40px" src="img/detall/${d.id}.jpg">
                    </td>
                    <td><a href="admin_productImage_delete?id=${d.id}" deleteLink="true"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>