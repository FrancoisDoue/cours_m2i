import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "./api.backend";
import axios from "axios";
import * as URL from '../constants/backendUrl'
import { setSubTypes, setTypes, setSuperTypes, setFormats } from "../components/filterTools/filterSlice";

export const initializeFilters = createAsyncThunk(
    'filter/initializeFilters', async ( _r, {rejectWithValue, dispatch} ) => {
        console.log('requests sended')
        return axios.all(
            api.get(URL.TYPES_URI)
                .then(res => dispatch(setTypes(res)))
                .catch(rejectWithValue),
            api.get(URL.SUBTYPES_URI)
                .then(res => dispatch(setSubTypes(res)))
                .catch(rejectWithValue),
            api.get(URL.SUPERTYPE_URI)
                .then(res => dispatch(setSuperTypes(res)))
                .catch(rejectWithValue),
            api.get(URL.FORMATS_URI)
                .then(res => dispatch(setFormats(res)))
                .catch(rejectWithValue)
    )},
    // {
    //     // condition: (args, {getState}) => {
    //     //     const {filter} = getState()
    //     //     const all = getState()
    //     //     console.log(all)
    //     //     args.isLoading = filter.isLoading
    //     //     // return !filter.isLoading
    //     //     // return !filter.isLoading
    //     // },
    //     // dispatchConditionRejection: true,
        
    // }
)