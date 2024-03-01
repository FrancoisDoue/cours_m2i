const express = require("express");
const movieController = require("../controllers/movieController");

const router = express.Router();

router.get("/", movieController.getAllMovies);
router.get("/:title", movieController.getMovieByTitle);
router.post("/add-movie", movieController.addMovie);
router.put("/update-movie/:id", movieController.updateMovie);
router.delete("/delete-movie/:id", movieController.deleteMovie);

module.exports = router;
