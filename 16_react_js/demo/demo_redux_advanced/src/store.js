import { configureStore } from "@reduxjs/toolkit";
import todoSlice from "./components/todoSlice";

export default configureStore({
    reducer: {
        todo: todoSlice,
    }
})