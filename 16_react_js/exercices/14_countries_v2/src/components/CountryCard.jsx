import React from 'react';

const CountryCard = ({data}) => {
    return (
        <div  className='card m-1 mt-4' style={{width: '24rem'}}>
            <img 
                className='card-img-top' 
                src={data.flag} alt={data.name} 
                style={{maxHeight: "12rem", objectFit: 'cover'}}
            />
            <div className='card-body'>
                <h3 className='card-title'>{data.name}</h3>
                <p className='card-text'>Capitale: {data.capital}</p>
                <p className='card-text'>Région: {data.region}</p>
                <p className='card-text'>{data.population} hab.</p>

            </div>
        </div>
    );
}

export default CountryCard;
