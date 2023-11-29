export default class Cat {
    #name;
    age;

    constructor(name, age) {
        this.#name = name;
        this.age = age;
    }

    meow() {
        console.log("Grou")
    }
    get getName() {
        return this.#name 
    }
    set setName(name) {
        console.log('name changed')
        return this.#name = name;
    }
}


// export class Chien {
//     name;
//     age;
//     toy;

//     constructor(name, age, toy) {
//         this.name = name;
//         this.age = age;
//         this.toy = toy;
//     }
// }

// export class Chat {
//     name;
//     age;
//     toy;
//     isAwake;

//     constructor(name, age, toy, isAwake) {
//         this.name = name;
//         this.age = age;
//         this.toy = toy;
//         this.isAwake = isAwake ?? Math.random() - 0.5 >= 0;
//     }
// }
