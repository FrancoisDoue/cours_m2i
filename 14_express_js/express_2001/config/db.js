import "dotenv/config"
import mongoose from "mongoose";

mongoose.connect(process.env.MONGO_URI)
const db = mongoose.connection
db.on('error', console.error.bind(console, 'Connect error to '+process.env.MONGO_URI))
db.once('open', () => console.log('Succesfully connected to MongoDB'))

export default db
