import express from "express"
import { writeFile, readFile } from "fs/promises"
import path from "path"
const jsonPath = path.join('datas', 'livres.json')

const livres = async() => JSON.parse(await readFile(jsonPath, {encoding: 'utf-8'}, (e, datas) => {
    if (e) {
        console.log(e)
        return
    }
    return datas
}))

const bookRouter = express.Router()

bookRouter.get('/', async(_req, res) => {
    // console.log(await livres())
    return res.json(await livres())
})

bookRouter.get('/:id', async(req, res) => {
    const list = await livres()
    return res.json( list.find(l => l.id == req.params.id) )
})

bookRouter.post('/add', async(req, res) => {
    const list = await livres()
    const newBook = {
        id: list.length + 1,
        titre: req.body?.titre,
        auteur: req.body?.auteur
    }
    try{
        list.push(newBook)
        console.log(list)
        await writeFile(jsonPath, JSON.stringify(list), e => {
            if (e) return
        })
    }catch(e){
        console.log(e)
        return res.status(500).json({message: 'error'})
    }
    return res.status(201).json(newBook)
})

bookRouter.get("/search/auteur/:name", async(req, res) => {
    // filter improvement for url : /books/search/auteur/j_r_r__tolkien
    const regReplacer = /[ -\.]/gi
    const filteredList = (await livres()).filter(l => {
        const author = l.auteur.toLowerCase().replaceAll(regReplacer, '_')
        return author == req.params.name
    })
    return res.json(filteredList)
})

export default bookRouter;