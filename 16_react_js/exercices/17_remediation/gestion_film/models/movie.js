const mongoose = require("mongoose");

const movieSchema = new mongoose.Schema({
  title: { type: String, require: true },
  description: { type: String, require: true },
  director: { type: String, require: true },
  releaseDate: { type: Date, require: true },
});

const Movie = mongoose.model("Movie", movieSchema);

module.exports = Movie;
