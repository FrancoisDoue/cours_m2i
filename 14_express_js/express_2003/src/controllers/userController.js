import userSchema from "../schema/userSchema.js"

export default {
    getManyUsers: (req, res) => {
        userSchema.getManyUsers((err, datas) => {
            if (err) return res.status(500).json(err)
            if (!datas.length) return res.status(404).json({ message: 'Users not found' })
            return res.status(200).json(datas)
        })
    },
    getUser: (req, res) => {
        console.log(req.params.username)


        res.json({ message: 'getUser controller OK' })

    },
    addUser: (req, res) => {
        userSchema.addUser(req.body, (err, datas) => {
            if (err) return res.status(500).json(err)
            return res.status(201).json(datas)
        })
    },

}