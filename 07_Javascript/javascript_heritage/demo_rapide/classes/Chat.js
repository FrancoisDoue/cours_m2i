import Animal from "./Animal.js"

export default class Chat extends Animal {
    constructor (nom, age, jouet) {
        super(nom, age) // appel du constructeur parent
        this.jouet = jouet
    }

    crier() {
        // super.crier()
        console.log(`Miaou. Je m'appele ${this.nom} `)
    }
}