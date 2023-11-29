export default class Person{
    #id;
    #firstname;
    #lastname;
    #age;

    static banned = 'Bernard';

    static count = 0;
    constructor(firstname, lastname, age){
        this.#id = ++Person.count;
        this.setFirstname = firstname;
        this.setLastname = lastname;
        this.setAge = +age;
    }
    set setFirstname(firstname) {
        if("string" === typeof firstname && firstname !== Person.banned)
            this.#firstname = firstname;
    }
    set setLastname(lastname) {
        if("string" === typeof lastname)
            this.#lastname = lastname
    }
    set setAge(age) {
        if ("number" === typeof age)
            this.#age = age
    }
    get getFullName() {
        return `${this.getFirstname} ${this.getLastname}`
    }
    /**
     * @returns {Array}
     */
    getArrayOfProperties = () => [
        this.#id,
        this.getFirstname,
        this.getLastname,
        this.getAge
    ]
    get getFirstname() {return this.#firstname};
    get getLastname() {return this.#lastname};
    get getAge() {return this.#age};
}