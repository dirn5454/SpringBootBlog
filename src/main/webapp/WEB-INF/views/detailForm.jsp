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
		글번호: <span id="id"><i>${board.id}</i></span> 
		작성자: <span><i>${board.users.username}</i></span>
	</div>
</div>


<script src="/js/board.js"></script>
<%@ include file="layout/footer.jsp"%>