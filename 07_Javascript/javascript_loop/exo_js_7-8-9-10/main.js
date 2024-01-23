// console.log("Je commence à compter");
// for(let i = 1; i <= 10; i++) console.log(i);
// console.log("J'ai fini de compter")

// let message = "Table des matières:\n"
// for(let chapitre = 1; chapitre < 4; chapitre ++){
//     message+= `    Chapitre ${chapitre}\n`
//     for(let part = 1; part < 4; part++){
//         message += `        - partie ${chapitre}.${part}\n`
//     }
// }
// alert(message)

// let nbrUser = Number(prompt("Saisissez un nombre"));
// let message = "";

// for (let i = 1; i <= nbrUser; i++){
//     message += `Table des ${i} :\n`;
//     for (let mult = 1; mult <= 10; mult++) message += `${i} x ${mult} = ${i*mult}\n`;
//     message+= "- - - - - - - -\n"
// }
// alert(message);



// let pStart;
// let temp;
// let messageA = "", messageB = "", tableContent = "", separator = "";

// let nbrUser = Number(prompt("Saisissez un nombre"));
// let nbrPadding = Number(prompt("Saisissez le padding désiré (min 3) :"))

// if (nbrPadding < 3) nbrPadding = 3;

// for (let i = 1; i <= nbrUser; i++){
//     pStart = nbrPadding+(i.toString().length);
//     messageA += `|${i.toString().padStart(pStart)} `;

//     for (let mult = 1; mult <= nbrUser; mult++) {
//         pStart = nbrPadding+(mult.toString().length);
//         temp = `|${(mult*i).toString().padStart(pStart)} `;
//         separator += "+" + "-".repeat(temp.length-1);
//         messageB += temp;
//     }

//     tableContent += messageB+"|\n"+separator+ "+\n";
//     separator = "";
//     messageB = "";
// }
// messageA += "|";
// messageA = messageA + "\n".padEnd(messageA.length, "=");
// console.log(messageA+ "\n" + tableContent+ "\n");

// ===================================================== //

// let tree = Number(prompt("La taille du bô sapin (min 10 (sinon c'est moche)): "));
// let foot = Number(prompt("La longueur du pied du bô sapin (min 1)"));

// let msg = "", greenStar = "\x1B[32m*", strFoot = "|    |";
// let temp;

// const getRandomNbr = (max = 5, min = 0) =>{ return Math.round(Math.random() * (max - min) + min) };

// if (tree < 10 ) tree = 10;
// if (foot < 1) foot = 1;

// for (let i = 1; i <= tree+1; i++) {
//     if(i === 1){ 
//         temp = "\x1B[33mA";
//     } else {
//         // il faut i*2 - 2 caractère sur une ligne (exemple pour la 3ème ligne, il me faut 3*2 - 2 = 5 caractères)
//         for(let j = 0; j < (i*2 - 2) ; j++){
//             // getRandomNbr() >= 4 |==> on veut que 2/5 caractères des 0 colorés
//             temp += (getRandomNbr() >= 4) ? `\x1B[${getRandomNbr(96,91)}m0` : greenStar;
//         }
//     }

//     temp = temp.padStart((tree-i+1)+temp.length); //adaptation du padding pour aligner l'ensemble
//     msg += temp + "\n";
//     temp = greenStar; // une étoile verte est affectée à temp pour la prochaine itération
// }
// for (let i = 0; i < foot; i++){
//     // incrémentation du message finale + adaptation du padding
//     msg += "\x1B[31m" + strFoot.padStart(Math.round(tree + strFoot.length/2)) + "\n";
// }
// // le bô sapin. Crucial.
// msg += '\u25A0 Le bô sapin. \u25A0'.padStart(tree + 8);

// console.log(msg);


// -----------------------------------------------------------------------

// let maxH = 400;
// let e = 0.0001;
// let cpt = 0;

// while(e < 400){
//     e += e
//     cpt++
// }
// console.log(`Il faut replier la feuille de papier ${cpt} fois pour atteindre 400 m\n Il faudrait peut-être louer un tractopelle`)

// ------------------------------------------------------------------------

// let population = Number(prompt("Quelle est la population initiale ? :"));
// let txAccroissement = Number(prompt("Quelle est le taux d'accroissement (en %) ? :"));
// let targetPop = Number(prompt("Quelle est la taille de population visée? :"));
// let cpt = 0;

// while(population < targetPop){
//     population += population*(txAccroissement/100);
//     cpt++;
// }

// console.log(`Il faudre ${cpt} ans pour atteindre une population de ${targetPop} (${Math.round(population)})`)

// ------------------------------------------------------------------------

// let nbrUser = Number(prompt("Saisissez un nombre entier"));
// let tempNbr = 0
// let msg = ""
// let cpt = 1

// for(let i = 1; i < nbrUser; i++){
//     if (nbrUser === tempNbr){
//         console.log(msg)
//     }

//     msg +=  i + " + "
//     if(tempNbr >= nbrUser){
//         tempNbr = 0
//         i = ++cpt
//         // console.log(i)
//         msg =  i + " + ";
//     }
//     tempNbr += i;

//     // console.log(msg)
//     // console.log(tempNbr)
// }