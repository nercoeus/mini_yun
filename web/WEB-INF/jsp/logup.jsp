<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
			margin-top: 50px;
			font-size: 40px;
			font-family: 微软雅黑;
			color: rgb(27, 24, 209);
		}

		form {

			width: 260px;
			height: 180px;
			margin: 35px auto;
			padding: 30px;
			box-shadow: 0px 1px 2px 1px #aaaaaa,
			inset 0px 1px 1px rgba(255, 255, 255, 0.7);
			border-radius: 3px;
		}

		form ul {
			width: 100%;
			height: 100%;
			text-align: left;
			display: flex;
			flex-flow: column nowrap;
			justify-content: space-between;
		}

		ul li div {
			width: 260px;
			height: 40px;
			background: #e1dcd8;
			color: rgb(98, 94, 91);
			box-shadow: inset 0px 2px 5px #aaaaaa;
			border-radius: 5px;
			position: relative;
		}

		ul li div input {
			height: 40px;
			width: 190px;
			padding: 0 35px;
			border: none;
			background: #e1dcd8;
			color: rgb(98, 94, 91);
			box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.7),
			inset 0px 2px 5px #aaaaaa;
			border-radius: 5px;
		}

		ul li input[type*="submit"] {
			width: 100%;
			height: 40px;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 18px;
			color: #ffffff;
			background: -moz-linear-gradient( top,
			#d8dbd1 0%,
			#afb2a9 50%,
			#d8dbd1);
			background: -webkit-gradient( linear, left top, left bottom,
			from(#d8dbd1),
			color-stop(0.50, #afb2a9),
			to(#d8dbd1));
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius: 5px;
			border: 1px solid #878c7c;
			-moz-box-shadow: 0px 1px 0px rgba(170, 170, 170, 1),
			inset 0px 1px 1px rgba(255, 255, 255, 0.7);
			-webkit-box-shadow: 0px 1px 0px rgba(170, 170, 170, 1),
			inset 0px 1px 1px rgba(255, 255, 255, 0.7);
			box-shadow: 0px 1px 0px rgba(170, 170, 170, 1),
			inset 0px 1px 1px rgba(255, 255, 255, 0.7);
			text-shadow: 0px -1px 0px rgba(000, 000, 000, 0.3),
			0px 0px 0px rgba(255, 255, 255, 0);
		}

		ul li input[type*="submit"]:hover {
			width: 100%;
			height: 40px;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 18px;
			color: #ffffff;
			background: -moz-linear-gradient( top,
			#ff5d6a 0%,
			#FF4351 50%,
			#ff5d6a);
			background: -webkit-gradient( linear, left top, left bottom,
			from(#ff5d6a),
			color-stop(0.50, #ff5260),
			to(#ff5d6a));
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius: 5px;
			border: 1px solid #FF4351;
			-moz-box-shadow: 0px -1px 0px rgba(170, 170, 170, 1),
			inset 0px -1px 1px rgba(255, 255, 255, 0.7);
			-webkit-box-shadow: 0px -1px 0px rgba(170, 170, 170, 1),
			inset 0px -1px 1px rgba(255, 255, 255, 0.7);
			box-shadow: 0px -1px 0px rgba(170, 170, 170, 1),
			inset 0px -1px 1px rgba(255, 255, 255, 0.7);
			text-shadow: 0px 1px 0px rgba(000, 000, 000, 0.3),
			0px 0px 0px rgba(255, 255, 255, 0);
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
			<a href="${pageContext.request.contextPath}/requestin" >sign in</a>
		</li>
	</ul>
</div>

<div class="wrapper">
	<div class="head">NICE TO MEET YOU!</div>

	<form action="${pageContext.request.contextPath}/logup.action" method="post">
		<ul>
			<li>
				<div class="text">
					<td>
						<input id="query" type="text" name="username" placeholder="请输入用户名">
						<font color="red" size="2px">${usernameerror}</font>
					</td>
				</div>
			</li>
			<li>
				<div class="password">
					<td>
						<input type="password" name="password" placeholder="请输入密码">
						<font color="red" size="2px">${passworderror}</font>
					</td>
				</div>
			</li>
			<li>

				<input type="submit" value="sign up">

			</li>
		</ul>
	</form>
</div>
<script>
    function jsmethod(){
        document.getElementById("query").focus()
    }
</script>
</body>
</html>