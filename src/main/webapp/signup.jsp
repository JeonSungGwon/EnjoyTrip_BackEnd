<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Enjoy Trip!</title>
    
    <link href="resources/css/index.css" rel="stylesheet" />
    <link href="resources/css/signup.css" rel="stylesheet" />

    <script type="module" src="resources/js/signpage.js" defer></script>
  </head>

  <body>
    <button type="button" class="logo_btn">
      <img src="resources/images/logo.svg" alt="로고이미지" onclick="" />
    </button>

    <main id="signup" class="signup">
	    <div>
			<p>회원가입</p>
			<form id="signupForm">
				<input id="upName" class="up-name" type="text" placeholder="이름" />
				<input
				  id="upId"
				  class="up-id"
				  type="email"
				  placeholder="아이디(이메일)"
				/>
				<input
				  id="upPwd"
				  class="up-pwd"
				  type="password"
				  placeholder="비밀번호"
				/>
				<button type="submit" id="signupBtn">회원가입</button>
			</form>
	    </div>
    </main>
  </body>
</html>

