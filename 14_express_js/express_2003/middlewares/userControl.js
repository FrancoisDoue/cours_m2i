import userSchema from "../src/schema/userSchema.js"

export const beforeLogin = (req, res, next) => {
    if (!req.body?.userEmail) return res.status(403).json({ message: 'Body does not contain email' })
    if (!req.body?.userPassword) return res.status(403).json({ message: 'Body does not contain password' })

    console.log('On middleware emailExistsBeforeLogin')

    userSchema.getUserByMail(req.body.userEmail, (err, datas) => {
        if (err) return res.status(404).json({ message: 'User does not exist' })
        req.body.findedUser = datas
        return next()
    })
}