import { createAsyncThunk } from "@reduxjs/toolkit";
import { candidateApi } from "./api.backend";
import { replaceCandidate, setCandidateList } from "../storage/candidateSlice";

export const getAllCandidates = createAsyncThunk(
    'candidates/getAllCandidates',
    async (_args, {rejectWithValue, dispatch}) => {
        try {
            const candidateList = await candidateApi.get()
            dispatch(setCandidateList(candidateList))
        } catch (err) {
            rejectWithValue(err)
        }
    }
)

export const postCandidate = createAsyncThunk(
    'candidates/postCandidate',
    async ({body}, {rejectWithValue, dispatch}) => {
        try {
            await candidateApi.post("", body)
            dispatch(getAllCandidates())
        } catch (err) {
            rejectWithValue(err)
        }
    }
)

export const updateCandidate = createAsyncThunk(
    'candidates/updateCandidate',
    async ({id, body}, {rejectWithValue, dispatch}) => {
        try {
            const candidate = await candidateApi.put("/"+id, body)
            dispatch(replaceCandidate(candidate))
        } catch (err) {
            rejectWithValue(err)
        }
    }
)

export const deleteCandidate = createAsyncThunk(
    "candidate/deleteCandidate",
    async (id, {rejectWithValue, dispatch}) => {
        try {
            await candidateApi.delete("/"+id)
            dispatch(getAllCandidates())
        } catch (err) {
            rejectWithValue(err)
        }
    }
)