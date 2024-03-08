import axios from 'axios'
import { BASE_URL } from '../constants/backendUrl'

const api = axios.create({
    baseURL: BASE_URL, 
    // timeout: 5000,
})

api.interceptors.request.use(
    (config) => {
    //    console.log('config', config)
       return config 
    },
    (error) => Promise.reject(error)
)
api.interceptors.response.use(
    (result) => {
        // console.log(result)
        return {...result.data, headers: {...result.headers}}
    },
    (error) => Promise.reject(error.response)
    
)

export default api