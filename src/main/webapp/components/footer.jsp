<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<style>
		footer {
		  position: fixed;
		  bottom: 0;
		  width: 100%;
		  height: 50px;
		  display: flex;
		  justify-content: space-between;
		  align-items: center;
		  background-color: #738fbb;
		  z-index: 10;
		}
		
		footer p {
		  color: #fff;
		  margin: 16px 20px;
		  font-size: 20px;
		  cursor: pointer;
		}
	</style>
</head>
<footer>
   <p id="ssafy">SSAFY</p>
   <p id="contactus">ContactUs</p>
</footer>
<script>
	// 싸피 홈페이지로 이동
	document.getElementById("ssafy").addEventListener("click", () => {
		window.open("https://www.ssafy.com/ksp/jsp/swp/swpMain.jsp");
	});
	
	// contact us
	document.getElementById("contactus").addEventListener("click", () => {
		let modalHtml = `
	  		<h2>📺 Github</h2>
			<h3>하람(@ramrami-B) | 성권(@JeonSungGwon)</h3>
			<h2>📧 Email</h2>
			<h3>하람 developer.venice@gmail.com</h3>
			<h3>성권 jeonsg9904@gmail.com</h3>
	    `;
	    document.getElementById("modalBackground").style.display = "flex";
	  	document.getElementById("modal").innerHTML += modalHtml;
	    document.getElementById("modalTitle").innerText = "SSAFY 11기 대전 7반 백하람 & 전성권";
	
	  // 닫기
	  document.getElementById("modalClose").addEventListener("click", (e) => {
	    e.preventDefault();
	    const modal = document.getElementById("modalBackground");
	    modal.style.display = "none";
	    document.getElementById("modal").innerHTML = "";
	  });
	});
</script>