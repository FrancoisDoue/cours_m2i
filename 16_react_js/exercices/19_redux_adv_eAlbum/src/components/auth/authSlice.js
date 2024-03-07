import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'
// import { REFRESH_URL } from '../../firebaseConfig'


export const sendCredentials = createAsyncThunk(
    'auth/sendCredentials',
    async (request, {rejectWithValue}) => axios.post(request.url, request.body)
        .then(res => ({
            response: res.data, 
            context: {
                // stayLogged: request.stayLogged,
                isLogin: request.isLoginContext
            }
        }))
        .catch(e => rejectWithValue(e.response?.data?.error))
)

// export const refreshAuthToken = createAsyncThunk(
//     'auth/refreshToken', 
//     async(_request, {getState, rejectWithValue}) => {
//         const {auth} = getState()
//         return axios.post(REFRESH_URL, {
//             grant_type: 'refresh_token',
//             refresh_token: auth.user.refreshToken
//         })
//         .then(r => r.data)
//         .catch(console.error)
//     }
// )

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        formMode: true,
        user: JSON.parse(localStorage.getItem('userInfos'))|| null,
        isLoading: false,
        error: null
    },
    reducers: {
        setFormMode : (state) => {
            state.formMode = !state.formMode
        },
        logout: (state) => {
            state.user = null
            localStorage.removeItem('userInfos')
        },
    },
    extraReducers: (builder) => {
        builder.addCase(sendCredentials.fulfilled, (state, action) => {
            const {context, response} = action.payload
            if(context.isLogin){
                response.expiresIn = +response.expiresIn * 1000 + Date.now()
                const userValue = {...response, stayLogged: context.stayLogged}
                localStorage.setItem('userInfos', JSON.stringify(userValue))
                state.user = userValue
                console.log('loggin success')
            } else console.log('Register success')
            state.error = null
            state.isLoading = false
        })
        builder.addCase(sendCredentials.rejected, (state, action) => { 
            console.log('rejected')
            state.isLoading = false
            state.error = action.payload 
        })
        builder.addCase(sendCredentials.pending, (state) => { 
            console.log('is pending')
            state.isLoading = true
        })
        // builder.addCase(refreshAuthToken.fulfilled, (state, action) => {
        //     console.log('refresh token success!')
        //     console.log(action.payload)
        //     state.user.idToken = action.payload.id_token
        //     // state.user.expiresIn = +action.payload.expires_in * 1000 + Date.now()
        //     state.user.expiresIn = 10 * 1000 + Date.now()
        //     localStorage.setItem('userInfos', JSON.stringify(state.user))
        //     // console.log(action.payload)
        // })
    }
})

export const selectIsLogged = (state) => (!!state.auth.user && state.auth.user?.expiresIn > Date.now())
// export const selectUserStayLogged = (state) => (!selectIsLogged(state) && !!state.auth.user?.stayLogged)

export const { setFormMode, logout } = authSlice.actions

export default authSlice.reducer