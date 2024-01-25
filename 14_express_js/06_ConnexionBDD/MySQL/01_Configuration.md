### Étape 1 : Installation des dépendances

Assurez-vous d'avoir Node.js et npm installés..

```bash
npm install mysql2
```

### Étape 2 : Configuration de la connexion à MySQL

Créez un fichier `db.js` pour gérer la connexion à la base de données, stockez le de préférence dans un dossier `config` :

```jsx
// db.js
const mysql = require('mysql2');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'votre_utilisateur_mysql',
  password: 'votre_mot_de_passe_mysql',
  database: 'votre_base_de_donnees',
});

connection.connect((err) => {
  if (err) {
    console.error('Erreur de connexion à la base de données :', err);
  } else {
    console.log('Connecté à la base de données MySQL');
  }
});

module.exports = connection;

```

### Étape 3 : Mise en place des routes CRUD

Ajoutez les routes pour les opérations CRUD dans `app.js` en utilisant la connexion MySQL définie dans `db.js` :

```jsx
// app.js (suite)
const connection = require('./db');

// Create
app.post('/api/ajouter', (req, res) => {
  const { nom, email } = req.body;
  connection.query('INSERT INTO utilisateurs (nom, email) VALUES (?, ?)', [nom, email], (err, result) => {
    if (err) throw err;
    res.send('Utilisateur ajouté avec succès');
  });
});

// Read
app.get('/api/utilisateurs', (req, res) => {
  connection.query('SELECT * FROM utilisateurs', (err, result) => {
    if (err) throw err;
    res.json(result);
  });
});

// Update
app.put('/api/modifier/:id', (req, res) => {
  const { nom, email } = req.body;
  const userId = req.params.id;
  connection.query('UPDATE utilisateurs SET nom = ?, email = ? WHERE id = ?', [nom, email, userId], (err, result) => {
    if (err) throw err;
    res.send('Utilisateur mis à jour avec succès');
  });
});

// Delete
app.delete('/api/supprimer/:id', (req, res) => {
  const userId = req.params.id;
  connection.query('DELETE FROM utilisateurs WHERE id = ?', [userId], (err, result) => {
    if (err) throw err;
    res.send('Utilisateur supprimé avec succès');
  });
});
```

La fonction `connection.query` est une méthode fournie par le module `mysql` en Node.js pour exécuter des requêtes SQL sur une base de données MySQL. Cette méthode prend en charge la communication asynchrone avec la base de données. Voici comment elle fonctionne :

```jsx
connection.query(sql, values, callback);

```

- `sql`: C'est la requête SQL à exécuter, sous forme de chaîne de caractères. Elle peut contenir des marqueurs de paramètres pour des valeurs dynamiques.
- `values`: C'est un tableau ou un objet qui contient les valeurs à remplacer dans les marqueurs de paramètres de la requête SQL. Cela permet d'éviter les attaques par injection SQL en traitant correctement les valeurs.
- `callback`: C'est une fonction de rappel qui est appelée une fois que la requête a été exécutée. Elle prend deux paramètres : `err` pour une éventuelle erreur et `results` pour le résultat de la requête.

Exemple d'utilisation :

```jsx
const connection = require('./config/db');

// Exemple de requête SELECT
connection.query('SELECT * FROM utilisateurs', (err, results) => {
  if (err) {
    console.error('Erreur lors de l\\'exécution de la requête :', err);
  } else {
    console.log('Résultats de la requête :', results);
  }
});

// Exemple de requête INSERT
const userData = { nom: 'John Doe', email: 'john.doe@example.com' };
connection.query('INSERT INTO utilisateurs SET ?', userData, (err, result) => {
  if (err) {
    console.error('Erreur lors de l\'exécution de la requête :', err);
  } else {
    console.log('Utilisateur ajouté avec succès. ID :', result.insertId);
  }
});

```

Il est important de noter que `connection.query` est asynchrone, ce qui signifie que la fonction de rappel est appelée après l'exécution de la requête. Vous devez donc organiser votre code de manière à gérer cette asynchronie, par exemple en utilisant des promesses, des fonctions de rappel ou des async/await.