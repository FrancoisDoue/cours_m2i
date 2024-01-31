import Movie from "../schemas/movieSchema.js"

export default {
    getMovies: (query, cb) => {
        Movie.find(query).then(cb)
    },
    getOneMovie: (slugMovie) => {
        try {
            return Movie.findOne({slug: slugMovie})
        } catch (e) {
            return e
        }
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