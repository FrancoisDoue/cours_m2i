import React from 'react';
import MovieListDisplay from '../components/MovieListDisplay';

const HomeView = () => {
    return (
        <div >
            <h3 className='border-bottom border-start border-primary-subtle p-2 ps-4 m-0'>
                Hey there! Checkout our movies!
            </h3>
            <div className='w-100 pt-4 border-end border-primary-subtle'>
                <MovieListDisplay />
            </div>
        </div>
    );
};

export default HomeView;