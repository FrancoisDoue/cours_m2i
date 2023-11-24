/**
 * @param {Array} tab 
 * @param {boolean} isInfinite définit le mode de saisie
 */
const registerToTab = (tab, isInfinite) => {
    let promptResult;
    if (isInfinite) {
        while (true) {
            while(true) {
                promptResult = notePromptControl(true);
                if (promptResult < 20) 
                    break;
                alert("Saisie invalide");
            }
            if (promptResult < 0) break;
            tab.push(promptResult);
        }
    } else {
        let limit = Number(prompt("Quelle sera la limite du tableau?"));
        for (let i = 0; i < limit; i++) {
            while (true) {
                promptResult = notePromptControl();
                if (promptResult >= 0 && promptResult <= 20) 
                    break;
                alert("Saisie invalide");
            }
            tab.push(promptResult);
            // tab[i] = promptResult;
        }
    }
}
/**
 * @param {boolean} canQuit 
 * @returns number
 */
const notePromptControl = (canQuit = false) => {
    while (true) {
        let promptUser = Number(prompt(
            `Saisissez une note (entre 0 et 20)${canQuit? "\n[ -n ] : quitter la saisie": ""}`
        ));
        if (!isNaN(promptUser))
            return promptUser;
        alert("Saisie invalide");
    }
}

const menu = () => {
    while (true) {
        const promptUser = Number(prompt(`Choisir un mode de saisie:\n1: Saisie fixe.\n2: Saisie jusqu'à note négative`));
        if (promptUser === 1)
            return registerToTab(tabNote, false);
        if (promptUser === 2)
            return registerToTab(tabNote, true);
        alert("Saisie invalide");
    }
}

let tabNote = [];
let min = 0, max, average;

menu();
for(let element of tabNote){
    if (element < min ) min = element;
    if (element > max ) max = element;
    average += element;
}
element = element/tabNote.length;
console.log(tabNote)