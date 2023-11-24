let userNbr = Number(prompt("Saisir nombre :"));
let msg = "", endLog = "", step = 1, loopNbr = userNbr;

for (let cnt = 0; cnt < (userNbr / 2) + 1 ; loopNbr -= ++cnt) {
    if (loopNbr > 0) {
        msg += (cnt !== 0) ? `${cnt} + ` : "";
    } else {
        if (loopNbr === 0) endLog += `${userNbr} = ${msg + cnt}\n`;
        cnt = step++;
        msg = "";
        loopNbr = userNbr;
    }
}
console.log(endLog);

// alert(log);

// fait dans le train pour soigner mon ego
// let msg = "", log = "";
// // let cpt = 0;
// let step = 1;

// let nbrUser = Number(prompt("Saisir nombre :"));
// let testedNbr = nbrUser;
/**
 * A chaque tour, on soustrait cpt à testedNbr
 * S'il tombe pile à 0, on peut ajouter la chaine de charactère au log final
 * ou tout réinitialiser avec un cpt commençant à 2 à la boucle suivante
 */
// while(cpt <= nbrUser/2){ // totalement possible avec une boucle for
//     msg += ++cpt; // incrémentation avant affectation
//     testedNbr -= cpt;

//     if(testedNbr === 0){
//         log += `${nbrUser} = ${msg}\n`;
//         testedNbr = nbrUser;
//         cpt = ++step;
//         msg = "";
//     }else msg += " + ";

//     if(testedNbr < 0){
//         cpt = step++;
//         msg = "";
//         testedNbr = nbrUser;
//     }
// }