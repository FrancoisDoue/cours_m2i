import express from "express"

const router = express.Router()

router.get('/', (req, res) => {
    res.send('bienvenue sur la page d\'accueil')
})

export default router;