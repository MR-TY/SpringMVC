<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 使用spring的表单标签：更快的进行表单的开发，并且进行表单的回显 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="testConversionServiceConverer" method="POST">
		<!--lastName-email-gender-department.id  -->
		Employee:<input type="text" name="employee"/>
		<input type="submit" value="提交" />
	</form>
<br><br>
	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		<!-- 
			1.path:支持html的name属性
			2.modelAttribute：需要传进一个bean这个bean必须和表单标签一一对应，对应不上就不能进行显示
		 -->
		<!-- path：对应的是html对应的name属性值 -->
		
		<c:if test="${employee.id == null}">
			LastName:<form:input path="lastName" />
		</c:if>
			<c:if test="${employee.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"/>
			<%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
			<%-- 
			<form:hidden path="_method" value="PUT"/>
			--%>
		</c:if>
		
		<br>
			Email:<form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap();
				genders.put("1", "Male");
				genders.put("0", "Female");

				request.setAttribute("genders", genders);
		%>
			Gender:<br>
		<form:radiobuttons path="gender" items="${genders}" delimiter="<br>" />
		<br>
			
			Department:<form:select path="department.id" items="${department}"
			itemLabel="departmentName" itemValue="id"></form:select>
		<br>
		<!-- 
			1.date向string类型的转换
			2.数据类型的格式化
			3.数据校验的问题
		 -->
			Birth:<form:input path="birth" />
		<%-- 	Salary:<form:input path="salary" /> --%>
		<input type="submit" value="提交" />
	</form:form>
</body>
</html>