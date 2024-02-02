import movieModel from "../models/movieModel.js"

export default {
    getAllMovies: (req, res) => {
        console.log(req.query)
        movieModel.getMovies(req.query)
        .then(
            datas => {
                if (!datas) return res.status(404).json({message: 'Movies not found'})
                return res.status(200).json(datas)
            }
        )
        .catch(err => res.status(400).json(err))
    },
    getMovieByTitle: (req, res) => {
        movieModel.getOneMovie(req.params.title)
        .then(
            datas => {
                if (!datas) return res.status(404).json({message: 'Movie not found'})
                return res.status(200).json(datas)
            }
        )
        .catch(err => res.status(400).json(err))
    },

    addNewMovie : (req, res) => {
        return movieModel.postMovie(req.body)
        .then(
            datas => res.status(201).json({message: 'movie successfully added', 'response': datas})
        )
        .catch(err => res.status(400).json(err))
    },
    updateMovie : (req, res) => {
        movieModel.getOneMovie(req.params.title)
        .then((datas) => {
            if (!datas) return res.status(404).json({message: 'Movie not found'}) 
            movieModel.updateMovie(datas.id, req.body)
            .then( (response) =>{
                return res.status(201).json(response)
            })
            .catch((e) => res.status(500).json(e))

        })
        .catch((err) => res.status(500).json(err))
    },
    deleteMovie: (req, res) => {
        movieModel.getOneMovie(req.params.title)
        .then((datas) => {
            
        })
    }
}