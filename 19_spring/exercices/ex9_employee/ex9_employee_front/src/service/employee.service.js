import { createAsyncThunk } from "@reduxjs/toolkit";
import { employeeApi } from "./api.backend";
import { replaceEmployee, setEmployeeList } from "../storage/employeeSlice";
import { getAllCandidates } from "./candidates.service";

export const getAllEmployees = createAsyncThunk(
    'employee/getAllEmployees',
    async (_args, {rejectWithValue, dispatch}) => {
        try {
            const employeeList = await employeeApi.get()
            dispatch(setEmployeeList(employeeList))
        } catch (error) {
            rejectWithValue(error)
        }
    }
)

export const postEmployee = createAsyncThunk(
    'employee/postEmployee',
    async ({body}, {rejectWithValue, dispatch}) => {
        try {
            await employeeApi.post("", body)
            dispatch(getAllEmployees())
        } catch (err) {
            rejectWithValue(err)
        }
    }
)

export const postEmployeeFromCandidate = createAsyncThunk(
    'employee/postEmployeeFromCandidate',
    async ({id, body}, {rejectWithValue, dispatch}) => {
        try {
            await employeeApi.post("/recruit/"+id, body)
            dispatch(getAllEmployees())
            dispatch(getAllCandidates())
        } catch (err) {
            console.log(err)
            rejectWithValue(err)
        }
    }
)

export const postAbsence = createAsyncThunk(
    'employee/postAbsence',
    async ({id, body}, {rejectWithValue, dispatch}) => {
        try {
            const employee = await employeeApi.post(`/${id}/absence`, body)
            dispatch(replaceEmployee(employee))
        } catch (err) {
            console.log(err)
            rejectWithValue(err)
        }
    }
)

export const deleteEmployee = createAsyncThunk(
    'employee/postEmployee',
    async(id, {rejectWithValue, dispatch}) => {
        try {
            await employeeApi.delete("/"+id)
            dispatch(getAllEmployees())
        } catch (err) {
            rejectWithValue(err)
        }
    }
)
