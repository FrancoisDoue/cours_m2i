import { configureStore } from "@reduxjs/toolkit";
import employeeSlice from "./employeeSlice";
import candidateSlice from "./candidateSlice";

export default configureStore({
    reducer: {
        employee: employeeSlice,
        candidate: candidateSlice
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})