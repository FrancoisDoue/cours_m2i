import React from 'react';
import {Text} from 'react-native';
import mainStyle from './styles/defaultStyle';
import Layout from './components/Layout';
import Calculator from './components/calculator/Calculator';

const App = () => {
    return (
        <Layout>
            <Calculator />
        </Layout>
    );
}


export default App;
