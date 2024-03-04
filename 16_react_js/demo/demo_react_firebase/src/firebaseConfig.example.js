// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "an_api_key",
    authDomain: "",
    projectId: "",
    storageBucket: "",
    messagingSenderId: "73",
    appId: "",
    databaseURL: 'db_url'

};

export const BASE_DB_URL = firebaseConfig.databaseURL
export const SIGN_UP_URL = `https://url_signup?key=${firebaseConfig.apiKey}`
export const SIGN_IN_URL = `https://url_signin?key=${firebaseConfig.apiKey}`

// Initialize Firebase
const app = initializeApp(firebaseConfig);