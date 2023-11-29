import Person from "./person.js";

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById('form-person');
    const inputList = document.querySelectorAll("form div input");
    const table = document.getElementById('table-result');
    let personList = [];

    form.addEventListener('submit', (e) => {
        e.preventDefault();
        let construct = [], error = false;
        inputList.forEach(input => {
            if (input.value === '') error = true;
            construct.push(input.value);
            //input.value = ''; // reinitialiser les champs
        })
        if(!error){
            const row = table.insertRow()
            let person = new Person(...construct)
            personList.push(person);
            person.getArrayOfProperties().map((e) => {row.insertCell().textContent = e})
            console.log(`${person.getFullName} added to table!`)
            return console.log(personList)
        }
        return console.warn('incomplete form');
    })
})