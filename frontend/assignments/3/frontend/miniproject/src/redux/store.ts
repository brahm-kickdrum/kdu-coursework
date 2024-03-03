import { configureStore } from "@reduxjs/toolkit";
import { stockBasePriceListReducer } from "./StockBasePriceSlice";
import { watchListReducer } from "./WatchListSlice";

export const store = configureStore({
    reducer:{
        stockList : stockBasePriceListReducer,
        watchList : watchListReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch