import React from 'react';
import { Link, useOutletContext } from 'react-router-dom';

const BookListDisplay = () => {

    const {bookList} = useOutletContext()

    return (
        <main className='container'>
            <h2 className='text-center mb-4'>Chat.</h2>
            <ul className='list-group'>
            {!!bookList.length && bookList.map(book => 
                <li key={book.key} className='list-group-item'>
                    <div className='row p-2'>
                        <div className='col-2 d-flex justify-content-center'>
                            <img src={`https://covers.openlibrary.org/b/id/${book.cover_id}-M.jpg`} alt={book.title} height={100}/>
                        </div>
                        <div className='col-10'>
                            <h4> {book.title}</h4>
                            <hr />
                            <Link to={book.key}>voir</Link>
                        </div>
                    </div>
                </li>
            )}
            </ul>
        </main>
    );
}

export default BookListDisplay;
