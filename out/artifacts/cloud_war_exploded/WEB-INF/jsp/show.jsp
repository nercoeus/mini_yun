<%--
  Created by IntelliJ IDEA.
  User: nercoeus
  Date: 18-5-3
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="align" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>搜索结果</title>
    <style>
        *{
            padding: 0 ;
            margin: 0 ;
            font-family: "微软雅黑" ;
        }
        .header {
            height: 72px ;
            background: #458fce ;
        }
        .header .logo {
            float: left;
            color: #fff ;
            line-height: 72px ;
            font-size: 30px ;
            margin-left: 20px ;
            display:inline-block ;
            font-weight:500 ;
        }
        ul li {
            list-style: none ;
        }

        .header ul li {
            float: right ;
            color: #fff ;
            display: inline-block ;
            width: 112px ;
            height: 72px ;
            text-align: center ;
            line-height:72px ;
            cursor: pointer ;
        }
        .header a {
            color: #fff ;
            text-decoration: none ;
        }
        .header ul li:hover {
            background:#74b0e2 ;
        }

        .download {
            text-decoration: none;
            text-align: center;
        }
        .PageSize{
            width: 15px;
            line-height: 20px;
            font-size: 15px;
        }
        .page{
            text-align: center;
        }
        .page .num{
            display: inline-block;
            color: #333;
            text-decoration: none;
            width:32px;
            height: 32px;
            text-align: center;
            line-height: 32px;
            background: #2d78f4;
            border-radius: 100%;
        }
        .page .on{
            background: #333;
            color: #fff;
            border-radius: 100%;
        }

        .page .first,.page .last{
            font-size: 12px;
            display:inline-block;
            padding: 8px 12px;
            border: 1px solid #e6e6e6;
            border-radius: 2px;
            color: #333;
            text-decoration:none;
            margin-right: 12px;
            height: 16px;
            width: 24px;

        }
        .page .prev{
            font-size: 12px;
            display:inline-block;
            padding: 8px 12px;
            border: 1px solid #e6e6e6;
            border-radius: 2px;
            color: #333;
            text-decoration:none;
            margin-right: 12px;
            height: 16px;
            width: 40px;

        }
        .page .next {
            font-size: 12px;
            display:inline-block;
            padding: 8px 12px;
            border: 1px solid #e6e6e6;
            border-radius: 2px;
            color: #333;
            text-decoration:none;
            margin-left: 12px;
            margin-right: 12px;
            height: 16px;
            width: 40px;

        }
        .page a:hover{
            background: #1db69a;
            color: #fff;
            border: 1px solid #1db69a;
        }
        .table1 td{
            border-bottom:1px solid black
        }

        .button {
            color: #666;
            background-color: #EEE;
            border-color: #EEE;
            font-weight: 300;
            font-size: 16px;
            font-family: "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
            text-decoration: none;
            text-align: center;
            line-height: 30px;
            height: 30px;
            padding: 0 10px;
            margin: 0;
            display: inline-block;
            appearance: none;
            cursor: pointer;
            border: none;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-transition-property: all;
            transition-property: all;
            -webkit-transition-duration: .3s;
            transition-duration: .3s;
            }
        .button-glow {
            -webkit-animation-duration: 3s;
            animation-duration: 3s;
            -webkit-animation-iteration-count: infinite;
            animation-iteration-count: infinite;
            -webkit-animation-name: glowing;
            animation-name: glowing; }
        .button-rounded {
            border-radius: 4px; }
        .button-caution{
            background-color: #FF4351;
            border-color: #FF4351;
            color: #FFF; }
    </style>
</head>
<body>
<div class="header">
    <div class='logo'>
        <a href="${pageContext.request.contextPath}/index.jsp" >demo云盘</a>
    </div>
    <ul>
        <li >
            <a href="${pageContext.request.contextPath}/help" >help</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/requestup" >sign up</a>
        </li>
        <li >
            <a href="${pageContext.request.contextPath}/requestin" >sign in</a>
        </li>
    </ul>
</div>
<%--@declare id="location"--%><div>
    <font>
        搜索结果:共【${requestScope.pagebean.totalrecord}】条记录
    </font>
    <div>
        <table class="tablefile" rules=rows cellspacing="0" frame="box" width="95%" style="margin: auto" >
        <tr>
            <td width="65%">文件名</td>
            <td width="10%">文件大小</td>
            <td width="15%">创建日期</td>
            <td class="download" width="10%" >下载文件</td>
        </tr><br>
        <c:forEach var="temp" items="${requestScope.pagebean.list}"
                   varStatus="this">
            <tr style="line-height: 40px;">
                <td>${temp.filename}</td>
                <td>${temp.filesize } kb</td>
                <td><fmt:formatDate value="${temp.time}" pattern="yyyy-MM-dd"/></td>
                <td class="download">
                    <a href="${pageContext.request.contextPath}/download.action?id=${temp.id }&filename=${temp.filename }" class="button button-glow button-rounded button-caution">下载</a>
                   </td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>
<center>
<div>
    <p style="display: none">${requestScope.pagebean.totalpage}${requestScope.pagebean.currentpage}</p>

    <input  style="display: none" class="PageSize" type="text" id="pagesize" value="${pagebean.pagesize}"
           onchange="gotopage(${pagebean.currentpage})"
           maxlength="5">

</div>

<div class="page">
    <br/>
    <a class="first" href="javascript:void(0)" onclick="gotopage(1)">首页</a>
    <a class="prev" href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean.previouspage})">
        上一页
    </a>
    <c:forEach var="num" items="${requestScope.pagebean.pagebar}">
        <c:if test="${num==pagebean.currentpage }">
            <a style="color: red" class="num"
               href="javascript:void(0)" onclick="gotopage(${num})">${num}</a>
        </c:if>
        <c:if test="${num!=pagebean.currentpage }">
            <a class="num"
               href="javascript:void(0)" onclick="gotopage(${num})">${num}</a>
        </c:if>
    </c:forEach>
    <a class="next" href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean.nextpage})">
        下一页
    </a>
    <a class="last" href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean.totalpage})">
        尾页
    </a>
</div>


<input type="hidden" id="searchcontent" value="${searchcontent}">
</center>

<script type="text/javascript">
    function gotopage(currentpage) {
        <!--用來得到剛才新的每頁資源個數-->
        var pagesize = document.getElementById("pagesize").value;
        <!--用來得到原來的搜索內容，其實頁面的更新僅僅是重新搜索-->
        var searchcontent = document.getElementById("searchcontent").value;
        if(pagesize<1){
            pagesize = 1;
        } else if(pagesize>10) {
            pagesize = 10;
            currentpage = 1;
        }
        if((${pagebean.currentpage}-1)*pagesize>=${pagebean.totalrecord}){
            currentpage = 1;
        }
        window.location.href = '${pageContext.request.contextPath}/listfiles?currentpage='+currentpage+'&pagesize='+pagesize+'&searchcontent='+searchcontent;
    }
    function topage(currentpage) {
        <!--用來得到剛才新的每頁資源個數-->
        var pagesize = document.getElementById("pagesize").value;
        <!--用來得到原來的搜索內容，其實頁面的更新僅僅是重新搜索-->
        var searchcontent = document.getElementById("searchcontent").value;
        if(currentpage > ${pagebean.totalpage}){
            currentpage = ${pagebean.totalpage};
        } else if(currentpage<1) {
            currentpage = 1;
        }
        window.location.href = '${pageContext.request.contextPath}/listfiles?currentpage='+currentpage+'&pagesize='+pagesize+'&searchcontent='+searchcontent;

    }
</script>
</body>
</html>