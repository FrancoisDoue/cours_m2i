// import {readFileSync, writeFileSync} from 'fs';

function Film(id, name, time, real){
    this.id = id;
    this.name = name;
    this.time = time;
    this.real = real;
}
Film.prototype.toString = function (){
    return Object.values(this).join(';');
}

const myFilm = new Film(1, 'Shrek', 120, 'Dreamworks');
const myFilm2 = new Film(2, 'Shrek 2', 120, 'Dreamworks');
const myFilm3 = new Film(3, 'Shrek 3', 120, 'Dreamworks');

function writeToCSV(file, data){
    let content = '';
    data.forEach(element => content += element.toString());
}