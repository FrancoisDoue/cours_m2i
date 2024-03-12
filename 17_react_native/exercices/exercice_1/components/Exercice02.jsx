import { SafeAreaView, StyleSheet, Text, Button, FlatList, View } from 'react-native'
import React, { useState } from 'react'
import ModalExercice02 from './ModalExercice02'


const Exercice02 = () => {

  const [articleList, setArticleList] = useState([]) 
  const [openModal, setOpenModal] = useState(false)


  const closeModal = () =>  setOpenModal(false)
  const addArticle = (value) => {
    console.log('on addArticle')
    setArticleList([...articleList, {
      id: Date.now(),
      text: value
    }])
  }

  return (
    <SafeAreaView style={styles.mainContainer}>
      <Text style={styles.title}>Ma liste de course</Text>
      <FlatList 
        data={articleList}
        keyExtractor={(_item, index) => index}
        renderItem={({item}) => 
        <View style={styles.itemListView}>
          <Text > {item?.text} </Text>

        </View>
        }
      />
      <Button title={'Ajouter un article'} onPress={() => setOpenModal(true)} />

      <ModalExercice02 
        visible={openModal} 
        actions={{addArticle, closeModal}}
      />
    </SafeAreaView>
  )
}

export default Exercice02

const styles = StyleSheet.create({
  mainContainer : {
    flex: 1,
    padding: 20,
    alignItems: 'center'
  },
  title: {
    fontSize: 40
  },
  titleSecondary: {
    fontSize: 30
  },
  itemListView : {
    width: 200,
    padding: 20
  }
})