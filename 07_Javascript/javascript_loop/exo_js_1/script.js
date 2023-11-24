// let fName = prompt('Entrez votre prénom:');
// let lName = prompt('Entrez votre nom:');

// alert(`Bienvenue chez vous, ${fName} ${lName} .`);
// console.log(`Bienvenue chez vous, ${fName} ${lName} .`);

const label = document.getElementById('enonce');
const input = document.getElementById('result');
const validBtn = document.getElementById('validBtn');

function randomNumber(max = 100){
    return (Math.floor(Math.random()*max));
}
function setLabelValue(value1, value2){
    label.innerText = `${value1} + ${value2} = `;
}
const resetGame = () =>{
    validBtn.innerText = 'Valider';
    input.style.borderColor = 'lightgrey'
    input.value = '';
    gameStart();
}
const gameStart = () => { 
    let nbr1 = randomNumber(10);
    let nbr2 = randomNumber(10);
    setLabelValue(nbr1, nbr2);

    validBtn.onclick = () => {
        let userResult = +input.value;
        if (validBtn.innerText != 'Suivant'){

            if(nbr1 + nbr2 === userResult) {
                input.style.borderColor = "green";
            } else{
                input.style.borderColor = "red";
            }
            validBtn.innerText = 'Suivant';
            console.log("Bravo, tu sais compter")
        }else{
            resetGame()
        }
    }
}
gameStart();
