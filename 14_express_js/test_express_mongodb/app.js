import 'dotenv/config'
import db from './config/db.js';
import express from 'express';
import router from './src/routes/index.js';
import mongoose from 'mongoose';
import { logger } from './middlewares/devUtilities.js';

const PORT = process.env.PORT

const app = express()

app.use(express.json())
// app.use('/film', logger)
app.use('/film', logger, router)

app.listen(PORT, () => console.log(`SERVER IS LISTENING ON PORT ${PORT}`))
