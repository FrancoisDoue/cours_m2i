import axios from "axios";

const users = axios.create({baseURL: 'https://jsonplaceholder.typicode.com/users'})

users.interceptors.response.use(
    (response) => response.data,
    (error) => {
        console.error(error?.message)
        return Promise.reject(error)
    }
)

export default users