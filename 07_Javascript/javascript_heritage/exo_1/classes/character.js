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

    get totalLife() {
        return this.hp 
    }

    attack(target) {
        if(target.armor && target.armor > 0) {
            target.hp -= Math.floor(this.strength/2);
            target.armor -=  Math.floor(this.strength/2);
            console.log(`${target.name}'s armor decreased to ${target.armor}`)
        }else 
            target.hp -= this.strength;
        console.log(`${this.name} attack ${target.name}\n(${target.name}'s hp = ${target.hp})`);
    }

}