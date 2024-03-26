const signPage = (app) => {
    // if (localStorage.getItem("token")) navigateTo("../pages/mainPage.html");

    const signinDiv = app.getElementById("signin");
    const signupDiv = app.getElementById("signup");
    const title = app.getElementById("title_text");

    // 로그인, 회원가입 버튼 가져오기
    const goSignupBtn = app.getElementById("goSignupBtn");
    const signupBtn = app.getElementById("signupBtn");

    // '회원가입' 버튼 클릭 시 회원가입 섹션 보이기
	goSignupBtn.addEventListener("click", () => {
	  setSignupUI();
	});
	
	signupBtn.addEventListener("click", () => {
	  setSigninUI();
	});
	
	const setSignupUI = () => {
	    signinDiv.style.display = "none";
	    signupDiv.style.display = "block";
	    title.style.display = "none";
  	}

  	const setSigninUI = () => {
	    signinDiv.style.display = "block";
	    signupDiv.style.display = "none";
	    title.style.display = "block";
  	}
}

signPage(document);