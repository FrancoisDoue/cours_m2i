import { configureStore } from "@reduxjs/toolkit";
import authSlice from "./component/auth/authSlice";
import taskSlice from "./component/task/taskSlice";

export default configureStore({
    reducer: {
        auth: authSlice,
        task: taskSlice
    }
})