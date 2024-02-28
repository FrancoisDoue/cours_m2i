import React from 'react';
import CountryCard from './CountryCard';

const CountryDisplay = ({countryList}) => {
    return (
        <div className='container d-flex flex-wrap mt-4'>
            {!!countryList.length && countryList.map(country => 
                <CountryCard data={country} key={country.key}/>
            )}
        </div>
    );
}

export default CountryDisplay;
