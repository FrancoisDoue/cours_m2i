export default class Product {
    #id
    productName = ''
    quantity = 1
    cost = 1
    static cnt = 0

    constructor(productName, quantity, cost) {
        this.#id = Product.cnt
        this.productName = productName
        this.quantity = quantity
        this.cost = cost
    }

    get id() {
        return this.#id
    }
    toString(){
        return `\nNOM: ${this.productName}\nPRIX: ${(this.cost/100).toFixed(2)} €\nQUANTITE: ${this.quantity}\n`
    }

}