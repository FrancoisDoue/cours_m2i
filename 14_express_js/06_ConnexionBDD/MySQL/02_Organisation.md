# Organiser son Express autour de MySQL

Voici une décomposition complète du projet en utilisant des modèles, des routeurs et des contrôleurs. Cela rendra votre code plus modulaire et plus facile à maintenir

1. Structure du dossier:
```
/votre_projet
├── app.js
├── config
│   └── db.js
├── models
│   └── user.js
├── routes
│   └── userRoutes.js
├── controllers
│   └── userController.js
└── node_modules
    ├── ...
```

2. Modèle de l'utilisateur (`models/user.js`)
```js
// model/user.js
const connection = require('../config/db');

class User {
  static getAllUsers(callback) {
    connection.query('SELECT * FROM users', callback);
  }

  static addUser(userData, callback) {
    connection.query('INSERT INTO users VALUES ?', userData, callback);
  }

  static updateUser(userId, userData, callback) {
    connection.query('UPDATE users SET ? WHERE id= ?', [userData, userId], callback);
  }

  static deleteUser(userId, callback) {
    connection.query('DELETE FROM users WHERE id= ?', userId, callback);
  }
}
```

3. Contrôleur de l'utilisateur (`controllers/userController.js`)
```js
// controllers/userController.js
const User = require('../models/user')

const userController = {
  getAllUsers: (req, res) => {
    User.getAllUsers((err, users) => {
      if (err) throw err;
      res.json(users);
    });
  },

  addUser: (req, res) => {
    const userData = req.body;
    User.addUser(userData, (err, result) => {
      if (err) throw err;
      res.send('Utilisateur ajouté avec succès');
    });
  },

  updateUser: (req, res) => {
    const userId = req.params.id;
    const userData = req.body;
    User.updateUser(userId, userData, (err, result) => {
      if (err) throw err;
      res.send('Utilisateur mis à jour avec succès');
    })
  },

  deleteUser: (req, res) => {
    const userId = req.params.id;
    User.deleteUser(userId, (err, result) => {
      if (err) throw err;
      res.send('Utilisateur supprimé avec succès');
    });
  },
}

module.exports = userController;
```

4. Routeur de l'utilisateur (`routes/userRoutes.js`)

```js
const express = require('express');
const router = express.Router();
const userController = require('../controllers/userController');

router.get('/', userController.getAllUsers);
router.post('/', userController.addUser);
router.put('/:id', userController.updateUser);
router.delete('/:id', userController.deleteUser);

module.exports = router;
```

5. Fichier principal (`app.js`)

```js
// app.js
const express = require('express');
const bodyParser = require('body-parser');
const userRoutes = require('./routes/userRoutes')
const app = express();
const port = 3000;

app.use(bodyParser.json());

// Utiliser le routeur pour gérer les routes utilisateur
app.use('/api/utilisateurs', userRoutes)

app.listen(port, () => {
  console.log(`Serveur écoutant sur le port ${port}`)
});
```
