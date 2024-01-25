import express from "express"
import { PORT } from "./config/env.js"
import router from "./src/routes/router.js"
import { logger } from "./middlewares/devUtilities.js"

const app = express()

app.use(express.json())
app.use(logger)
app.use(router)

app.listen(PORT, () => {
    console.log(`Server is listening on port: ${PORT}`)
})

// app.get('/api/running_test', (req, res) => {
//     res.json(
//         {message: 'API OK'}
//     )
// })
// app.get('/api/products', (req, res) => 
//     res.json( product.map( p => {
//         return {id: p.id, name: p.name}
//     })
// ))
// app.get('/api/products/:productID', (req, res) => {
//     const id = Number(req.params.productID)
//     const productById = product.find(p => p.id == id)

//     if (productById) return res.status(200).json(productById)
//     return res.status(404).json({message: 'Product not found'})
// })
// app.get('/api/query', (req, res) => {
//     const productName = req.query.name.toLowerCase()
//     console.log(productName)
//     const productsFinded = product.filter(p => p.name.toLowerCase() == productName)
    
//     if(productsFinded) return res.json(productsFinded)
//     return res.status(404).json({message: 'Product not found'})
// })