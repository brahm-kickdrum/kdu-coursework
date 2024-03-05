import { configureStore } from "@reduxjs/toolkit";
import { stockBasePriceListReducer } from "./StockBasePriceSlice";
import { watchListReducer } from "./WatchListSlice";
import { transactionListReducer } from "./TransactionsSlice";
import { UsertransactionListReducer } from "./UserTransactionsSlice";

export const store = configureStore({
    reducer:{
        stockList : stockBasePriceListReducer,
        watchList : watchListReducer,
        transactionList : transactionListReducer,
        userTransactionList : UsertransactionListReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch