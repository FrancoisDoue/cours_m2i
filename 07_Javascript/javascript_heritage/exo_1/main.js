import Character from "./classes/character.js";
import Mage from "./classes/mage.js";
import Warrior from "./classes/warrior.js";

const boss = new Character('Gros Méchant Monstre', 500, 20);
const grudu = new Warrior('Grudu le Barbare', 100, 20, 20);
const gandalf = new Mage('Gandalf', 50, 10, 50);
grudu.attack(boss);
boss.attack(grudu);
gandalf.attack(boss);
boss.attack(grudu);
gandalf.heal(grudu);
