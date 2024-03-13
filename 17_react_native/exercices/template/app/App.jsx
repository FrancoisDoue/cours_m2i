import React from 'react';
import {Text} from 'react-native';
import mainStyle from './styles/defaultStyle';
import Layout from './components/Layout';

const App = () => {

    return (
        <Layout>
            <Text style={mainStyle.textLight}>Replace me</Text>
        </Layout>
    );
}


export default App;
