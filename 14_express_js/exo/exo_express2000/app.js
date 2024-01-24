import express from "express"
import path from "path"
import bookRouter from "./src/routes/bookRoutes.js"

const listHTML = path.resolve(path.join('public', 'list.html'))
const forbidenHTML = path.resolve(path.join('public', 'forbiden.html'))

const app = express()

const routes = express.Router()

app.use(express.static('public'))
app.use(express.json())
app.use('/books', bookRouter)
app.use(routes)
app.listen(3000, () => console.log('Server is listening on port 3000'))

routes.get('/bienvenue', (_req, res) => res.send('<h1>Bienvenue sur Express-2000 (du futur)</h1>'))

routes.get('/api/info', (_req, res) => {
    return res.json({
        message: 'This is a test json response',
        status: 200,
        data: {
            id: 1,
            name: 'François Doué',
            age: 29
        }
    })
})

routes.get('/acces-interdit', (_req, res) => {
    return res.status(403).sendFile(forbidenHTML)
})

routes.get('/redirection-accueil', (_req, res) => res.redirect('/bienvenue'))

routes.get('/liste', (_req, res) => res.sendFile(listHTML))

routes.get('*', (_req, res) => {
    return res.status(404).send('<h2>Cette page du futur n\'existe pas (encore).</h2>')
})
