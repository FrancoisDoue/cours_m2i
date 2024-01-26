import { Router } from "express";
import book from "../controller/bookController.js";

const bookRouter = Router()

bookRouter.get('/', book.getAllBooks)
bookRouter.get('/:id', book.getBook)

bookRouter.post('/', (reg, res) => res.json({message: 'add a book'}))
bookRouter.put('/', (reg, res) => res.json({message: 'edit a book'}))
bookRouter.delete('/:id', (reg, res) => res.json({message: 'edit a book'}))

export default bookRouter