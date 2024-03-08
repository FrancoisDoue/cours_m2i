export default (card) => {
    // console.log(card)
    const name = (card?.foreignNames.find(n => n.language == 'French'))?.name || card.name
    const frenchDetails = card?.foreignNames.find(n => n.language == 'French') || {}
    // console.log(frenchDetails)


    return {...frenchDetails}
}