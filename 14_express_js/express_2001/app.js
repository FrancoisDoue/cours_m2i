import "dotenv/config"
import express from "express"
import router from "./src/routes/defaultRouter.js"

const PORT = process.env.SERVER_PORT

const app = express()
app.use(express.static('public'))
app.use(express.json())

app.use('/', router)

app.listen(PORT, () => {
    console.log(`Server is listening on port : ${PORT}\nhttp://localhost:${PORT}/`)
})