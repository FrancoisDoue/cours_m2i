import { SafeAreaView, StyleSheet, Text, Button, FlatList, View, Pressable } from 'react-native'
import React, { useState } from 'react'
import ModalExercice02 from './ModalExercice02'


const Exercice02 = () => {

  const [articleList, setArticleList] = useState([]) 
  const [openModal, setOpenModal] = useState(false)

  const closeModal = () =>  setOpenModal(false)
  const addArticle = (value, qty) => {
    setArticleList([...articleList, {
      id: Date.now(),
      text: value,
      quantity: qty,
    }])
  }
  const removeArticle = (article) => {
    if(article.quantity > 1){
      const index = articleList.findIndex(item => item.id === article.id)
      articleList[index].quantity -= 1
      setArticleList([...articleList])
    }else {
      setArticleList(prev => [...prev].filter(item => item.id !== article.id))
    }
  }

  return (
    <SafeAreaView style={styles.mainContainer}>
      <View style={styles.headerContainer}>
        <Text style={[styles.title, styles.textOrange]}>Ma liste de course</Text>
      </View>
      <View style={styles.halfContainer}>
        <FlatList 
          data={articleList}
          ListEmptyComponent={
            <Text style={styles.titleSecondary}>Votre liste est vide</Text>
          }
          keyExtractor={(_item, index) => index}
          renderItem={({item}) => 
            <Pressable style={styles.itemListView} onPress={() => removeArticle(item)}>
              <Text style={[styles.textItem, styles.titleSecondary]}> {item.text} {(item.quantity > 1) && `x ${item.quantity}`} </Text>
            </Pressable>
          }
        />
      </View>
      <View style={styles.quartContainer}>
        <Pressable 
          onPress={() => setOpenModal(true)}
          style={styles.btnOrange}
        >
          <Text style={[styles.titleSecondary, styles.textLight]}>Ajouter un article</Text>
        </Pressable>
      </View>

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
  quartContainer : {
    flex: 1/4,
  },
  headerContainer: {
    flex: 1/6,
    borderBottomWidth: 2,
    borderColor: '#107010'
  },
  halfContainer: {
    flex: 1/2,
    paddingBottom: 10
  },
  title: {
    fontSize: 40,
  },
  textOrange: {
    color: '#107010'
  },
  textLight: {
    color: 'white'
  },
  btnOrange:{
    backgroundColor: '#107010',
    paddingHorizontal: 50,
    paddingVertical: 20,
    borderRadius: 5,
  },
  titleSecondary: {
    fontSize: 30
  },
  textItem: {
    fontSize: 20,
    color: 'white',
    textAlign: 'center'
  },
  itemListView : {
    width: 400,
    padding: 10,
    marginTop: 10,
    borderRadius: 10,
    backgroundColor: '#1AB21A',
    borderWidth: 3,
    borderColor: '#107010'
    
  },
})