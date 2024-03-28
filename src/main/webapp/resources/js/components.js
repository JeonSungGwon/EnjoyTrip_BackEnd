export const Card = (memberNo, id, image, title, addr, width, isFavorite) => {
    const starImageSrc = isFavorite ? "full_star.svg" : "empty_star.svg"; // 전달된 값에 따라 별 이미지 경로 설정

    return `
        <form style="width: ${width}; background-image: url(${image});" 
            id="card${id}" class="card">
            <div class="hover">
                <p style="font-weight: bold; font-size: 1.2rem">${title}</p>
                <div style="display: flex;">
                    <span class="material-symbols-outlined">location_on</span>
                    <p style="font-size: 1rem;">${addr}</p>
                </div>
            </div>
            <img src="resources/images/${starImageSrc}" alt="star" id="star${id}" /> <!-- 별 이미지 설정 -->
            <input type="hidden" name="memberNo" value="${memberNo}" />
            <input type="hidden" name="contentId" value="${id}" />
            <input type="hidden" name="addr" value="${addr}" />
            <input type="hidden" name="title" value="${title}" />
            <input type="hidden" name="image" value="${image}" />
        </form>
    `;
}


export function setCardWidthHeight(card) {
	let cardWidth = card.clientWidth;
	card.style.height = `${cardWidth}px`;
}


