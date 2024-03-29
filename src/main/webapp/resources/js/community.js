const communityPage = (app) => {
	const reviewCards = app.querySelectorAll("figure");

	reviewCards.forEach((reviewCard) => {
		let reviewId = reviewCard.id.split("review")[1];
		reviewCard.addEventListener("click", () => {
			let reivewData = {
				title: "",
				addr: "",
				author: "",
				image: "",
				content: "",
			};
			$.ajax({
				type: 'get',
				url: 'community?action=detail&id=' + reviewId,
				dataType: 'json',
				success: function(json) {
					reivewData = {
						title: json.title,
						addr: json.addr,
						author: json.author,
						image: json.image,
						content: json.content,
					}
				},
				error: function(xhr, status, error) {
					alert(error);
				},
				complete: function(data, textStatus) {
					openModal(reivewData);
				}
			});
			//openModal(reviewId);
		});
	});
}

const openModal = (data) => {
	console.log(data);
	let modalHtml = `
			<div class="modal-info">
				<span>📌${data.addr}</span>
		  		<span>✍🏻 ${data.author}</span>			
			</div>
	  		<p>리뷰 내용</p>
	  		<div style="border: #aaa solid 0.5px; margin-bottom: 1rem;">
		  		<p>${data.content}</p>	  		
	  		</div>
	  		<img src="${data.image}" />
	    `;
	document.getElementById("modalBackground").style.display = "flex";
	document.getElementById("modal").innerHTML += modalHtml;
	document.getElementById("modalTitle").innerText = `${data.title}`;

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