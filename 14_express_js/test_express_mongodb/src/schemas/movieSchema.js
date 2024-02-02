import { Schema, model } from "mongoose";

const movieSchema = new Schema({
    title: {type: String, required: true},
    description: {type: String},
    director: {type: String, required: true},
    releaseDate: {type: Date},
    slug: {type: String, default: function(){return this.title.toLowerCase().replaceAll(' ', '_')}}
})

export default model('Movie', movieSchema)