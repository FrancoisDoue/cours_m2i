// const ask = (question = "Do you agree?") => confirm(question) ? alert("You agreed."): alert("You canceled the execution.");

// // ask('sure?');
/********************************************************************* */

const exerciseSoustraction = () => {
    function soustraire(a, b){
        console.log(`Je soustrais ${b} à ${a}`);
        return a-b;
    }
    console.log(soustraire(2,"1"))
}

const exerciseHeure = () => {
    function quelleHeure(str = "12h00") {
        console.log(`Il est ${str}`);
    }
    quelleHeure();
    quelleHeure("00h00");
}

const exercisePalindrome = () => {
    const isPalindrome = (str) => {
        str = str.trim().toLowerCase()
        for (let index = 0; index < str.length/2; index++)
            if (str[index] !== str[str.length-index-1]) return false;
        return true;
    }
    alert(isPalindrome(prompt("Saisissez un mot pour vérifier s'il est un palindrome")))

}


/********************************************************************* */
const exercisesCountA = () => {
    const countChar = (str, letter = "a") =>{
        let cnt = 0;
        str = str.trim().toLowerCase()
        for (let i = 0; i < str.length; i++) {
            if(str[i] == letter) cnt++;
        }
        return cnt;
    }
    alert(countChar(prompt("Saisissez un mot ou une phrase :").trim()))
}

/***************************************************************** */

// version corrigée: 
//     ajout d'une condition pour gérer le null.
//     retrait de la musique des experts.

const exerciseAdn = () => {
        const REGEX_IS_ADN = /[^=acgt]/g

    const promptControl = (msg, reg = REGEX_IS_ADN) => {
        let str = prompt(msg).toLowerCase();
        if (reg.test(str) || str == "" ) 
            return promptControl("Erreur de saisie");
        return str;
    }
    const matchADN = (adn, seq) => {
        let regSeq = new RegExp(seq, "g");
        // if (adn.match(regSeq) === null) return `Aucune correspondance trouvée pour "${seq}" dans la chaîne "${adn}"`
        let result = ((adn.match(regSeq)) ? adn.match(regSeq)[0].length : 0) *100/adn.length;
        return `Il y a ${Math.round(result*100)/100}% de "${seq}" dans la chaîne "${adn}"`;
    }

    let stringAdn = promptControl("Saisir la chaîne");
    let seqAdn = promptControl("Saisir la séquence");

    alert(matchADN(stringAdn, seqAdn));
}

const menu = () =>{
    while(true){
        let choice = prompt(
            `Choix de l'exercice :
            ======================
            [ 0 ] - Quitter
            [ 1 ] - Soustraction
            [ 2 ] - Heure
            [ 3 ] - Palindrome
            [ 4 ] - Compter A
            [ 5 ] - ADN`
        )
        switch (choice) {
            case "0":
                return;
            case "1":
                exerciseSoustraction()
                break;
            case "2":
                exerciseHeure()
                break;
            case "3":
                exercisePalindrome()
                break;
            case "4":
                exercisesCountA()
                break;
            case "5":
                exerciseAdn()
                break;    
            default:
                alert("Saisie invalide")
                break;
        }
    } 
}
menu();