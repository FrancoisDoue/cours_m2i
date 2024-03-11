import { SafeAreaView, StyleSheet, Text, View, Button, FlatList } from 'react-native'
import React, { useState } from 'react'
import ModalExercice02 from './ModalExercice02'


const Exercice02 = () => {

  const [articleList, setArticleList] = useState([]) 
  const [openModal, setOpenModal] = useState(false)


  const closeModal = () =>  setOpenModal(false)
  const addArticle = () => {
    console.log('addArticle')
  }

  return (
    <SafeAreaView style={styles.mainContainer}>
      <Text style={styles.title}>Ma liste de course</Text>
      <FlatList 
        data={articleList}
        keyExtractor={(_item, index) => index}
        renderItem={({item}) => 
          <Text > {item?.text}, id: {item?.id} </Text>
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
})