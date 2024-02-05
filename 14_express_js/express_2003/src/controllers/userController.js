import userSchema from "../schema/userSchema.js"

export default {
    getManyUsers: (_req, res) => {
        userSchema.getManyUsers((err, datas) => {
            if (err) return res.status(500).json(err)
            if (!datas.length) return res.status(404).json({ message: 'Users not found' })
            return res.status(200).json(datas)
        })
    },
    register: (req, res) => {
        console.log("On register controller")
        userSchema.addUser(req.body, (err, datas) => {
            if (err) return res.status(500).json(err)
            return res.status(201).json(datas)
        })
    },
    login: (req, res) => {
        res.status(200).json({ message: 'Login OK', user: req.body.findedUser })
    },
    update: (req, res) => {
        userSchema.updateUser(req.body, req.params.id, (err, datas) => {
            console.log(err, datas)
            if (err) return res.status(404).json(err)
            return res.status(200).json(datas)
        })
    },
    delete: (req, res) => {
        userSchema.deleteUser(req.params.id, (err, datas) => {
            if (err) return res.status(500).json({ error: err })
            return res.status(200).json({ message: 'User successfully deleted', datas })
        })
    }
}