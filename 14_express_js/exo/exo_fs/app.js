import fs from "fs"
import path from "path"

const newDir = "nouveau_repertoire"
const newFile = "nouveau_fichier.txt"
const newText = "Contenu du fichier à écrire."

const newPath = path.join(newDir, newFile)

await (async() => fs.mkdir(newDir, (e) => {
    if (e) {
        console.log(e)
        return
    }
    console.log('directory created')
}))()
await (async() => fs.writeFile(newPath, newText, 'utf-8', (e) => {
    if (e) {
        console.log(e)
        return
    }
    console.log('file created and writed')
}))()
await (async() => fs.readFile(newPath, 'utf-8', (e, data) => {
    if (e) {
        console.log(e)
        return
    }
    console.log(data)
}))()
await (async() => fs.readdir('./', (e, files) => {
    if (e) {
        console.log(e)
        return
    }
    console.log(files)
}))()
await (async() => fs.unlink(newPath, e => {
    if(e) throw e
    console.log('file deleted')
}))()
await (async() => fs.rmdir(newDir, e => {
    if(e) throw e
    console.log('directory deleted')
}))()

// fs.mkdir(newDir, (e) => {
//     if (e) {
//         console.log(e)
//         return
//     }
//     console.log('directory created')
//     fs.writeFile(newPath, newText, 'utf-8', (e) => {
//         if (e) {
//             console.log(e)
//             return
//         }
//         console.log('file created and writed')
//         fs.readFile(newPath, 'utf-8', (e, data) => {
//             if (e) {
//                 console.log(e)
//                 return
//             }
//             console.log(data)
//         })
//         fs.unlink(newPath, e => {
//             if(e) throw e
//             console.log('file deleted')
//             fs.readdir('./', (e, files) => {
//                 if (e) {
//                     console.log(e)
//                     return
//                 }
//                 console.log(files)
//                 fs.rmdir(newDir, e => {
//                     if(e) throw e
//                     console.log('directory deleted')
//                 })
//             })
//         })
//     })
// })

// if(! fs.existsSync(newDir)) {
//     fs.mkdir(newDir, e => {
//         if(e) throw e
//         console.log('Repertory created')
//     })
// }
// if (! fs.existsSync(newPath)) {
//     fs.writeFile(newPath, newText, 'utf-8', err => {
//         if(err) throw err
//         console.log('File created')
//     })
//     fs.readFile(newPath, 'utf-8', (e, text) => {
//         if(e) throw e
//         console.log(text)
//     })
// }


// if (fs.existsSync(newPath)) {
//     fs.unlink(newPath, (e) => { if(e) throw e} )
// }
// console.log(fs.readdir(newDir, e => {console.log(e)}))
