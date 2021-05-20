<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<%-- 페이징 대신 무한 스크롤로 구현  --%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">

		

				<div class="card">

					<div class="d-flex">
						<h4 class="card-title">${board.users.username} </h4>
						<a class="btn btn-default" style="width: 1050px" href="/board/${board.id}"></a>
					</div>
					<h4 class="card-text">${board.content}</h4>
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
		
	</c:forEach>
</div>

<%@ include file="layout/footer.jsp"%>