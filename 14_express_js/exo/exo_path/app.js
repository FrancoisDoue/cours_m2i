import path from "path";

const pathToRapport = path.join(".", "documents", "rapport.txt")

const absolutePath = path.resolve(pathToRapport)

console.log('chemin relatif :', pathToRapport)

console.log('chemin absolu :', absolutePath)

if (path.extname(absolutePath) === ".txt") console.log('Rapport est bien un fichier .txt')

console.log('le répertoire de rapport.txt est: '+ path.dirname(pathToRapport))

console.log('le nom du fichier est : ' + path.basename(absolutePath, '.txt'))

console.log(path.parse(pathToRapport))

console.log('chemin normalisé (qui change rien): ', path.normalize(pathToRapport))

console.log('chemin normalisé (qui change des trucs): ', path.normalize('./documents/rapport.txt'))

