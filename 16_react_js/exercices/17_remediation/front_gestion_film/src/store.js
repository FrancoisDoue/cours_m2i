import { configureStore } from "@reduxjs/toolkit";
import moviesSlice from "./components/moviesSlice";

export default configureStore({
    reducer:{
        movies: moviesSlice,
    }
})