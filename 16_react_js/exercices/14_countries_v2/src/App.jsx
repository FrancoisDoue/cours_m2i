import { useEffect, useState } from 'react'
import HeaderComponent from './components/HeaderComponent'
import CountryDisplay from './components/CountryDisplay'
import api from './services/apiService'

function App() {
  const [countryList, setCountryList] = useState([])
  const [searchResult, setSearchResult] = useState([])

  const searchInResult = (value) => {
    setSearchResult(
      [...countryList.filter(s => s.name.toLowerCase().includes(value))]
    )
  }

  useEffect(() => {
    api.get('/all')
      .then(res => {
        setCountryList(res)
        setSearchResult(res)
      })
  }, [])

  return (
    <>
      <HeaderComponent searchAction={searchInResult}/>
      <CountryDisplay countryList={searchResult}/>
    </>
  )
}

export default App
