import express from 'express';
import movieController from '../controller/movieController.js';
import slugManager from '../../middlewares/slugManager.js';

const router = express.Router()

router.get('/', movieController.getAllMovies)
router.get('/:title', movieController.getMovieByTitle)
router.put('/update/:title', slugManager, movieController.updateMovie)
router.post('/', movieController.addNewMovie)
router.delete('/delete/:title', movieController.deleteMovie)
// router.use('/')

export default router