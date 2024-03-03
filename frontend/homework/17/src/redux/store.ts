import { configureStore } from "@reduxjs/toolkit";
import { productListReducer } from "./ProductSlice";
import { snackBarReducer } from "./SnackBarSlice";

export const store = configureStore({
    reducer:{
        productList : productListReducer,
        snackBar : snackBarReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch