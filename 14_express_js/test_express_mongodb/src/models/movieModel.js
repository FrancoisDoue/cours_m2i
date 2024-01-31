// import mongoose from "mongoose"
import Movie from "../schemas/movieSchema.js"

export default {
    getMovies: (query, cb) => {
        Movie.find(query).then(cb)
    },
    getOneMovie: (slugMovie, cb) => {
        Movie.findOne({title: slugMovie}).then(cb)
    },

    postMovie: (values, cb) => {
        // console.log('On model movie')
        const newMovie = new Movie(values)
        Movie.create(values).then(cb)
    }
}