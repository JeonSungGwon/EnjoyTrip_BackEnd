import { navigateTo } from "./service.js";

export function Card(id, image, title, addr, width) {
  return `
    <div style="width: ${width}; background-image: url(${image});" id="card${id}" class="card" >
        <div class="hover">
            <p style="font-weight: bold; font-size: 18px">${title}</p>
            <div style="display: flex;">
                <span class="material-symbols-outlined">location_on</span>
                <p style="font-size: 16px;">${addr}</p>
            </div>
        </div>
        <img src="resources/images/empty_star.svg" alt="star" id="star${id}" />
       </div>
    `;
}

export function setCardWidthHeight(card) {
  let cardWidth = card.clientWidth;
  card.style.height = `${cardWidth}px`;
}

export function Modal(html) {
  let body = document.getElementsByTagName("body")[0].innerHTML;
  let modal = `
        <div class="modal-background" id="modalBackground">
            <div class="modal">${html}</div>
        </div>
    `;

  document.getElementsByTagName("body")[0].innerHTML += modal;
}
