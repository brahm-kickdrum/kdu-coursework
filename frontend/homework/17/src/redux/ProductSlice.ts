import { createSlice } from "@reduxjs/toolkit";
import { getProducts } from "./thunk/getProducts";

export interface IRating {
    rate: number;
    count: number;
}

export interface IProduct {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: IRating;
}

export interface IProductListState {
    productList: IProduct[];
    status: "pending" | "fulfilled" | "error";
    error?: string;
}

const initialProductListState: IProductListState = {
    productList: [],
    status: "pending"
};

const productListSlice = createSlice({
    name: "productList",
    initialState: initialProductListState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(getProducts.pending, (state) => {
                state.status = "pending";
            })
            .addCase(getProducts.fulfilled, (state, action) => {
                state.status = "fulfilled";
                state.productList = action.payload;
            })
            .addCase(getProducts.rejected, (state, action) => {
                state.status = "error";
                state.error = action.error.message;
            });
    }
});

export const productListReducer = productListSlice.reducer;