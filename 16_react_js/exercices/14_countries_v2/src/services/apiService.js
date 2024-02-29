import axios from 'axios'

const api = axios.create({baseURL: 'https://restcountries.com/v3.1'})

api.interceptors.response.use(
    (res => {
        return res.data.map((r, i) => {
            return {
                key: i,
                name: r.translations.fra.common,
                capital: r.capital,
                region : r.region,
                population : r.population,
                flag: r.flags.png
            }
        })
    }),
    (err => console.error(err))
)

export default api