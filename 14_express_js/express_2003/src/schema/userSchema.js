import { Schema, model } from "mongoose";

const userSchema = new Schema({
    username: { type: String, required: true },
    userEmail: { type: String, required: true },
    userPassword: { type: String, required: true}
}, {
    statics: {
        // bon bah s'il faut une rustine pour utiliser le pouvoir du callback...
        async useCB(method, cb) {
            let error, datas
            try {
                datas = await method
            } catch (e) {
                error = e
            }
            return cb(error, datas)
        },
        addUser(body, cb) {
            return this.useCB(this.create(body), cb)
        },
        getManyUsers(cb) {
            return this.useCB(this.find({}, { userPassword: false }), cb)
        },
        getUserByMail(email, cb) {
            return this.useCB(this.findOne({'userEmail': email}), cb)
        },
        updateUser(body, id, cb) {
            return this.useCB(this.findByIdAndUpdate(id, body), cb)
        },
        deleteUser(id, cb) {
            return this.useCB(this.findByIdAndDelete(id), cb)
        }
    }
})

export default model('User', userSchema)