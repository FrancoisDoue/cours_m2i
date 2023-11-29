export default class Person{
    #id;
    #firstname;
    #lastname;
    #age

    static count = 0;

    constructor(firstname, lastname, age){
        this.#id = ++Person.count;
        this.setFirstname = firstname;
        this.setLastname = lastname;
        this.setAge = +age;
    }
    set setFirstname(firstname) {
        if("string" === typeof firstname)
            this.#firstname = firstname;
    }
    get getFirstname() {return this.#firstname};

    set setLastname(lastname) {
        if("string" === typeof lastname)
            this.#lastname = lastname
    }
    get getLastname() {return this.#lastname};

    set setAge(age) {
        if ("number" === typeof age)
            this.#age = age
    }
    get getAge() {return this.#age};

}