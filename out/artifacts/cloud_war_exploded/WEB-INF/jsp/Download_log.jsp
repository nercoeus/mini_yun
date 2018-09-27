<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="align" uri="/struts-tags" %>
<html>
<head>
    <title>下载记录</title>
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
        .head {
            margin-left: 20px;
            margin-top: 35px;
            font-size: 25px;
            font-family: 微软雅黑;
            color: #2d78f4;
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
        a {
            color: #fff ;
            text-decoration: none ;
        }
        .header ul li:hover {
            background:#74b0e2 ;
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
        <li >
            <a href="${pageContext.request.contextPath}/searchUserFiles" >home</a>
        </li>
    </ul>
</div>
<div>
    <div class="head">下载记录:</div>
    <br/>
    <br/>
    <table class="tablefile" rules=rows cellspacing="0" frame="box" width="95%" style="margin: auto" >

        <tr>
            <td width="35%">用户</td>
            <td width="15%">文件</td>
            <td width="15%">下载日期</td>
            <td width="10%">操作</td>
        </tr><br>
        <c:forEach var="temp" items="${requestScope.List}"
                   varStatus="this">
            <tr style="line-height: 40px;">
                <td>${temp.download_user_name}</td>
                <td>${temp.download_file_name}</td>
                <td>
                    <fmt:formatDate pattern="yyyy-mm-dd" value="${temp.download_time}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/download_log_delete.action?download_user_name=${temp.download_user_name}&download_file_name=${temp.download_file_name}"
                       class="button button-glow button-rounded button-caution">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
