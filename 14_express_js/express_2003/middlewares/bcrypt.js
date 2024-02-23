import bcrypt from 'bcrypt'

const saltRounds = 10

export const hashPassword = (req, res, next) => {
    if (req.body?.userPassword) {
        bcrypt.genSalt(saltRounds, (_e, salt) => {
            bcrypt.hash(req.body.userPassword, salt, (error, hash) => {
                if (error) return res.status(500).json({ 'error': "Something went wrong with hash", error })
                req.body.userPassword = hash
                return next()
            })
        })
    } else next()
}

export const comparePassword = (req, res, next) => {
    bcrypt.compare(req.body.userPassword, req.body.findedUser.userPassword, (err, result) => {
        if (err) return res.status(500).json({ 'error': "Something went wrong with compare", err })
        if (!result) return res.status(403).json({ message: "Invalid password" })
        else return next()
    })
}