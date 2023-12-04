export default class Character {

    name;
    hp;
    maxHp;
    strength;

    constructor(name, maxHp, strenght){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.strength = strenght;
    }

    attack(target) {
        target.hp -= this.strength;
        console.log(`${this.name} attack ${target.name}\n(${target.name} hp's = ${target.hp})`);
    }

}