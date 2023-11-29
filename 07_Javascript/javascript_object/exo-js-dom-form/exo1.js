/**
 * 
 * @param {Node} nodeElement 
 */
const setInputControl = (nodeElement) => {
    nodeElement.addEventListener("blur", (event) => {
        const selfElement = event.target;
        if (! selfElement.value) {
            const warnSpan = document.createElement("span");
            selfElement.style.borderColor = 'red'
            if(!document.getElementById(`warn-${selfElement.name}`)){
                warnSpan.textContent = `Vous devez renseigner votre ${
                    selfElement.name === "password" ? "mot de passe" : "pseudonyme"
                }`;
                warnSpan.setAttribute('id', `warn-${selfElement.name}`)
                selfElement.parentNode.appendChild(warnSpan);
            }
        } else {
            selfElement.style.borderColor = 'lightgrey'
            document.getElementById(`warn-${selfElement.name}`)?.remove();
        }
    });
}
document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("exo-form");
    const inputUsername = document.getElementById("input-username");
    const inputPassword = document.getElementById("input-password");
    const userDetails = {};

    setInputControl(inputUsername);
    setInputControl(inputPassword);

    form.addEventListener("submit", (e) => {
        e.preventDefault();
        if(inputUsername.value && inputPassword.value) {
            userDetails[inputUsername.name] = inputUsername.value;
            userDetails[inputPassword.name] = inputPassword.value;
            console.log(userDetails); // -> send form
        }
    });
})