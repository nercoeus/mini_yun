<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iCloud帮助页</title>
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
   color: #ffffff;
   line-height: 72px ;
   font-size: 30px ;
   margin-left: 20px ;
   display:inline-block ;
   font-weight:500 ;
  }
  a {
      color: #fff;
      text-decoration: none;
  }

 </style>
</head>
<body>
<div class="header">
    <div class='logo'>
        <a href="${pageContext.request.contextPath}/index.jsp">demo云盘</a>
    </div>
 </div>

   <font style="font-size: 30px;"> 如何上传或者下载文件？</font><br/>
   <font style="font-size: 25px; background-color: silver">任何人均可以下载他人共享的文件，如果想上传文件，您必须先注册并登陆</font><br/><br/>
   <font style="font-size: 30px;"> 上传的文件会被别人看到并下载吗？</font><br/>
   <font style="font-size: 25px; background-color: silver">您上传的文件默认是私有的，上传之后您可以选择共享哪些文件</font><br/>
   <font style="font-size: 30px;"> 忘记密码怎么办？</font><br/>
   <font style="font-size: 25px; background-color: silver;">您可以发email至1101875387@qq.com询问，后续会开通密码找回功能</font><br/>
   <font style="font-size: 30px;"> 上传文件有什么限制吗？</font><br/>
   <font style="font-size: 25px; background-color: silver;">普通用户单次上传文件不能超过20Mb，VIP用户不能超过50Mb</font><br/>
</body>
</html>