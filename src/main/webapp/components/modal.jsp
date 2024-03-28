<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<style>
/* Modal */
.modal-background {
	position: fixed;
	top: 0;
	left: 0;
	width: 100vw;
	height: 100vh;
	background-color: rgba(0, 0, 0, 0.7);
	display: none;
	z-index: 10;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.modal {
	background-color: #fff;
	opacity: 1;
	padding: 1.2rem;
	overflow-y: auto;
	border-radius: 15px;
}

.modal-top {
	display: flex;
}

.modal-title {
	color: #fff;
	background-color: #4e71a7;
	padding: 1rem 0.5rem;
	margin: 0;
	width: 100%;
}

.modal p {
	margin: 10px 0;
}

.modal .material-symbols-outlined {
	cursor: pointer;
}
</style>
</head>
<div class="modal-background" id="modalBackground">
	<div class="modal" id="modal">
		<div class="modal-top">
			<h2 class="modal-title" id="modalTitle"></h2>
			<span class="material-symbols-outlined" id="modalClose">close</span>
		</div>
	</div>
</div>