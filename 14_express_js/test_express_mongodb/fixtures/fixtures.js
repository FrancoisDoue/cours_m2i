import 'dotenv/config';
import db from "../config/db.js";
import {exit} from 'process';
import movieModel from '../src/models/movieModel.js';

let numberOfDocuments = 500

const getRandInRange = (min = 0, max =  75) => Math.round(Math.random() * (max - min) + min)

const runMoviesFixtures = async() => {
    for (let i = 0; i < numberOfDocuments; i++) {
        await movieModel.postMovie({
            title: `Film ${i}`,
            description: "a description",
            director : `Director ${getRandInRange()}`,
            releaseDate : `${getRandInRange(1900, 2024)}`
        }).catch(err => {
            console.log(err)
            return err
        })
    }
    console.log('Fixtures added to DB')
    exit()
}

db.once('open', runMoviesFixtures)