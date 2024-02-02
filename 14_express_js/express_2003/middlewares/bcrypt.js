import bcrypt from 'bcrypt'

const saltRounds = 10

export const hashPassword = (req, res, next) => {
    bcrypt.genSalt(saltRounds, (_e, salt) => {
        bcrypt.hash(req.body.userPassword, salt, (error, hash) => {
            if (error) return res.status(500).json({'error': "Something went wrong with hash", error})
            req.body.userPassword = hash
            return next()
        })
    })
}

// export const comparePassword = (req, res, next) => {

// }