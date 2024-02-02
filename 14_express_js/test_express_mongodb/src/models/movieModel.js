import Movie from "../schemas/movieSchema.js"

export default {
    getMovies: (query) => {
        try {
            return Movie.find(query)
        } catch (e) {
            return e
        }
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
    },
    updateMovie: (id, body) => {
        try {
            return Movie.findByIdAndUpdate(id, body)
        } catch (e) {
            return e
        }
    },
    deleteMovie: (id) => {
        try {
            return Movie.findByIdAndDelete(id)
        }catch (e) {
            return e
        }
    }
    
}