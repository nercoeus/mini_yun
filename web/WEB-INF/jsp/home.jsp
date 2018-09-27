<%--
  Created by IntelliJ IDEA.
  User: nercoeus
  Date: 18-5-5
  Time: 下午5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="align" uri="/struts-tags" %>
<html>
<head>
    <title>home</title>
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
        <a href="${pageContext.request.contextPath}/index.jsp">demo云盘</a>
    </div>
    <ul>
        <li >
            <a href="${pageContext.request.contextPath}/help" >help</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/requestout" >sign out</a>
        </li>
        <li >
            <a href="${pageContext.request.contextPath}/shutdown" >shut down</a>
        </li>
    </ul>
</div>
    <!--传输文件模块-->
<center>
    <br/>
    <br/>
    <div style="height:50px">
        <a href="${pageContext.request.contextPath}/download_log.action?username=${requestScope.pagebean.list[0].filepath}"
           class="button button-glow button-rounded button-caution">下载记录</a>
        <a href="${pageContext.request.contextPath}/upload_log.action?username=${requestScope.pagebean.list[0].filepath}"
           class="button button-glow button-rounded button-caution">上传记录</a>
    </div>
    <br/>
    <br/>
    <form action="${pageContext.request.contextPath}/upload.action" method="post" enctype="multipart/form-data">
        <input type="submit" onclick="return checkfile()" value="上传文件" style="background: white;"/>
        <input type="file" onchange="checkfile()" id="fileupload" name="file" onpropertychange="getFileSize(this.value)"/><br/>
        <input type="hidden" name="username" value="${user_name}" /><br/>
         <img id="tempimg" dynsrc="" src="" style="display:none" />  
        ${message}
    </form>
</center>
<br/>
<br/>

<%--@declare id="location"--%><div>
    <font>
        Your Files
    </font>
    <div>
        <table class="tablefile" rules=rows cellspacing="0" frame="box" width="95%" style="margin: auto" >
            <tr>
                <td width="45%">文件名</td>
                <td width="10%">文件大小</td>
                <td width="15%">创建日期</td>
                <td width="10%">下载文件</td>
                <td width="10%">是否共享</td>
                <td width="10%">操作</td>
            </tr><br>
            <c:forEach var="temp" items="${requestScope.pagebean.list}"
                       varStatus="this">
                <tr style="line-height: 40px;">
                    <td>${temp.filename}</td>
                    <td>${temp.filesize } kb</td>
                    <td><fmt:formatDate value="${temp.time}" pattern="yyyy-MM-dd"/></td>
                    <td class="download">
                        <a href="${pageContext.request.contextPath}/download.action?id=${temp.id }&filename=${temp.filename }"
                           class="button button-glow button-rounded button-caution">下载</a>
                    </td>
                    <td>
                        <form>
                            <select  id="${temp.id}" onchange="gochange(${pagebean.currentpage},${temp.id})" >
                                <c:if test="${temp.canshare==0 }">
                                    <option value="0">私有</option>
                                    <option value="1" >共享</option>
                                </c:if>
                                <c:if test="${temp.canshare==1 }">
                                    <option value="1" selected="selected">共享</option>
                                    <option value="0" >私有</option>
                                </c:if>
                            </select>
                        </form>
                    </td>
                    <td>
                        <a href="javascript:void(0)" onclick="godelete(${pagebean.currentpage},${temp.id})"
                           class="button button-glow button-rounded button-caution">删除</a>
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

</center>

<script>
    function godelete(currentpage,fileid){
        var pagesize = document.getElementById("pagesize").value;

        if(pagesize > 10 || pagesize >= ${pagebean.totalrecord - pagebean.pagesize * ( pagebean.currentpage - 1 )}){
            pagesize = Math.min(pagesize,${pagebean.totalrecord});
            currentpage = 1 ;
        }else if(pagesize < 1){
            pagesize = 1;
        }

        var r=confirm("确认删除文件？");
        if(r==true){
            window.location.href = '${pageContext.request.contextPath}/deletefile?currentpage='+currentpage+'&pagesize='+ pagesize+'&id='+fileid;
        }else{
            return false;
        }
    }
    function gochange(currentpage,fileid){

        var canshare = document.getElementById(fileid).value;
        var pagesize = document.getElementById("pagesize").value;
        var r=confirm("如果设置共享，您的文件将可以被其他人搜索到");
        if (r==true){
            window.location.href = '${pageContext.request.contextPath}/changefilestatus?currentpage='+currentpage+'&pagesize='+ pagesize+'&id='+fileid+'&canshare='+canshare;
        }else{
            location.reload();
        }
    }
    function gotopage(currentpage) {
        <!--用來得到剛才新的每頁資源個數-->
        var pagesize = document.getElementById("pagesize").value;
        <!--用來得到原來的搜索內容，其實頁面的更新僅僅是重新搜索-->
        //var searchcontent = document.getElementById("searchcontent").value;
        if(pagesize<1){
            pagesize = 1;
        } else if(pagesize>10) {
            pagesize = 10;
            currentpage = 1;
        }
        if((${pagebean.currentpage}-1)*pagesize>=${pagebean.totalrecord}){
            currentpage = 1;
        }
        //window.location.href = '${pageContext.request.contextPath}/help';
        window.location.href = '${pageContext.request.contextPath}/searchUserFiles?currentpage='+currentpage+'&pagesize='+pagesize;
    }
</script>

</body>
</html>
