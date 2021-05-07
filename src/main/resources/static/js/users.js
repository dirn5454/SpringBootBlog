let index = {


	init: function() {
		$("#btn-save").on("click", () => { // ()=> this를 바인딩하기 위해 사용
			this.save();
		});
		/*
		$("#btn-login").on("click", () => { // ()=> this를 바인딩하기 위해 사용
			this.login();
		});
		*/
	},
	save: function() {

		let data = JSON.stringify({
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		});


		$.ajax({
			type: "POST",
			url: "/auth/joinUser",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	}
	/*
	login: function() {
		let data = JSON.stringify({
			username: $("#username").val(),
			password: $("#password").val()
		});


		$.ajax({
			type: "POST",
			url: "/api/temp/login",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("로그인이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	}
	*/
}

index.init();