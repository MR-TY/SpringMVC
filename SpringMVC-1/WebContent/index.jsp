<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a href="hi/TestPage">Test Page</a>
		<br><br>
		<a href="hi/TestView">Test View</a>
		<br><br>
		<form action="hi/TestModelAttribute" method="POST"> 
				<input type="hidden" name="id" value="1"></input>
			username:<input type="text" name="username" value="TOM"></input>
			<br>
			emali:<input type="text" name="emali" value="@123"></input>
			<br>
			age:<input type="text" name="age" value="12"></input>
			<br>
			<input type="submit" value="submit"></input>
			<br>
		</form>
		<br><br>

		<a href="hi/TestsessionAtrribute">Test sessionAtrribute</a>
		<br><br>
		<!-- 使用servlet原生的API作为参数 -->
		<a href="hi/TestMap">Test tMap</a>
		<br><br>
		<!-- 使用servlet原生的API作为参数 -->
		<a href="hi/TestModelAndView">Test ModelAndView</a>
			<br><br>
		<!-- 使用servlet原生的API作为参数 -->
		<a href="hi/TestServlet">Test REST Servlet</a>
			<br><br>
		<!--POJO对象绑定请求参数  -->
		<form action="hi/TestPOJO" method="POST"> 
			username:<input type="text" name="username"></input>
			<br>
			password:<input type="text" name="password"></input>
			<br>
			emali:<input type="text" name="emali"></input>
			<br>
			age:<input type="text" name="age"></input>
			<br>
			province:<input type="text" name="address.province"></input>
			<br>
			city:<input type="text" name="address.city"></input>
			<br>
			<input type="submit" value="submit"></input>
			<br>
		</form>
		<br><br>
		<!-- 测试请求参数@CookieValue -->
		<a href="hi/CookieValue">Test REST CookieValue</a>
		<br><br>
		<!-- 测试请求参数@RequestParam -->
		<a href="hi/RequestParam?username=mr_ty&age=11">Test REST RequestParam</a>
		<br><br>
		<a href="hi/helloWorld1/5">Hello World2</a>
		<br><br>
		<form action="hi/TestREST/1" method="POST"> 
			<input type="hidden" name="_method" value="PUT"></input>
			<input type="submit" value="Test REST post put"></input>
		</form>
		<br><br>
		<form action="hi/TestREST/1" method="POST"> 
			<input type="hidden" name="_method" value="DELETE"></input>
			<input type="submit" value="Test REST post delete"></input>
		</form>
		<br><br>
		<form action="hi/TestREST" method="POST"> 
			<input type="submit" value="Test REST post "></input>
		</form>
		<br><br>
		<!-- 测试get的请求 -->
		<a href="hi/TestREST/1">Test REST Get</a>
		<br><br>
</body>
</html>