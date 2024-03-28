const communityPage = (app) => {
	const reviewCards = app.querySelectorAll("figure");

	reviewCards.forEach((reviewCard) => {
		reviewCard.addEventListener("click", () => { 
			openModal();
		});
	});
}

const openModal = () => {
		let modalHtml = `
	  		<p>작성자: 이또롱</p>
	  		<p>내가 작성한 리뷰~ 너를 위해 적었지 블라블라 블라블라 블라블라</p>
	    `;
		document.getElementById("modalBackground").style.display = "flex";
		document.getElementById("modal").innerHTML += modalHtml;
		document.getElementById("modalTitle").innerText = `대구 이월드 다녀왔어요~`;

		// 닫기
		document.getElementById("modalClose").addEventListener("click", (e) => {
			e.preventDefault();
			const modal = document.getElementById("modalBackground");
			modal.style.display = "none";
			document.getElementById("modal").innerHTML = `
    			<div class="modal-top">
					<h2 class="modal-title" id="modalTitle"></h2>
					<span class="material-symbols-outlined" id="modalClose">close</span>
				</div>		
    		`;
		});
	}

communityPage(document)