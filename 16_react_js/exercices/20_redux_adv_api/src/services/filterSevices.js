import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "./api.backend";
import axios from "axios";
import * as URL from '../constants/backendUrl'

export const initializeFilters = createAsyncThunk(
    'filter/initializeFilters', async ( _r ) => axios.all(
        api.get(URL.TYPES_URI)
            .then(console.log),
        api.get(URL.SUBTYPES_URI)
            .then(console.log)
    ),
)