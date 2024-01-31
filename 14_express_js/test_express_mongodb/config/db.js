import mongoose from "mongoose";

mongoose.connect(process.env.MONGO_URI, {
    // useNewUrlParser: true,
    // useUnifiedTopology: true
  })
const db = mongoose.connection

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
console.log('Connecté à MongoDB');
});

export default db