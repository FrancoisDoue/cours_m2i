export default class Task {
    #id;
    title;
    detail;
    #createdAt;
    #updatedAt;
    static count = 0;

    constructor(title, detail){
        this.#id = Task.count++;
        this.title = title;
        this.detail = detail;
        this.#createdAt = new Date()
        // this.#updatedAt = this.#createdAt;
    }
    get id(){
        return this.#id
    } 
    #update(){
        this.#updatedAt = new Date();
    }
    editContent = (title, detail) =>{
        this.title = title;
        this.detail = detail;
        this.#update();
    }
    getArrayFromProperties = () => [
        this.title,
        this.detail,
        this.#createdAt.toLocaleString(),
        this.#updatedAt ? this.#updatedAt.toLocaleString() : '--'
    ]
    // #isDone = false
    // set isDone(bool){
    //     this.#isDone = bool;
    //     this.#update()
    // }
    // get isDone() {
    //     return this.#isDone;
    // }
}