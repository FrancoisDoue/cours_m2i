import axios from "axios";
import {BASE_DB_URL} from '../firebaseConfig'

const api = axios.create({baseURL: BASE_DB_URL})

api.interceptors.response.use(
    (res) => {
        console.log(res)
        return res.data
    },
    (err) => {
        console.error(err.response.data)
        return err
    }
)

export default api