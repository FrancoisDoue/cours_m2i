import express from "express"
import router from "./src/routes/routes.js"
import env from "./config/env.js"

const app = express()

app.use(router)

app.listen(env.PORT, () => {
    console.log(`Server is listening on port ${env.PORT}`)
})
