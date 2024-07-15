import { createAsyncThunk } from "@reduxjs/toolkit";
import { authApi } from "./api.backend";
import { setUser } from "../storage/authSlice";

export const login = createAsyncThunk(
    "auth/login",
    async ({body}, {rejectWithValue, dispatch}) => {
        try {
            const user = await authApi('', body)
            dispatch(setUser(user))
        } catch (err) {
            rejectWithValue(err)
        }
    }
)