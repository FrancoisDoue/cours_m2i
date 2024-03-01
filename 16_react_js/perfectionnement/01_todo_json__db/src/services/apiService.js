import axios from 'axios'

const api = axios.create({baseURL: 'http://localhost:3000'})

api.interceptors.response.use(
    (response) => console.log(response),
    (error) => console.error(error)
)

export default api