import express from "express";
import { BASE_URL, PRODUCTS_URL } from "../../config/env.js";
import { createProduct, getAllProducts, getProduct, updateProduct } from "../controllers/products.js";

const router = express.Router()

router.get('/', (req, res) => {
    return res.json({
        message: 'API OK',
        status: 200
    })
})

router.get(PRODUCTS_URL, getAllProducts)
router.get(PRODUCTS_URL+'/:id', getProduct)
router.post(PRODUCTS_URL, createProduct)
router.put(PRODUCTS_URL+'/:id', updateProduct)

export default router;