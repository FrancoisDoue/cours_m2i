import Character from "./character.js";

export default class Mage extends Character{
    maxMana;
    mana;

    constructor(name, maxHp, strenght, maxMana){
        super(name, maxHp, strenght);
        this.maxMana = maxMana;
        this.mana = this.maxMana;
    }

    attack(target){
        target.hp -= Math.floor(this.mana/2);
        this.mana -= 10;
        super.attack(target);
    }

    heal(target){
        target.hp += Math.floor(this.mana/2);
        if(target.hp > target.maxHp) target.hp = target.maxHp;
        this.mana -= 5;
        console.log(`${this.name} healing ${target.name}\n(${target.name} hp's = ${target.hp}) - (${this.name} mana's = ${this.mana})`)
    }
}