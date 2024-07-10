import { configureStore } from "@reduxjs/toolkit";
import employeeSlice from "./employeeSlice";

export default configureStore({
    reducer: {
        employee: employeeSlice
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})