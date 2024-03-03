import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { getProducts } from "./thunk/getProducts";
import { AlertColor } from "@mui/material";

export interface ISnackBarState {
    show: boolean;
    message: string;
    severity : AlertColor;
}

const initialSnackBarState: ISnackBarState = {
    show: false,
    message: "",
    severity: "info"
};

const snackBarSlice = createSlice({
    name: "snackBar",
    initialState: initialSnackBarState,
    reducers: {
        setShow: (state, action: PayloadAction<boolean>) =>{
            state.show = action.payload
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(getProducts.fulfilled, (state) => {
                state.show = true;
                state.message = "Products loaded successfully"
                state.severity = "success"
            })
            .addCase(getProducts.rejected, (state) => {
                state.show = true;
                state.message = "Can not load the products"
                state.severity = "error"
            });
    }
});

export const snackBarReducer = snackBarSlice.reducer;
export const {setShow} = snackBarSlice.actions;