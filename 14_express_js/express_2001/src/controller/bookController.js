export default {

    getAllBooks: (req, res) => {
        return res.json({message: 'get books'})
    },

    getBook: (req, res) => {
        return res.json({message: `get book with id ${req.params.id}`})
    }
}