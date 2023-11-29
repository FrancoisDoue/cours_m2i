export default class Task {
    #id;
    title;
    detail;
    #isDone = false
    #createdAt;
    #updatedAt;
    static count = 0;

    constructor(title, detail){
        this.#id = Task.count++;
        this.title = title;
        this.detail = detail;
        this.#createdAt = new Date()
        this.#updatedAt = this.#createdAt;
    }
    #update(){
        this.#updatedAt = new Date();
    }
    set isDone(bool){
        this.#isDone = bool;
        this.#update()
    }
    get id(){
        return this.#id
    } 
    get isDone() {
        return this.#isDone;
    }
    getArrayFromProperties = () => [
        this.title,
        this.detail,
        this.#updatedAt.toLocaleDateString(),
    ]
}