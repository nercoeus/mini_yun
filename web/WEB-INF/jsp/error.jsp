<%--
  Created by IntelliJ IDEA.
  User: nercoeus
  Date: 18-5-3
  Time: 下午3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<script type="text/javascript">
    var time=5;
    function Redirect() {
        window.location = "/index.jsp";
    }
    var i = 0;
    function dis() {
        document.all.s.innerHTML = "****** 错误信息： ${globalmessage} ******   " +(time - i) + "秒后自动跳往主页";
        i++;
    }
    timer = setInterval('dis()', 1000); //显示时间
    timer = setTimeout('Redirect()', time * 1000); //跳转
</script>
<span id = "s">
</span>
</body>
</html>
