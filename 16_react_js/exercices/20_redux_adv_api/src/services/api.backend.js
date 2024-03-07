import axios from 'axios'
import { BASE_URL } from '../constants/backendUrl'

const api = axios.create({
    baseURL: BASE_URL, 
    // timeout: 5000,
})

// api.interceptors.request.use(
//     (resolve) => console.log(resolve),
//     (reject) => console.error(reject)
// )
api.interceptors.response.use(
    (result) => {
        console.log(result.data)
        return result.data
    },
    (error) => {
        console.log(error)
        return error
    }
)

export default api