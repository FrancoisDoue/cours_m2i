import { Schema, model } from "mongoose";

const userSchema = new Schema({
    username: { type: String, required: true },
    userEmail: { type: String, required: true },
    userPassword: { type: String, required: true}
}, {
    statics: {
        // bon bah s'il faut une rustine pour pouvoir utiliser le pouvoir du callback...
        async forceCB(method, cb) {
            let error, datas
            try {
                datas = await method
            } catch (e) {
                error = e
            }
            return cb(error, datas)
        },
        addUser(body, cb) {
            return this.forceCB(this.create(body), cb)
        },
        getManyUsers(cb) {
            return this.forceCB(this.find({}, { userPassword: false }), cb)
        },
        getUserByMail(email, cb) {
            return this.forceCB(this.findOne({'userEmail': email}), cb)
        }
    }
})

export default model('User', userSchema)