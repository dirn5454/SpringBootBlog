let index = {


	init: function() {
		$("#btn-write").on("click", () => {
			this.save();
		});

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});

		$("#btn-update").on("click", () => {
			this.update();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});


	},



	save: function() {

		let data = JSON.stringify({
			title: $("#title").val(),
			content: $("#content").val(),
			users: $("#users").val()
		});


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
	update: function() {
		let id = $("#id").text();

		let data = JSON.stringify({
			title: $("#title").val(),
			content: $("#content").val()
		});

		$.ajax({
			type: "POST",
			url: "/board/" + id,
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	deleteById: function() {
		let id = $("#id").text();

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
			type: "POST",
			url: "/board/"+boardId+"/reply",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글작성이 완료되었습니다.");
			location.href = "/board/"+boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}
index.init();