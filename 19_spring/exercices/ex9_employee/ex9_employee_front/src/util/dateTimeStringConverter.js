import dateStringConverter from "./dateStringConverter"

export default (dateTimeToString) => {
    const dateString = dateStringConverter(dateTimeToString)
    let timeString = new Date(dateTimeToString).toLocaleTimeString("fr-FR").substring(0,5)
    return `${dateString} ${timeString}`
}