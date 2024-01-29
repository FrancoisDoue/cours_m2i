import 'dotenv/config'
import express from 'express';
import router from './src/routes/index.js';
import mongoose from 'mongoose';

const PORT = process.env.PORT

mongoose.connect(process.env.MONGO_URI)
const db = mongoose.connection

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
  console.log('Connecté à MongoDB');
});


// const mongo = async() => await mongoose.connect(process.env.MONGO_URI)
// mongo().catch(err => console.log(err))

const app = express()

app.use(express.json())
app.use('/', router)

app.listen(PORT, () => console.log(`SERVER IS LISTENING ON PORT ${PORT}`))

const productSchema = new mongoose.Schema({
    name: String,
    price: Number,
})

const Product = mongoose.model('Product', productSchema)


// console.log(newProduct)

// productSchema.methods.getName = function getName(){
//     console.log(this.name)
//     return this.name
// }

const newProduct = new Product({name: "Telephone", price: 200})

// findSimilarTypes(cb) {
//     return mongoose.model('Animal').find({ type: this.type }, cb);
//   }
// }
// });
// newProduct.getName()