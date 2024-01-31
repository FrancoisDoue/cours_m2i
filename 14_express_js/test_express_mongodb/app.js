import 'dotenv/config'
import express from 'express';
import router from './src/routes/index.js';
import mongoose from 'mongoose';

const PORT = process.env.PORT

mongoose.connect(process.env.MONGO_URI, {
  // useNewUrlParser: true,
  // useUnifiedTopology: true
})
const db = mongoose.connection

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
  console.log('Connecté à MongoDB');
});

const app = express()

app.use(express.json())
app.use('/film', router)

app.listen(PORT, () => console.log(`SERVER IS LISTENING ON PORT ${PORT}`))

// const productSchema = new mongoose.Schema({
//     name: String,
//     price: Number,
// })

// const Product = mongoose.model('Product', productSchema)


