import Cat from "./animaux.js";

let cat = new Cat('Caramel', 3);
console.log(cat.getName)
console.log(cat.setName = "Minou")

// import {Chien} from "./animaux.js"

// document.addEventListener("DOMContentLoaded", () => {
//     const form = document.getElementById('form-pet');
//     const /*petArray = [], */petObjList = {};
    
//     form.addEventListener('submit', e => { 
//         const inputList = document.querySelectorAll('form > div > input'), tab = [];
//         e.preventDefault()
//         for (const element of inputList) tab.push(element.value);
//         const doggo = new Chien(...tab)
//         // petArray.push(doggo) // -> bonus part | Please stand by
//         petObjList[doggo.name] = doggo;
//         console.log(petObjList)
//     });
// })