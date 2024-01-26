import { Router } from "express";
import bookRouter from "./bookRouter.js";

const router = Router()

router.use('/book', bookRouter)

router.get('/', (req, res) => res.send('home'))

export default router