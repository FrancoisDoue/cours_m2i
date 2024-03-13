import React from 'react';
import {Text} from 'react-native';
import mainStyle from './styles/defaultStyle';
import Layout from './components/Layout';
import ContactMain from './components/contacts/ContactMain';

const App = () => {
    
    return (
        <Layout>
            <ContactMain />
        </Layout>
    );
}


export default App;
