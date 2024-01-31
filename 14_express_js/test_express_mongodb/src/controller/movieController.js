import movieModel from "../models/movieModel.js"

export default {
    getAllMovies: (req, res) => {
        console.log(req.query)
        movieModel.getMovies(req.query, (datas) => {
            // if (err) return res.status(500).json({err})
            if (!datas.length) return res.status(404).json({message: 'Movies not found'})
            return res.json(datas)
        })
    },
    getMovieByTitle: (req, res) => {
        console.log(req.params.title)
        movieModel.getOneMovie(req.params.title, (datas) => {
            if (!datas) return res.status(404).json({message: 'Movie not found'})
            return res.json(datas)
        })
    },

    addNewMovie : (req, res) => {
        return movieModel.postMovie(req.body)
        .then(
            datas => res.status(201).json({message: 'movie successfully added', 'response': datas})
        )
        .catch(err => res.status(400).json(err))
}
}