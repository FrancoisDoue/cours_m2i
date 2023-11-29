document.addEventListener('DOMContentLoaded', () => {
    const modal = document.querySelector("div.modal");

    modal.addEventListener('click', (event) => {
        if (event.target === event.currentTarget) modal.style.display = "none";
    })
})