import { createClient } from "redis";

const HOST = "127.0.0.1"
const PORT = "6379"
const ARRAY_KEY = "productIndex"

const client = await createClient(PORT, HOST)
    .on('error', e => console.log("REDIS ERROR : ", e))
    .connect()

export const redisAddObj = async (key, obj) => {
    if (typeof obj !== 'object' || typeof key !== 'string') return false
    try{
        await client.hSet(key, obj)
        return true
    }catch(e){
        console.log(e)
        return false
    }
}
export const redisGetObj = async (key) => {
    if (typeof key !== 'string') return
    try {
        return await client.hGetAll(key)
    }catch(e) {
        return e
    }
}
export const redisAddToArray = async (value) => {
    try {
        await client.rPush(ARRAY_KEY, value)
    }catch(e){
        console.error(e);
    }
}