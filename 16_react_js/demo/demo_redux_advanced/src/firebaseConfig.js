// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyDs13lZYD6uChllkeA8XkCWIwVZHPlPhSo",
    authDomain: "m2i-cda-francois.firebaseapp.com",
    projectId: "m2i-cda-francois",
    storageBucket: "m2i-cda-francois.appspot.com",
    messagingSenderId: "73390774393",
    appId: "1:73390774393:web:000fbdb52a05aae1799ca8",
    databaseURL: 'https://m2i-cda-francois-default-rtdb.europe-west1.firebasedatabase.app/'

};

export const BASE_DB_URL = firebaseConfig.databaseURL
// export const SIGN_UP_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${firebaseConfig.apiKey}`
// export const SIGN_IN_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${firebaseConfig.apiKey}`

// Initialize Firebase
const app = initializeApp(firebaseConfig);