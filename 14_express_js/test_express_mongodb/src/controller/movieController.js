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
        console.log(req.params)
        console.log(req.params.title.replace(' ', '_').toLowerCase())
        res.json({msg: 'test'})
    },

    addNewMovie : (req, res) => {
        movieModel.postMovie(req.body, (response) => {
            // if (err) return res.status(500).json({message: 'error'})
            return res.status(201).json({message: 'movie successfully added', 'response': response})
        })
        // return res.json({message: 'On Movie controller'})
    }
}