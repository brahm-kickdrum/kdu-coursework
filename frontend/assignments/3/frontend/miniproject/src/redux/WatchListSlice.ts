import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { IStockBasePrice } from "./StockBasePriceSlice";


interface WatchlistState {
  watchlist: IStockBasePrice[];
}

const initialState: WatchlistState = {
  watchlist: [],
};

const watchListSlice = createSlice({
  name: "watchlist",
  initialState: initialState,
  reducers: {
    addToWatchList: (state, action: PayloadAction<IStockBasePrice>) => {
      state.watchlist.push(action.payload);
    },
    removeFromWatchList: (state, action: PayloadAction<string>) => {
      state.watchlist = state.watchlist.filter(item => item.stock_name !== action.payload);
    },
  },
});

export const { addToWatchList, removeFromWatchList } = watchListSlice.actions;
export const watchListReducer = watchListSlice.reducer;