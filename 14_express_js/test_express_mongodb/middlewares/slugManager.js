export default (req, _res, next) => {
    if(!req.body?.title) return next()
    req.body.slug = req.body.title.toLowerCase().replaceAll(' ', '_')
    next()
}