<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

<style>
div.container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 30vh;
}

table {
	border-collapse: collapse;
	margin: 10px auto;
	width: 70%;
}
</style>

</head>

<body>
	<h1>TODO LIST</h1>

	<div class="container">
		<table class="todo">
			<tr>
				<th colspan="5" style="border: none;">미완료</th>
			</tr>
			<tr>
				<th>NO</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>TODO</th>
				<th>작성자</th>
			</tr>

			<c:forEach items="${TODOS}" var="TODO" varStatus="INDEX">
				<tr style="text-align: center" onclick="location.href = '${rootPath}/todo/update?seq=${TODO.seq}';">
					<td>${INDEX.count}</td>
					<td>${TODO.date}</td>
					<td>${TODO.time}</td>
					<td>${TODO.todo}</td>
					<td>${TODO.username}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="container">
		<table class="todo">
			<tr>
				<th colspan="5" style="border: none;">완료</th>
			</tr>
			<tr>
				<th>NO</th>
				<th>완료일자</th>
				<th>완료시각</th>
				<th>TODO</th>
				<th>작성자</th>
			</tr>


			<c:forEach items="${COMP}" var="COM" varStatus="INDEX">
				<tr style="text-align: center">
					<td>${INDEX.count}</td>
					<td>${COM.date}</td>
					<td>${COM.time}</td>
					<td>${COM.todo}</td>
					<td>${COM.username}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<a href="${rootPath}/">HOME</a>
	<a href="${rootPath}/todo/insert">INSERT</a>
</body>

</html>