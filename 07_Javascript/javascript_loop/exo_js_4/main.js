let temperature = Number(prompt('Quelle est la température de l\'eau?'))
let message = `A ${temperature}°C l'eau est `

message = temperature < 0 ? 
    message+="solide" : 
    temperature >= 100 ?
        message+="vaporisée":
        message+="liquide";

alert(message)
// if(temperature < 100 && temperature > 0){
//     message+="liquide"
// }else if (temperature >= 100) {
//     message += "vaporisée"
// }else{
//     message += "solide"
// }