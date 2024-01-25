import "dotenv/config"
import express from "express"
import path from "path"
import bookRouter from "./src/routes/bookRoutes.js"
import mongoose from "mongoose"
// import connection from "./config/db.js"
// const connect = connection

mongoose.connect('mongodb://localhost:27017/express_2000')
const db = mongoose.connection
db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB'))
db.once('open', () => console.log('Connecté à MongoDB'))

const PORT = process.env.PORT

const listHTML = path.resolve(path.join('public', 'list.html'))
const forbidenHTML = path.resolve(path.join('public', 'forbiden.html'))


const app = express()

const routes = express.Router()

// class User {
//     static getAllUsers() {
//         connect.query('SELECT * FROM users', (e, d) => {
//             if (e) throw e
//             console.log(d)
//         })
//     }
// }


app.set('view engine', 'pug')
app.set('views', path.join('.', 'src', 'views'))

app.use(express.static('public'))
app.use(express.json())
// app.use(express.urlencoded({extended: true}))
app.use('/books', bookRouter)
app.use(routes)
app.listen(PORT, () => console.log(`Server is listening on port ${PORT}`))

routes.get('/', (_req, res) => {
    return res.render('index', {title: 'Bienvenue', mainTitle: "ouaip. C'est un titre"})
})

routes.get('/bienvenue', (_req, res) => {
    return res.render('index', {
        title: 'Bienvenue',
        mainTitle: 'Bienvenue sur Express 2000 (du futur proche)'
    })
})
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
    return res.status(403).render('index', {
        title: "Nope.",
        mainTitle: "Accès interdit",
        img: {
            src: "https://media1.tenor.com/m/x8v1oNUOmg4AAAAd/rickroll-roll.gif",
            alt: "Nope."
        }
    })
})

routes.get('/redirection-accueil', (_req, res) => res.redirect('/bienvenue'))

routes.get('/liste', (_req, res) => {
    const getRoutes = routes.stack.filter(r => {
        return r.route.path !== '*' && r.route.path !== '/'
    }).map(e => e.route.path)
    console.log(getRoutes)
    
    return res.render('index', {
        title: "Plan du site",
        mainTitle: "Plan du site (du futur)",
        ulList: getRoutes
    })
})

routes.get('*', (_req, res) => {
    return res.status(404).render('index', {
        title: "Jipatrouvé", 
        mainTitle: "Pas trouvé.",
        img: {
            src: './img/notfoundenough.jpg',
            alt: "En vrai c'est pas si mal"
        }
    })
})


