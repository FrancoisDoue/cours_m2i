import { createSlice } from "@reduxjs/toolkit";

const productsSlice = createSlice({
    name: 'products',
    initialState: {
        productList: [
            {id: 1, name: 'pomme', price: 1 },
            {id: 2, name: 'poire', price: 1.2 },
        ]
    },
    reducers:{
        addProduct: (state, action) => {
            action.payload.id = Date.now()
            state.productList.push(action.payload)
        },
        deleteProduct: (state, action) => {
            const id = action.payload
            state.productList = state.productList.filter(item => item.id != id)
        },
        modifyProduct: (state, action) => {
            const modifiedProduct = action.payload
            const i = state.productList.findIndex(e => e.id == modifiedProduct.id)
            state.productList[i] = modifiedProduct
        }
    }
})

export const {addProduct, deleteProduct, modifyProduct} = productsSlice.actions

export default productsSlice.reducer