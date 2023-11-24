let age = Number(prompt("Quel est votre âge"));
let salary = Number(prompt("Quelle sont vos prétention salariales"));
let exp = Number(prompt("Combien d'année d'expérience avez vous sur ce poste"));
let message = "";

if (age < 30) message += "Vous n'avez pas l'âge requis pour le poste. \n";
if (salary > 40000) message += "Vos prétentions salariales sont trop élevées\n";
if (exp < 5) message += "Vous n'avez pas l'expérience requise pour ce poste";

alert(message === "" ? "Félicitation, vous êtes engagé" : message);
