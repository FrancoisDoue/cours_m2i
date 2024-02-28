import { useEffect, useState } from 'react'
import HeaderComponent from './components/HeaderComponent'
import CountryDisplay from './components/CountryDisplay'
import api from './services/apiService'

function App() {
  const [countryList, setCountryList] = useState([])
  
  const showAllCountries = () => {
    api.get('/all')
    .then(res => setCountryList(res))
  }

  const searchCountry = (value) => {
    if (!!value.length) return getCountryByPartialName(value)
    return showAllCountries()
  }

  const getCountryByPartialName = (value) => {
    api.get(`/name/${value}`).then(res => {
      if (!res) return setCountryList([])
      return setCountryList(res)
    })
  }

  useEffect(showAllCountries, [])

  return (
    <>
      <HeaderComponent searchAction={searchCountry}/>
      <CountryDisplay countryList={countryList}/>
    </>
  )
}

export default App
