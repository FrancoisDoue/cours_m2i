
// const addToArray = (tab, isAuto = true) => {
//     for (let i = 0; i < 10; i++)
//         tab.push(
//             isAuto? 
//             randomIntInRange(1,50): 
//             Number(prompt("Saisissez un nombre à ajouter au tableau"))
//         );
// }
// const showArray = (tab) => {
//     let str = "";
//     for (let int of tab) {
//         console.log(str + int);
//         str+= "\t";
//     }
// } 
// let tab = [];

// addToArray(tab); //addToArray(tab, false) pour une saisie par l'utilisateur
// showArray(tab);

const randomIntInRange = (min, max) => Math.round(Math.random() * (max - min) - min);

let nbrUser = Number(prompt("Quelle sera la taille du tableau?"));
let tab = [];

for (let i = 0; i < nbrUser; i++) {
    tab.push(randomIntInRange(1,50));
}

for (let element of tab) {
    console.log(
        `Le nombre ${element} est ${(element % 2 === 0)?"pair":"impair"}`
    );
}
