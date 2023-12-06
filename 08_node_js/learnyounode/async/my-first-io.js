// import * as fs from 'fs';

//const fs = require('fs');

// const fileContent = fs.readFileSync(process.argv[2], {encoding: 'utf8'})
// console.log([...fileContent.matchAll(/\n/g)].length);

//const fs = require('fs');

// fs.readFile(process.argv[2], {encoding: 'utf8'}, (err, data) => {
//     if(err) return console.log(err);
//     console.log(data.match(/\n/g).length);
// })


// const fs = require('fs'), path = require('path');

// const extName = '.'+process.argv[3];

// fs.readdir(process.argv[2], (err, list) => {
//     if (err) 
//         return console.log(err);
//     list.forEach((element) => {
//         if (path.extname(element) === extName) 
//             console.log(element);
//     })
// })

// const fs = require('fs');
// const fileSort =  require('./sortListFile.js');

fileSort(process.argv[2], process.argv[3], (err, files) => {
    if (err) console.log(err);
    else files.forEach(element => console.log(element));
});