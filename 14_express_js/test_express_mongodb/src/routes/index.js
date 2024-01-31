import express from 'express';
import movieController from '../controller/movieController.js';

const router = express.Router()

router.get('/', movieController.getAllMovies)
router.get('/title/:title', movieController.getMovieByTitle)
router.post('/', movieController.addNewMovie)
// router.use('/')

export default router