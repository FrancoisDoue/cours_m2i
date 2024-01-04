import { createInterface } from "readline";
import { createClient } from "redis";
import { exit, stdin, stdout } from "process";

const HOST = "127.0.0.1"
const PORT = "6379"

const rl = createInterface(stdin, stdout)

const questionAsync = async (qst) => {
    return new Promise((resolve) => {
        rl.question(qst, a => resolve(a))
    })
}

const client = await createClient(PORT, HOST)
    .on('error', err => console.log('redis error : ', err))
    .connect()

const updateTaskIndex = async () => {
    let index = parseInt(await client.get('taskIndex') ?? -1)
    await client.set('taskIndex', ++index)
    return index;
}

const addTask = async () => {
    try {
        const value = await questionAsync('TASK  :  ')
        const key = `task_${await updateTaskIndex()}`
        await client.set(key, value)
    } catch (error) {
        console.log(error)
    }
}

const getAllTasks = async () => {
    let taskList = [];0
    for (let i = 0; i <= await client.get('taskIndex'); i++) {
        try {
            const taskIndex = `task_${i}`
            const response = await client.get(taskIndex)
            if (response) taskList[taskIndex] = response
        } catch (error) {
            return error
        }
    }
    return taskList
}

const deleteTask = async () => {
    const taskList = await showAllTasks()
    const key = await questionAsync('\nType the key of the task you want to delete : \n')
    if (taskList[key]) {
        try {
            client.del(key)
            console.log('== [ Task successfully deleted ] ==')
        } catch (e) {
            console.log('Error : ', e)
        }
    } else {
        console.log('== [ This task does not exist ] ==')
    }
}

const showAllTasks = async () => {
    const taskList = await getAllTasks()
    for (const e in taskList) {
        console.log(e + ' ==> ' + taskList[e])
    }
    return taskList
}


const menu = async () => {
    let choice;
    do {
        console.log('\n[1] Add a task\n[2] Show tasks\n[3] Delete a tasks\n[- 0 -] Quit\n')
        choice = await questionAsync('==>');
        switch (choice) {
            case '1':
                await addTask()
                break;
            case '2':
                await showAllTasks()
                break;
            case '3':
                await deleteTask()
                break;
            case '0':
                console.log('== [  END  ] ==')
                client.disconnect()
                exit()
            default:
                console.log('\n== [ Invalid choice ] ==\n')
                break;
        }
    } while (choice != "0")
}
menu()


// -----------------------------------------------------------------------
// code Alex =>

// const redis = require('redis');
// const port = '6379';
// const host = '127.0.0.1';
// const client = redis.createClient(port, host);
 
// const readline = require('readline');
// const { stdin: input, stdout: output} = require('process');
// const { rejects } = require('assert');
// client.on('connect', (err) => {
//     if(err){
//         console.log(err);
//     }else{
//         console.log('server redis is connected\n')
//         menu();
//     }
// }).connect();
 
 
// const rl = readline.createInterface({input, output});
 
// let menuSelector = 0;
// const menuInterface = "1 pour ajouter une tache\n 2 pour voir toutes les taches enregistrées\n 3 pour supprimer une tache \n 4 pour quitter le menu\n"
 
 
// const menu = async() => {
//     while (menuSelector != '4'){
//         console.log(menuInterface);
//         menuSelector  = await question('Votre choix: \n');
//         if(menuSelector === '1'){
//             console.log(await addValue());
//         }
//         if(menuSelector === '2'){
//             console.log(await getAllValue());
//         }
        
//     };
// }
 
 
// const question = async(question) => {
//     return new Promise((resolve, rejects) => {
//         rl.question(question, (res) => {
//             resolve(res);
//         })
//     })
// }
 
// const addValue = async () => {
//     try{
//         let index = await getTaskIndex();
//         const value = await question('Ajouter une tache: \n');
//         const res = await client.set(`task${index}`, value);
//         if(res){
//             await setTaskIndex(index+1);
//             return res;
//         }
//     }catch(err){
//         console.error(err);
//     }
// }
 
 
// const getAllValue = async () => {
//     try{
//         let index = await getTaskIndex();
//         let task = [];
//         console.log(index);
//         for (let i = 0; i < index+1; i++) {
//             const taskValue = await client.get(`task${i}`)
//                 task.push(taskValue);
//         }
//         return task;
//     }catch(err){
//         console.error(err);
//     }
// };
 
// const setTaskIndex = async(i) => {
//     try{
//         await client.set('taskIndex', i);
//     }catch(err){
//         console.error(err);
//     }
// }
 
// const getTaskIndex = async() => {
//     try {
//         const i = await client.get('taskIndex');
//         if(!i){
//             console.log('ouais');
//             await setTaskIndex(0);
//             return 0;
//         }else{
//             return parseInt(i);
//         }
//     } catch (err) {
//         console.error(err)
//     }
// }
