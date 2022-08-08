<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

</head>

<body>
	<form:form modelAttribute="todoVO" class="insert-form">
		<fieldset>
			<legend>TODO 작성</legend>

			<input name="username" readonly="readonly" type="hidden" value="<sec:authentication property="principal.username" />" />
			<input name="date" readonly="readonly" value="${todoVO.date}" />
			<input name="time" readonly="readonly" value="${todoVO.time}" />
			<input name="todo" placeholder="TODO" value="${todoVO.todo}" />
			<button>INSERT</button>
		</fieldset>
	</form:form>
</body>

</html>