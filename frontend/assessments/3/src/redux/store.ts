import { configureStore } from "@reduxjs/toolkit";
import { roomDataReducer } from "./RoomsSlice";
import { selectedAddOns } from "./thunk/AddonsSlice";

export const store = configureStore({
  reducer: {
    roomData: roomDataReducer,
    selectedAddOns: selectedAddOns
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
