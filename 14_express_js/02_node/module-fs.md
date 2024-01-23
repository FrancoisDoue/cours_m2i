# Le module fs

Le module fs (file system) de Node est utilisé pour interagir avec le système de fichiers de l'OS. Il propose des methodes pour effectuer des opérations d'écriture, de lecture, de suppression et de gestion des fichiers et des répertoires. Pour pouvoir être utilisé, il doit être importé.

## Méthodes de base

1. **lecture des fichiers `fs.readFile()`**  
Permet de lire le contenu d'un fichier asynchrone.
```js
fs.readFile("chemin/vers/fichier.ext", 'utf8', (err, data) => {
    if(err) throw err
    console.log(data)
})
```

2. **écriture de fichiers `fs.writeFile()`**  
```js
fs.writeFile("chemin/vers/fichier.ext", "Contenu à écrire",'utf8', (err, data) => {
    if(err) throw err
    console.log('Le fichier a été enregistré')
})
```

3. **Lecture de fichiers synchrone `fs.readFileSync()`**  
On peut également lire un fichier de manière synchrone. Cela bloque l'exécution du reste du code jusqu'à ce que la lecture soit terminée.
```js
const data = fs.readFileSync("chemin/vers/fichier.ext", 'utf8')
console.log(data)
```

4. **Lister les fichiers d'un répertoire `fs.readdir()`**
Permet de lister les fichiers et les répertoires contenu dans un répertoire
```js
fs.readdir('chemin/vers/repertoire/', (err, files) => {
    if (err) throw err
    console.log(files)
})
```

5. **statistiques de fichiers `fs.stat()`**
Donne des information sur un fichier ou un répertoire
```js
fs.stat('chemin/vers/repertoire/', (err, stats) => {
    if (err) throw err
    console.log(stats)
})
```

## Manipulation de répertoires

1. **Création de répertoire `fs.mkdir()`**  
permet de créer un nouveau répertoire
```js
fs.mkdir('chemin/vers/nouveauRepertoire', err => {
    if (err) throw err
    console.log('Done!')
})
```

2. **Suppression de fichiers et répertoires `fs.unlink()` et `fs.rmdir()`**  
```js
fs.unlink('chemin/vers/fichier.ext', err => {
    if (err) throw err
    console.log('Delete!')
})

fs.rmdir('chemin/vers/repertoire', err => {
    if (err) throw err
    console.log('Delete!')
})
```

**Ne pas oublier de gérer les erreurs de manière appropriée lorsque l'on fait des opérations asynchrones**