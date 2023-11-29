
const promptControl = (msg, attemptedValue, errorMsg = "Erreur de saisie", array) => {
    const isString = (str) => typeof str === "string" && isNaN(Number(str));
    const isNumber = (value) => typeof value === "number" && !isNaN(value);
    let value;
    array = array ?? false;
    while(true){
        switch (attemptedValue) {
            case "string":
                value = prompt(msg);
                if(isString(value)){
                    if (array && searchExactContact(array, value))
                        errorMsg = "Ce contact existe déjà";
                    else
                        return value; 
                }
            case "number":
                value = Number(prompt(msg));
                if(isNumber(value))
                    return value;
            default:
                alert(errorMsg);
                break;
        }        
    }
}

const showContacts = (list) => list.join("\n");

const addContacts = (sizeOfList) =>{
    let msg = "Ajoutez un contact : ", error = "Saisie invalide", list = [];
    for(let i = 0; i < sizeOfList; i++)
        list.push(promptControl(msg, "string", error, list));
    return list;
}

const shuffleArray = (list) => {
    const shuffleFn = () => 0.5 - Math.random();
    return list.sort(shuffleFn);
}

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
    let numberOfUsers = promptControl(msg, "number", error);
    let selection;
    contactList = addContacts(numberOfUsers);
    /* ---------------------------------------- */
    let menuMsg = "Sélectionnez : \n[1]=> Recommencer sa liste de contact\n[2]=> Afficher les contacts \n[3]=> Trier les contacts \n[4]=> Mélanger les contacts \n[5]=> Supprimer un contact\n[6]=> Rechercher des contacts \n[ 0 ]=> Quitter";
    while(true){
        selection = promptControl(menuMsg, "number");
        switch (selection) {
            case 0:
                return;
            case 1:
                numberOfUsers = promptControl(msg, "number", error);
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
                let fullName = promptControl("Saisissez le nom du contact à supprimer", "string");
                searchExactContact(contactList, fullName, true);
                alert(showContacts(contactList));
                break;
            case 6:
                let nameSubstr = promptControl("Recherche :", "string");
                alert(showContacts(searchContact(contactList, nameSubstr)))
                break;
            default:
                alert("Saisie invalide")
                break;
        }
    }
}
window.onload = main();