// document.addEventListener("DOMContentLoaded", () => {
//     const title = document.getElementById("titleh1");
//     const paraphraphe = document.getElementById("paragraphe");
//     const btn = document.getElementById("btn");
//     console.log (title.textContent);
//     console.log(paraphraphe.innerHTML = "nouveau <b>document</b>")
//     // title.textContent = "Nouveau contenu"
//     btn.onclick = () => console.log("Say hello")
//     btn.addEventListener("click", e =>e.target.style.backgroundColor = "green");
//     document.querySelector("input#inputTest").addEventListener(
//         "input", 
//         e => console.log(e.target.value)
//     )
// })
// console.log('Loaded');
/**
 * 
 * @param {string} str 
 * @param {Node} target 
 */
const addNameToList = (str, target) => {
    const newName = document.createElement("li");
    newName.textContent = str;
    target.appendChild(newName);
}

document.addEventListener('DOMContentLoaded', () => {
    const addNameInput = document.getElementById("addName");
    const addNameSubmit = document.getElementById("addNameSubmit");
    const nameList = document.getElementById("nameList");

    addNameSubmit.addEventListener('click', () => {
        if (addNameInput.value)
            addNameToList(addNameInput.value, nameList);
    })
})

// const userObject = {
//     "first-name" : "Jean",
//     lastname : "Passe",
//     tab : [
//         1,2,3,4,5,6
//     ],
//     // customMethod : () => {console.log(userObject["first-name"], userObject.lastname)}
// }

// console.log(userObject["first-name"]);

// // const [a, b, ...other] = userObject.tab
// // console.log(other, a, b)

// // let varA = "A"
// // let varB = "B";
// // let varC = "C"
// // console.log(varA, varB, varC);
// // [varA, varB, varC] = [varC, varB, varA];
// // console.log(varA, varB, varC);

// const newUserObject = {
//     ...userObject,
//     height : 180,
//     country: "France"
// }
// console.log(newUserObject)
// const {hello : lastname, country, ...other} = newUserObject;
// console.log(lastname, country)
// console.log(other);
// console.log(newUserObject)
// newUserObject.customMethod()