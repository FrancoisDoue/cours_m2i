export const logger = (req, _res, next) => {
    console.log('params :', req.params)
    console.log('query :', req.query)
    next()
}