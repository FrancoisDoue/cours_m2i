const isString = (str) => typeof str === "string" && isNaN(Number(str));
const isNumber = (value) => typeof value === "number" && !isNaN(value);
/**
 * @param {callback} attemptedValue 
 * @param {callback} isValid
 * @param {string} msg
 * @param {string} errorMsg
 * @param {Array | undefined} array
 * @returns {string | Number}
 */
const promptControl = (attemptedValue, isValid, msg, errorMsg = 'Erreur de saisie', array) => {
    array = array ?? false;
    let value;
    while(true){
        value = attemptedValue(prompt(msg));
        if (isValid(value)){
            if(array)
                if(searchExactContact(array, value)){
                    alert('Ce contact existe déjà.');
                    continue;
                }
            return value;
        }
        alert(errorMsg);
    }
}
/**
 * @param {Array} list
 * @returns {string}
 */
const showContacts = (list) => list.join("\n");
/**
 * @param {number} sizeOfList
 * @returns {Array}
 */
const addContacts = (sizeOfList) =>{
    let msg = "Ajoutez un contact : ", error = "Saisie invalide", list = [];
    for(let i = 0; i < sizeOfList; i++)
        list.push(promptControl(String, isString, msg, error, list));
    return list;
}
/**
 * @param {Array} list
 * @returns {Array}
 */
const shuffleArray = (list) => {
    const shuffleFn = () => 0.5 - Math.random();
    return list.sort(shuffleFn);
}
/**
 * @param {Array} list
 * @param {string} str - String to match exactly.
 * @param {boolean} isDelete - Toggle deletion
 * @returns {boolean | void}
 */
const searchExactContact = (list, str, isDelete = false) => {
    for (let i = 0; i < list.length; i++) {
        if (list[i] === str){
            if (isDelete) 
                list.splice(i,1);
            else
                return true;
        }
    }
}
const searchContact = (list, regex) => {
    let regTest = new RegExp(regex.toLowerCase(), "g");
    let tab = []
    for (let element of list) {
        if(element.toLowerCase().match(regTest)?.length)
            tab.push(element);
    }
    return tab;
}


const main = () =>{
    let contactList = []
    let msg = "Combien de contact voulez-vous enregistrer?";
    let error = "Saisie invalide : Veuillez taper un nombre";
    let numberOfUsers = promptControl(Number, isNumber, msg, error);
    let selection;
    contactList = addContacts(numberOfUsers);
    /* ---------------------------------------- */
    let menuMsg = "Sélectionnez : \n[1]=> Recommencer sa liste de contact\n[2]=> Afficher les contacts \n[3]=> Trier les contacts \n[4]=> Mélanger les contacts \n[5]=> Supprimer un contact\n[6]=> Rechercher des contacts \n[ 0 ]=> Quitter";
    while(true){
        selection = promptControl(Number, isNumber, menuMsg);
        switch (selection) {
            case 0:
                return;
            case 1:
                numberOfUsers = promptControl(Number, isNumber, msg, error);
                contactList = addContacts(numberOfUsers);
                break;
            case 2:
                alert(showContacts(contactList));
                break;
            case 3:
                contactList.sort();
                alert((showContacts(contactList)));
                break;
            case 4:
                contactList = shuffleArray(contactList);
                alert(showContacts(contactList));
                break;
            case 5:
                let fullName = promptControl(String, isString, "Saisissez le nom du contact à supprimer");
                searchExactContact(contactList, fullName, true);
                alert(showContacts(contactList));
                break;
            case 6:
                let nameSubstr = promptControl(String, isString, "Recherche :");
                alert(showContacts(searchContact(contactList, nameSubstr)))
                break;
            default:
                alert("Saisie invalide")
                break;
        }
    }
}
window.onload = main();