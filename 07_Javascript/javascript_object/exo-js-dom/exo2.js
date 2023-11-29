document.addEventListener('DOMContentLoaded', () => {
    const inputFirstName = document.getElementById("inputFirstName");
    const inputLastName = document.getElementById("inputLastName");
    const inputBirthday = document.getElementById("inputBirthday");
    const submitBtn = document.getElementById("submitButton");
    const tableBody = document.getElementById("tableBody");

    let id = 0;

    submitBtn.addEventListener('click', (event) => {
        console.log(event);
        const userObject = {
            id: ++id,
            firstName : inputFirstName.value,
            lastname : inputLastName.value,
            birthday : inputBirthday.value,
        };
        const row = tableBody.insertRow();
        for (const element in userObject) {
            const col = row.insertCell();
            col.textContent = userObject[element]
        }
    })
})
// /**
//  * 
//  * @param {object} obj 
//  * @param {Node} target 
//  */
// const addRowToTable = (obj, target) => {
//     const row = document.createElement("tr");
//     target.appendChild(row);
//     console.log(row)
//     for (const element in obj) {
//         const col = document.createElement("td");
//         col.textContent = obj[element];
//         row.appendChild(col);
//     }
// }

// document.addEventListener('DOMContentLoaded', () => {
//     const inputFirstName = document.getElementById("inputFirstName");
//     const inputLastName = document.getElementById("inputLastName");
//     const inputBirthday = document.getElementById("inputBirthday");
//     const submitBtn = document.getElementById("submitButton");
//     const tableBody = document.getElementById("tableBody");

//     let id = 0;

//     submitBtn.addEventListener('click', () => {
//         input = [inputFirstName, inputLastName, inputBirthday];
//         const userObject = {};
//         userObject.id = ++id;
//         for (const element of input){
//             if (element.value)
//                 userObject[element.name] = element.value;
//             else {
//                 id --;
//                 return console.warn("error");
//             }
//         }
//         addRowToTable(userObject, tableBody);
//     })
// })