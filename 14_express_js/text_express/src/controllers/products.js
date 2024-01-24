import products from "../../datas/products.js"

export const getAllProducts = ((_req, res) => {
    return res.json(products.map(p => {
        return {id: p.id, name: p.name}
    }))
})

export const getProduct = ((req, res) => {
    const findProduct = products.find(p => p.id == req.params.id)
    if (!findProduct) return res.status(404).json(
        {message: 'Product not found', status: 404}
    )
    return res.json(findProduct)
})

export const createProduct = ((req, res) => {
    const newProduct = {
        'id': products.length + 1,
        'name': req.body.name,
        'price': +req.body.price
    }
    products.push(newProduct)
    return res.status(201).json(newProduct)
})

export const updateProduct = ((req, res) => {
    const productToUpdate = products.find(p => p.id == req.params.id)
    console.log(productToUpdate)
    if (!productToUpdate) return res.status(404).json({message: 'product not found'})
})