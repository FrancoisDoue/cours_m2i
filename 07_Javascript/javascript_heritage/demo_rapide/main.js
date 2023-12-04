import Animal from "./classes/Animal.js";
import Chat from "./classes/Chat.js";

let animal = new Animal("Animal", 3);
let chat = new Chat("Minou", 1, "Ficelle");

animal.crier()
chat.crier()