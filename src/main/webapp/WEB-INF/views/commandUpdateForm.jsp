<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>


<!DOCTYPE html>


<html>
<head>
<script>
	String msg = (String)request.getAttribute("javax.servlet.forward.request_uri");

</script>
</head>
<body>
	<div id="wrap">
		<br> <b> <font size="5" color="gray">댓글 수정</font></b>
		<hr size="1" width="550">
		<br>
		<div id="commentUpdateForm">
			<form name="updateInfo" target="parenForm">
			
				<c:forEach var="reply" items="${board.replys}">

					<div class="form-group">댓글 번호: ${reply.id}</div>
						<textarea rows="7" cols="70" id="replyWindow">${reply.content}</textarea>
			
					

				</c:forEach>
				<br> <br> <input type="button" value="등록" id="btn-reply-update"> <input type="button" value="닫기" onClick="window.close()">

			</form>
		</div>
	</div>
</body>
</html>
