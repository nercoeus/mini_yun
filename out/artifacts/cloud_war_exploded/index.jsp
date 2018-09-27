<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>

    <title>little demo</title>
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
      a {
        color: #fff ;
        text-decoration: none ;
      }
      .header ul li:hover {
        background:#74b0e2 ;
      }

      .wrapper {
        text-align: center;
      }

      .head {
        margin-top: 150px;
        font-size: 40px;
        font-family: 微软雅黑;
        color: #2d78f4;
      }
      .input{
        width: 40%;
        height: 36px;
        border: 1px solid #828581;
        position: absolute;
        left: 25%;
        top: 340px;
      }
      .search{
        width: 10%;
        height: 36px;
        color: white;
        background: #2062f4;
        border: 0;
        font-size:15px;
        position: absolute;
        top:340px;
        left: 64%;
      }
    </style>
  </head>
  <body onload="jsmethod()">
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
  <center>
  <div class="wrapper">
    <div class="head">WELCOME!</div>
      <form action="${pageContext.request.contextPath}/searchfile" method="post">
        <input id="query" class="input" type="text" name="searchcontent" placeholder="请输入要查找的文件名">
        <input class="search" type="submit" value="搜索一下">
      </form>
    <br/>
    <font size="2px" color="#ff0913">${messages}</font>
    </div>
  </center>
  </body>
<script>
    function jsmethod(){
        document.getElementById("query").focus()
    }
</script>
</html>
