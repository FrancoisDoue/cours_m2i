import axios from "axios"

const api = axios.create({baseURL: "http://localhost:3000/api/movies"})

api.interceptors.response.use(
    (res) => {
        // console.log(res)
        return res.data
    },
    (err) => {
        // console.log(err.response)
        return err
    }
)

export default api