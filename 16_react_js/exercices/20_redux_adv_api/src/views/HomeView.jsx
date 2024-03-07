import React from 'react';
import Layout from '../components/shared/Layout';
import { Outlet } from 'react-router-dom';

const HomeView = () => {
    return (
        <Layout>
            <Outlet />
        </Layout>
    );
}

export default HomeView;
