let userNbr = Number(prompt("Position du nombre premier :"));
let divider, testedNbr = 1;
let endLog = "";

while (testedNbr <= userNbr) {
    divider = 3;
    while (true){
        // si la racine carrée du nombre testé est inférieur au diviseur, il n'y aura pas d'autre diviseur
        // (source: mon voisin)
        if(Math.sqrt(testedNbr) < divider){ 
            endLog += testedNbr + "\n"
            break;
        }
        if(testedNbr % divider == 0) break; // si un diviseur est trouvé ce n'est pas un nombre premier
        divider += 2;
    }
    testedNbr += (testedNbr < 3) ? 1 : 2;
};
console.log(endLog)

// =================================================

// do {
//     testedNbr += 2; // 1 n'est pas un nbr premier, les nombres pairs non plus, donc incrémentation de 2 au moins une fois .... (3, 5, 7 ...)
//     divider = 3;
//     while (true){
//         // si la racine carrée du nombre testé est inférieur au diviseur, il n'y aura pas d'autre diviseur
//         if(Math.sqrt(testedNbr) < divider){ 
//             cnt ++;
//             // console.log(testedNbr);
//             break;
//         }
//         if(testedNbr % divider == 0) break; // si un diviseur est trouvé ce n'est pas un nombre premier
//         divider += 2;
//     }

// }while (testedNbr <= userNbr);