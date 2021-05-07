<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<%-- 페이징 대신 무한 스크롤로 구현  --%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a class="btn btn-default" href="/board/${board.id}">상세보기</a>
				<p class="card-body">${board.content}</p>
			</div>
		</div>
	</c:forEach>


</div>

<%@ include file="layout/footer.jsp"%>