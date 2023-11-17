// // let body = document.getElementsByTagName("body")[0]
// // let title = document.createElement("h1")
// // title.textContent = "H.0"
// // body.appendChild(title)
// // console.log(title.ariaValueText)
// function addElement(tag, content = "", parent = null){
//     let newTag = document.createElement(tag);
//     newTag.textContent = content;
//     if(typeof parent === "string"){
//         let parentCollection = document.getElementsByTagName(parent)
//         if(parentCollection.length){
//             for (let i = 0; i < parentCollection.length; i++) {
//                 parentCollection[i].appendChild(newTag);
//             }
//         }else{
//             console.warn("HTML element not found");
//         }
//     }
// }
// // console.log(typeof document.getElementsByTagName("body")[0] == "object")
// // console.log(typeof "help" == "string")
// // console.log(document.getElementsByTagName("body")[0])
// addElement("h1", "test", "body");
// addElement("p", addElement("div", "", "body"), "div");
// addElement("p", "test test test test ","div")
console.log(+'0.1A')