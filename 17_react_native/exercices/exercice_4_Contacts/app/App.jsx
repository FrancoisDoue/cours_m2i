import React from 'react';
import {Text} from 'react-native';
import mainStyle from './styles/defaultStyle';
import Layout from './components/Layout';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native';
import ContactListScreen from './screens/ContactListScreen';
import DetailContactScreen from './screens/DetailContactScreen';

const App = () => {

    const Stack = createNativeStackNavigator()

    return (
        <NavigationContainer>
            <Stack.Navigator initialRouteName='ContactList' >
                <Stack.Screen name='ContactList' component={ContactListScreen} options={{title: 'Vos contacts', headerShown: false}} />
                <Stack.Screen name='ContactDetail' component={DetailContactScreen} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}


export default App;
