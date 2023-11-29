// Pour pouvoir utiliser la classe Animal, on va l'importer
import Animal from "./animal.js";

// On instancie un tableau d'animaux vide
const animals = [];

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("animal-form").addEventListener("submit", (event) => {
    event.preventDefault();

    // On créé un nouvel animal à partir des champs de notre formulaire
    const newAnimal = new Animal(
      document.getElementById("name").value,
      document.getElementById("breed").value,
      +document.getElementById("age").value
    );

    // ON ajoute l'animal au listing
    animals.push(newAnimal);

    // On réalise la partie visuelle via ajout d'un <tr> à notre <tbody> comme vu précédemment
    const tBodyEl = document.getElementById('animal-result')

    const TREl = document.createElement('tr')

    for(const key in newAnimal) {
      const TDEl = document.createElement('td')
      TDEl.textContent = newAnimal[key]
      TREl.appendChild(TDEl)
    }

    tBodyEl.appendChild(TREl)
  });
});
