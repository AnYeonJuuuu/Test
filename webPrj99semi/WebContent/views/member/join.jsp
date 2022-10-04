<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#main{
		width: 60vw;
		height: 60vh;
		border: 5px solid black;
		margin: auto;
	}

	form{
		width: 100%;
		height: 100%;
	}

	#join-area{
		width: 100%;
		height: 70%;
		border: 1px solid red;
		display: grid;
		/* 열에 대한 처리 */
		grid-template-columns: 1fr 4fr;
		grid-template-rows: repeat(7, 1fr);
		justify-items: center;
	}

	#join-area>div{
		width: 80%;
	}

</style>
<body>
	
	
	<%@ include file="/views/common/header.jsp" %>

	<div id="main">
		<h1 align="center">회원가입</h1>

		<form action="/semi/member/join" method="post">

			<div id="join-area">
				<div>아이디</div>
				<div><input type="text" name="memberId"></div>
				<div>비밀번호</div>
				<div><input type="password" name="memberPwd1"></div>
				<div>비밀번호 확인</div>
				<div><input type="password" name="memberPwd2"></div>
				<div>닉네임</div>
				<div><input type="text" name="memberNick"></div>
				<div>주소</div>
				<div><input type="text" name="addr"></div>
				<div>취미</div>
				<div>
					<label for="">코딩
						<input type="checkbox" name="hobby" value="codding">
					</label>
					<label for="">낚시
						<input type="checkbox" name="hobby" value="fishing">
					</label>
					<label for="">운동
						<input type="checkbox" name="hobby" value="workout">
					</label>
				</div>
				<div>회원가입</div>
				<div><input type="submit" value="회원가입"></div>
			</div>

		</form>

		
	</div>

	<script>
		// 비밀번호 일치여부 체크
		const pwd1 = document.querySelector("input[name=memberPwd1]");
		const pwd2 = document.querySelector("input[name=memberPwd2]");
	
		function check() {
			
			if(pwd1.value.length > 0 && pwd1.value == pwd2.value){
				return true;
			}else{
				alert('패스워드가 일치하지 않습니다.');
				return false;
			}
			
		}
	</script>
	
</body>
</html>