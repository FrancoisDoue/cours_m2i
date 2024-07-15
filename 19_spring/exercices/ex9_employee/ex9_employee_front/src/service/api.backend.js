import axios from "axios";

const defaultInterceptor = [
    (response) => response.data,
    (error) => Promise.reject({
        code: error.code,
        status: error.response.status,
        url: error.response.config.url,
        message: error.message,
    })
]

export const employeeApi = axios.create({baseURL: "http://localhost:8080/api/employees"})
employeeApi.interceptors.response.use(...defaultInterceptor)

export const candidateApi = axios.create({baseURL: "http://localhost:8080/api/candidates"})
candidateApi.interceptors.response.use(...defaultInterceptor)

export const authApi = axios.create({baseURL: "http://localhost:8080/api/auth"})
authApi.interceptors.response.use(...defaultInterceptor)
// export default {
//     employeeApi,
//     candidateApi
// }