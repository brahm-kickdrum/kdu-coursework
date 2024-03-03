import { createSlice } from "@reduxjs/toolkit";
import { getStockBasePrice } from "./thunk/getStockBasePrice";

export interface IStockBasePrice {
    stock_name: string;
    stock_symbol: string;
    base_price: number;
}

export interface StockBasePriceState {
    stockBasePriceList: IStockBasePrice[],
    status: "pending" | "fulfilled" | "error";
    error?: string;
}

const initialStockBasePriceListState: StockBasePriceState = {
    stockBasePriceList: [],
    status: "pending"
}

const stockBasePriceListSlice = createSlice({
    name: "stockBasePriceList",
    initialState: initialStockBasePriceListState,
    reducers: {

    },
    extraReducers: (builder) => {
        builder
            .addCase(getStockBasePrice.pending, (state) => {
                state.status = "pending";
            })
            .addCase(getStockBasePrice.fulfilled, (state, action) => {
                const sortedPayload = action.payload.slice().sort((a: IStockBasePrice, b: IStockBasePrice) => a.stock_name.localeCompare(b.stock_name));
                state.stockBasePriceList = sortedPayload;
                state.status = "fulfilled";
            })
    }

})

export const stockBasePriceListReducer = stockBasePriceListSlice.reducer;