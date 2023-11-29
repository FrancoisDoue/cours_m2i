export default class Person {

    #firstname;
    #lastname;
    #birthday;

    set setFirstname(firstname) {
        if (typeof firstname == "string")
            this.#firstname = firstname;
    }
    get getFirstname() {
        return this.#firstname
    }
    set setLastname(lastname) {
        if (typeof lastname == "string")
            this.#lastname = lastname;
    }
    get getLastname() {
        return this.#lastname
    }
    set setBirthday(birthday) {
        if (typeof birthday == "string")
            this.#birthday = birthday;
    }
    get getBirthday() {
        return this.#birthday
    }

    constructor(firstname, lastname, birthday) {
        this.#firstname = firstname;
        this.#lastname = lastname;
        this.#birthday = birthday
    }
}