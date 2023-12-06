import Character from "./character.js";

export default class Warrior extends Character{
    armor;
    constructor(name, maxHp, strenght, armor){
        super(name, maxHp, strenght);
        this.armor = armor;
    }

    get totalLife(){
        return this.hp + this.armor;
    }
    

    attack(target) {
        target.hp -= this.armor;
        super.attack(target);
    }
}