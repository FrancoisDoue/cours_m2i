import Person from "./person.js";

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById('form-person');
    const inputList = document.querySelectorAll("form div input");
    const table = document.getElementById('table-result');
    let personList = [];

    console.log(inputList);

    form.addEventListener('submit', (e) => {
        e.preventDefault();
        let construct = [], error = false;
        inputList.forEach(input => {
            if (input.value === '') error = true;
            construct.push(input.value);
            // input.value = '';
        })
        if(!error){
            // console.log(table)
            const row = table.insertRow()
            let person = new Person(...construct)
            personList.push(person);
        }
        console.log(personList)
    })

})