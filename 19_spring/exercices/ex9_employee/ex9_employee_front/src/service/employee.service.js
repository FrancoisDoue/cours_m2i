import { createAsyncThunk } from "@reduxjs/toolkit";
import { employeeApi } from "./api.backend";
import { setCurrentEmployee, setEmployeeList } from "../storage/employeeSlice";

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
    async({body}, {rejectWithValue, dispatch}) => {
        try {
            const resultEmployee = await employeeApi.post("", body)
        } catch (err) {
            rejectWithValue(err)
        }
    }
)

export const deleteEmployee = createAsyncThunk(
    'employee/postEmployee',
    async(id, {rejectWithValue, dispatch}) => {
        try {
            await employeeApi.delete("/"+id)
            const employeeList = await employeeApi.get()
            dispatch(setEmployeeList(employeeList))
        } catch (err) {
            rejectWithValue(err)
        }

    }
)

// export const getEmployeeById = createAsyncThunk(
//     'employee/getEmployeeById',
//     async (id, {rejectWithValue, dispatch}) => {
//         try {
//             const employee = await employeeApi.get("/"+id)
//             dispatch(setCurrentEmployee(employee))
//         } catch (error) {
//             rejectWithValue(error)
//         }
//     }
// )