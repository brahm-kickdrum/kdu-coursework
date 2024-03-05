import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { Status, TransactionStatus } from "./TransactionsSlice";

export interface IUserTransaction {
    stock_name: string;
    stock_symbol: string;
    transaction_price: number;
    timestamp: string;
    status: Status;
    quantity: number;
    type: Type
}

export enum Type {
    Buy = "Buy",
    Sell = "Sell"
}

export interface IUserTransactionState {
    transactionList: IUserTransaction[];
    status: TransactionStatus;
    error?: string;
}

const UserTransactionState: IUserTransactionState = {
    transactionList: [],
    status: TransactionStatus.Pending
};

const UsertransactionListSlice = createSlice({
    name: "UsertransactionList",
    initialState: UserTransactionState,
    reducers: {
        addUserTransaction: (state, action: PayloadAction<IUserTransaction>) => {
            state.transactionList.push(action.payload);
        },
        clearTransactions: (state) => {
            state.transactionList = [];
        },
    },
});

export const { addUserTransaction, clearTransactions } = UsertransactionListSlice.actions;
export const UsertransactionListReducer = UsertransactionListSlice.reducer;