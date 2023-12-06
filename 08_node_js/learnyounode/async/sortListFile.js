const path = require('path');
const fs = require('fs');

module.exports = fileSort = (passedPath, extName, callback) => {
    extName = '.'+extName;
    fs.readdir(passedPath, (err, list) => {
        if (err) return callback(err);
        
        list = list.filter(element => path.extname(element) === extName)
        return callback(null, list);
    })
}