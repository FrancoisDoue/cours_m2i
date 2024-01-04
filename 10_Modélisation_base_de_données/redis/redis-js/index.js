// const redis = import('redis')
import { createClient } from "redis"

// const HOST = "127.0.0.1"
// const PORT = "6379"

// const URL = ``

const client = await createClient()
    .on('error' , err => console.log('Error redis client', err))
    .on('connect', () => console.log('Connected'))
    .connect();

const addToRedis = async(key, value, c = client) => {
    try {
        c.set(key, value)
    }catch(e){
        return e
    }
}

const getFromRedis = async(key, c = client) => {
    try{
        const res = await c.get(key)
        return res
    }catch(e){
        return e
    }
}

const deleteFromRedis = async(key, c = client) => {
    try {
        await c.del(key)
        return 'deleted value : ' + key
    }catch(e){
        return e
    }
}



// await client.set('say_hello', 'Hello World!')

// console.log(await client.get('say_hello'));

// await client.set('say_hello', 'Good bye, world T_T');

// console.log(await client.get('say_hello'));

// await client.del('say_hello')

// console.log(await client.get('say_hello'));

await client.disconnect()