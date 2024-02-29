import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios'
import Markdown from 'react-markdown'

const BookDetail = () => {
    const {olid} = useParams()
    const navigate = useNavigate()
    const [book, setBook] = useState(null)
    const [authors, setAuthors] = useState([])

    useEffect(() => {
        axios.get(`https://openlibrary.org/works/${olid}.json`)
            .then(res => setBook(res.data))
    }, [])
    useEffect(() => {
        if (!!book?.authors) {
            axios.all(book?.authors.map(a => axios.get(`https://openlibrary.org${a.author.key}.json`)))
                .then((res) => setAuthors(res.map((r) => r.data)))
                .catch(e => console.log(e))
        }
    }, [book])

    console.log(book)
    return (
        <main className='container'>
            {!!book ?
            <>
            <div className='m-2'>
                <button onClick={() => navigate('/')} className='btn btn-outline-dark'>Retour à la liste</button>
            </div>
            <hr />
            <div className='row'>
                <div className='col-5 d-flex justify-content-center'>
                {!!book.covers && 
                    <img src={`https://covers.openlibrary.org/b/id/${book?.covers[0]}-L.jpg`} alt={'b'} />
                }
                </div>
                <div className='col-7'>
                    <h2>{book?.title}</h2>
                    <h4>Par 
                    {!!authors && 
                        authors.map(a => (<i key={a.key}> {a?.name} </i>)) 
                    }
                    </h4>
                    {!!book?.first_publish_date && <p> Publié en {book?.first_publish_date}</p>
                    }

                    {!!book?.description && 
                    <Markdown>{`#### *Description* :  \n---  \n${book?.description.value || book?.description}`}</Markdown>
                    }
                </div>

            </div>
            </>
            :
            <h2>Chargement . . .</h2>
            }
        </main>
    );
}

export default BookDetail;
