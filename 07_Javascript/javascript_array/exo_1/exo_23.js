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
                if (promptResult <= 20) // faudrait que je trouve un moyen de refacto notePromptControl()
                    break;
                alert("Saisie invalide");
            }
            if (promptResult < 0)
                break;
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
    alert("Fin de la saisie.");
}
/**
 * @param {boolean} canQuit 
 * @returns number
 */
const notePromptControl = (canQuit = false) => {
    while (true) {
        let promptUser = Number(prompt(
            `Saisissez une note (entre 0 et 20)${canQuit? "\n[ Nbr négatif ] : quitter la saisie": ""}`
        ));
        if (!isNaN(promptUser))
            return promptUser;
        alert("Saisie invalide");
    }
}

const main = () => {
    let tabNote = [];
    let min, max, average;
    let endMessage = '';
    while (true) {
        const promptUser = Number(prompt(`Choisir un mode de saisie:\n1: Saisie fixe.\n2: Saisie jusqu'à note négative`));
        if (promptUser === 1){
            registerToTab(tabNote, false);
            break;
        }
        if (promptUser === 2){
            registerToTab(tabNote, true);
            break;
        }
        alert("Saisie invalide");
    }
    min = Math.min(...tabNote);
    max = Math.max(...tabNote);
    average = (tabNote.reduce((accumulator, value) => accumulator + value, 0) / tabNote.length).toFixed(2);

    endMessage = `La note maximale est ${max}/20\nLa note minimale est ${min}/20\nLa moyenne de la classe est ${average}/20`;
    alert(endMessage);
}
window.onload = main()
