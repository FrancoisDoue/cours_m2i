// // exo 14
// function capitalizeName(str) {
//     let firstChar = str.charAt(0).toUpperCase();
//     return firstChar + str.slice(1).toLowerCase();
// }
// function nameFunction(fname, lname){
//     return `${capitalizeName(fname)} ${capitalizeName(lname)}`;
// }
// console.log(nameFunction("fraNçOis","dOué"));

// // exo 15
// function soustraire(a, b){
//     console.log(`Je soustrais ${b} à ${a}`);
//     return a-b;
// }
// console.log(soustraire(2,"1"))

// // exo 16
// function quelleHeure(str = "12h00"){
//     console.log(`Il est ${str}`);
// }
// quelleHeure();
// quelleHeure("00h00");


// "use strict"
// class HelloClass{
//     test = "";

//     setTest = (a)=>{
//         this.test = a;
//         return this.test;
//     }
//     getTest = () => {return this.test}

//     constructor(test){
//         this.test = test
//     }
//     static testFunc(){
//         console.log("Hello world")
//     }
// }

// let element = new HelloClass("Hello");
// console.log(element.setTest("LOREM IPSUM!"))
// HelloClass.testFunc()

// window.onload = () => console.log("Loaded, sir")
// window.addEventListener("load", function(){
//     console.log("Loaded, sir")
// })

const hello = (name)=>{
    alert("Hello "+name)
}
const bonjour = (name)=>{
    alert("Hello "+name)
}


const typeYourName = (callback) => {
    let name = prompt("Type your name");
    callback(name)
}

typeYourName(hello);
typeYourName(bonjour)