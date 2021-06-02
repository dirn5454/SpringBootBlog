<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<%-- 페이징 대신 무한 스크롤로 구현  


<script type="text/javascript">
	$(document).ready(function() {

		var win = $(window);

		win.scroll(function() {

			if ($(document).height() - win.height() == win.scrollTop()) {
				$('#loading').show();

				$.ajax({
					url : "/",
					dataType : 'html',
					success : function(html) {
						$('#posts').append(html);
						$('#loading').hide();
					}
				});
			}

		});

	});
	
</script>
--%>
<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card">
			<div class="d-flex">
				<h4 class="card-title">${board.users.username}</h4>
				<a class="btn btn-default" style="width: 1100px" href="/board/${board.id}"></a>
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

	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">이전</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">이전</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">다음</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">다음</a></li>
			</c:otherwise>
		</c:choose>
	</ul>


</div>

<%@ include file="layout/footer.jsp"%>