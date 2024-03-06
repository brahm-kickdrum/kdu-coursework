import { createAsyncThunk } from "@reduxjs/toolkit";

export const fetchRoomData = createAsyncThunk(
    // "roomData/fetchRoomData",
    "fetchRoomData",
    async () => {
        try {
            const response = await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json");
            if (!response.ok) {
                throw new Error('Failed to fetch room data');
            }
            const data = await response.json();
            return data.roomTypes;
        } catch (error) {
            throw new Error('Failed to fetch room data');
        }
    }
);

