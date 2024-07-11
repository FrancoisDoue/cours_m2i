import React from 'react';
import { Link, Outlet } from 'react-router-dom';

const Layout = () => {
    return (
        <div
            style={{ maxWidth: '100dvw', minHeight: '100dvh' }}
            className='d-flex flex-column justify-content-between bg-light'
        >
            <header className="p-3 mb-3 border-bottom bg-body shadow-sm">
                <div className="container">
                    <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                        <Link to={'/'} className="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                            <h2>COGIP</h2>
                        </Link>
                        <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 ms-4 justify-content-center mb-md-0">
                            <li><Link to={"/employees"} className="nav-link mx-2 px-2 link-secondary">Gestion du personnel</Link></li>
                            <li><Link to={"/candidates"} className="nav-link mx-2 px-2 link-secondary">Recrutement</Link></li>
                        </ul>

                        <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                            <input type="search" className="form-control" placeholder="Recherche..." aria-label="Search" />
                        </form>
                    </div>
                </div>
            </header>
            <main className='flex-fill d-flex'>
                <div className='container flex-fill d-flex flex-column'>
                    <Outlet />
                </div>
            </main>
        </div>
    );
}

export default Layout;
