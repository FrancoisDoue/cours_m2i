import axios from "axios";
import apiKey from "./apiKey";

const api = axios.create({
    baseURL: 'http://dataservice.accuweather.com/locations/v1/cities/geoposition/search', 
    params: {apikey: apiKey}
})

api.interceptors.response.use(
    (response) => {
        console.log(response.data)
        return response.data
    },
    (error) =>  Promise.reject(error)
)

export default api