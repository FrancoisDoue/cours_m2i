import React from 'react';
import {View, Text, StatusBar, SafeAreaView} from 'react-native';
import mainStyle from '../styles/defaultStyle';
import {displayName} from '../../app.json'

const Layout = ({children}) => {

    return (
        <SafeAreaView style={
            [mainStyle.main, mainStyle.bgDarkPrimary]
        }>
            <StatusBar 
                animated={true}
                backgroundColor={mainStyle.bgDarkPrimary.backgroundColor}
                showHideTransition={'slide'}
                hidden={false}
            />
            <View style={[mainStyle.hXSmall, mainStyle.centerContent]}>
                <Text style={[mainStyle.textLight, mainStyle.title]}>

                    {displayName}

                </Text>
            </View>
            <View style={[mainStyle.hXLarge, mainStyle.bgDarkSecondary]}>
                <View style={[mainStyle.hFull, mainStyle.paddingSM]}>

                    {children}

                </View>


            </View>
        </SafeAreaView>
    );
}


export default Layout;
