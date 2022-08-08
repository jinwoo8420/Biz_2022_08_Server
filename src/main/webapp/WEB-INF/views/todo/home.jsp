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
	min-height: 50vh;
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
				<th>NO</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>TODO</th>
				<th>작성자</th>
				<th>완료여부</th>
			</tr>

			<c:forEach items="${TODOS}" var="TODO" varStatus="INDEX">
				<tr style="text-align: center" onclick="location.href = '${rootPath}/todo/update?seq=${TODO.seq}';">
					<td>${INDEX.count}</td>
					<td>${TODO.date}</td>
					<td>${TODO.time}</td>
					<td>${TODO.todo}</td>
					<td>${TODO.username}</td>

					<c:if test="${empty TODO.enabled}">
						<td onclick="location.href = '${rootPath}/todo/complete?seq=${TODO.seq}';">완료처리</td>
					</c:if>

					<c:if test="${TODO.enabled}">
						<td>완료</td>
					</c:if>

				</tr>
			</c:forEach>
		</table>
	</div>

	<a href="${rootPath}/todo/insert">INSERT</a>
</body>

</html>