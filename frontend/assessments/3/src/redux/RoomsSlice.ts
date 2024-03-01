import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { fetchRoomData } from "./thunk/getRooms";

export interface IRoom {
    id:           number;
    name:         string;
    costPerNight: string;
    currency:     Currency;
    addOns:       AddOn[];
    selected?:    boolean;
}

export interface AddOn {
    name:     string;
    cost:     string;
    currency: Currency;
}

export enum Currency {
    Inr = "INR",
}

interface RoomDataState {
    rooms: IRoom[];
    selectedRoomId: number;
}

const initialState: RoomDataState = {
    rooms: [],
    selectedRoomId: 0
};

const roomDataSlice = createSlice({
    name: "roomData",
    initialState,
    reducers: {
        selectRoom: (state, action: PayloadAction<number>) => {
            state.selectedRoomId = action.payload;
            state.rooms.forEach(room => {
                room.selected = room.id === action.payload;
            });
        },
    },
    extraReducers: builder => {
        builder
            .addCase(fetchRoomData.fulfilled, (state, action: PayloadAction<IRoom[]>) => {
                state.rooms = action.payload;
            })
    },
});

export const { selectRoom } = roomDataSlice.actions;

export const roomDataReducer = roomDataSlice.reducer;

