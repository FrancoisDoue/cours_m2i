import axios from "axios";
import apiKey from "./apiKey";

export const apiLocation = axios.create({
    baseURL: 'http://dataservice.accuweather.com/locations/v1/cities/geoposition/search', 
    params: {apikey: apiKey, Language: 'fr-FR', details: true, toplevel: true}
})

apiLocation.interceptors.response.use(
    (response) => {
        console.log(response.headers)
        return {...response.data, locationKey: response.headers['x-location-key']}
    },
    (error) => Promise.reject(error)
)

export const weather = axios.create({
    baseURL: 'http://dataservice.accuweather.com/forecasts/v1/daily/1day',
    params: {apikey: apiKey, language: 'fr-FR', metric: true}
})

weather.interceptors.response.use(
    (response) => { 
        // console.log(response.data)
        return response.data?.DailyForecasts[0] || Promise.reject('Invalid response schema')
    },
    (error) => Promise.reject(error)
)