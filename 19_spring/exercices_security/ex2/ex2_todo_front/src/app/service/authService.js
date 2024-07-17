import { createAsyncThunk } from "@reduxjs/toolkit";
import { authApi } from "./api.backend";
import { initializeLogin } from "../store/authSlice";

const login = createAsyncThunk(
    "auth/login",
    async ({body}, {rejectWithValue, dispatch}) => {
        try {
            const response = await authApi.post("/login", body)
            dispatch(initializeLogin(response.token))
        } catch (error) {
            rejectWithValue(error)
        }

    }
)