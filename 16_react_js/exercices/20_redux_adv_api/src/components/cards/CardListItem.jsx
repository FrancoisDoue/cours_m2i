import React from 'react';
import frenchMap from '../../services/frenchMap';

const CardListItem = ({card}) => {

    // console.log(frenchMap(card))

    // try to find card name's in french
    const name = (card?.foreignNames?.find(n => n.language == 'French'))?.name || card.name
    // console.log(card)
    return (
        <div className='card bg-dark border-light m-2 shadow-sm text-light' style={{maxWidth: '250px'}}>
            <div className='card-header border-light p-0 text-center'>
                <img src={card.imageUrl} alt={card.name} width={248} className='rounded-4'/>

            </div>
            <div className='card-content text-center'>
                <h6 className='card-title border-bottom'>
                    <strong>{name}</strong>
                </h6>
                <div className='row'>
                    <p>Type: {card.type}</p>
                    <p className='col-6'>Rareté: <strong>{card.rarity}</strong></p>
                    <p className='col-6'>Edition: <strong>{card.setName}</strong></p>
 
                </div>
                
            </div>
            <div className='card-footer border-light'>
                <button className='btn btn-outline-light py-0'>
                    Voir
                </button>
            </div>
        </div>
    );
};

export default CardListItem;