export default (dateToString) => {
    return new Date(dateToString).toLocaleDateString("fr-FR").replaceAll("/", "-")
}