<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="layout/header.jsp"%>

<div class="container">
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr />

	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.users.id == principal.users.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-primary">수정</a>
		<button class="btn btn-primary" id="btn-delete">삭제</button>
	</c:if>
	<br /> <br />
	<div>
		글번호: <span id="id"><i>${board.id}</i></span> 작성자: <span><i>${board.users.username}</i></span>
	</div>
	<br /> <br />
	<div class="card">
		<div class="card-header">댓글리스트</div>
		<div id="reply-box" class="list-grop">
			<c:forEach var="reply" items="${board.replys}">	<%-- ${board.replys}로 댓글이 모두 담긴다. --%>
				<div id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div class="d-flex">
						<div class="font-weight-bold">${reply.users.username}&nbsp;</div>
						<div>${reply.content}</div>
					</div>
					<div class="d-flex">
						<c:if test="${reply.users.id == principal.users.id}">
							<button type="button" onClick="index.replyUpdate(${reply.id}, ${reply.content})" class="badge">수정</button>
							<button type="button" onClick="index.replyDelete(${reply.id})" class="badge">삭제</button>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br />
	<div class="card">
		<form>
			<input type="hidden" id="boardId" value="${board.id}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-binary">댓글달기</button>
			</div>
		</form>
	</div>

</div>


<script src="/js/board.js"></script>
<%@ include file="layout/footer.jsp"%>