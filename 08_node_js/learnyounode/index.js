import * as fs from 'fs';
import * as path from 'path';

let file = "./nodejs_m2i.pdf";
fs.stat(file, (err, stats) => {
    if(err){
        console.log(err.message);
        return;
    }
    console.log(stats.size);
})
console.log(path.basename(file));
console.log(path.resolve(file));
const fileTxt = "./example.txt";

fs.readFile(fileTxt, {encoding: 'utf8'}, (err, data) => {
    if (err) return console.log(err);

    console.log(data);
})