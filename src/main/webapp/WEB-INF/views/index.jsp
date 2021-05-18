<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<%-- 페이징 대신 무한 스크롤로 구현  --%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">

		<div class="card m-8">
			<div class="card-body">
				<h4 class="card-title">${board.content}</h4>
				<a class="btn btn-primary" href="/board/${board.id}">상세보기</a>
				<div class="d-flex">
					<div class="d-flex">
						<div class="font-weight-bold">${board.users.username}&nbsp;</div>
						<div>${board.title}</div>
					</div>
				</div>
				<c:forEach var="reply" items="${board.replys}">
					<div id="reply--1" class="list-group-item d-flex justify-content-between">
						<div class="d-flex">
							<div class="font-weight-bold">${reply.users.username}&nbsp;</div>
							<div>${reply.content}</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</c:forEach>


</div>

<%@ include file="layout/footer.jsp"%>