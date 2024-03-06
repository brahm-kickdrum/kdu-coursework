import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface SelectedAddOnsState {
    selectedAddOns: string[];
}

const initialState: SelectedAddOnsState = {
    selectedAddOns: [],
};

const selectedAddOnsSlice = createSlice({
    name: "selectedAddOns",
    initialState,
    reducers: {
        selectAddOn: (state, action: PayloadAction<string>) => {
            state.selectedAddOns.push(action.payload);
        },
        deselectAddOn: (state, action: PayloadAction<string>) => {
            state.selectedAddOns = state.selectedAddOns.filter(item => item !== action.payload);
        },
        clearSelectedAddOns: (state) => {
            state.selectedAddOns = [];
        },
    },
});

export const { selectAddOn, deselectAddOn, clearSelectedAddOns } = selectedAddOnsSlice.actions;

export const selectedAddOns = selectedAddOnsSlice.reducer;
