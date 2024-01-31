import Movie from "../schemas/movieSchema.js"

export default {
    getMovies: (query, cb) => {
        Movie.find(query).then(cb)
    },
    getOneMovie: (slugMovie, cb) => {
        Movie.findOne({slug: slugMovie}).then(cb)
    },

    postMovie: (values) => {
        try {
            const newMovie = new Movie(values)
            return newMovie.save()
        } catch (err) {
            return err
        }
    }
}