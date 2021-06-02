let index = {


	init: function() {
		$("#btn-write").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.boradDelete();
		});

		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});
		$("#btn-reply-update").on("click", () => {
			this.replyUpdate();
		});


	},


	save: function() {

		let data = JSON.stringify({
			title: $("#title").val(),
			content: $("#content").val(),
			users: $("#users").val()
		});
// #뒤는 버튼으로 넘어갈 text나 input의 id값이다.

		$.ajax({
			type: "POST",
			url: "/board",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},
	boardUpdate: function(id) {

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "PUT",
			url: "/board/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	boradDelete: function() {
		let id = $("#id").text();
		console.log(id);

		$.ajax({
			type: "DELETE",
			url: "/board/" + id,
			dataType: "json"

		}).done(function(resp) {
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},



	replySave: function() {

		let data = {
			content: $("#reply-content").val()
		};

		let boardId = $("#boardId").val();

		console.log(data);
		console.log(boardId);

		$.ajax({
			type: 'POST',
			url: "/board/" + boardId + "/reply",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글작성이 완료되었습니다.");
			location.href = "/board/" + boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	replyDelete: function(replyId) {


		let boardId = $("#boardId").val();
		alert(replyId);


		$.ajax({
			type: "DELETE",
			url: "/board/" + boardId + "/reply/" + replyId,
			dataType: "json"
		}).done(function(resp) {
			alert("댓글삭제가 완료되었습니다.");
			location.href = "/board/" + boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	replyWindow: function(replyId) {

		let boardId = $("#boardId").val();
        let replySingleId = $("#replySingleId").val();
        
        alert(replySingleId);
        
		window.open("/board/" + boardId + "/commandUpdateForm/" + replyId, "replyUpdateForm", "width=570, height=350, resizable=no, scrollbars=no");

		$.ajax({
			type: 'POST',
			url: "/board/" + boardId + "/reply/" + replyId,
			data: JSON.stringify(replyId), // 수정된 부분 -> 오류발생
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});


	}

	/*
	replyUpdate: function(replyID, replyContentt) {
		

		let boardId = $("#boardId").val();

		let data = JSON.stringify({
			title: $("#title").val(),
			content: $("#content").val()
		});

		$.ajax({
			type: "PUT",
			url: "/board/" + boardId + "/reply/" + replyId,
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글수정이 완료되었습니다.");
			location.href = "/board/" + boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
	*/


}
index.init();