import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getTransactions } from "./thunk/getTransactions";

export interface ITransaction {
  stock_name: string;
  stock_symbol: string;
  transaction_price: number;
  timestamp: string;
  status: Status;
}

export enum Status {
  Failed = "Failed",
  Passed = "Passed",
}

export enum TransactionStatus {
  Pending = "pending",
  Fulfilled = "fulfilled",
  Error = "error"
}

export interface ITransactionState {
  transactionList: ITransaction[];
  status: TransactionStatus;
  error?: string;
}

const TransactionState: ITransactionState = {
  transactionList: [],
  status: TransactionStatus.Pending
};

const transactionListSlice = createSlice({
  name: "transactionList",
  initialState: TransactionState,
  reducers: {
    addTransaction: (state, action: PayloadAction<ITransaction>) => {
      state.transactionList.push(action.payload);
    },
    clearTransactions: (state) => {
      state.transactionList = [];
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(getTransactions.pending, (state) => {
        state.status = TransactionStatus.Pending;
        state.error = undefined;
      })
      .addCase(getTransactions.fulfilled, (state, action) => {
        state.status = TransactionStatus.Fulfilled;
        state.transactionList = action.payload;
        state.error = undefined;
      })
      .addCase(getTransactions.rejected, (state, action) => {
        state.status = TransactionStatus.Error;
        state.error = action.error.message ?? "Unknown error";
      });
  },
});

export const transactionListReducer = transactionListSlice.reducer;
export const { addTransaction, clearTransactions } = transactionListSlice.actions;