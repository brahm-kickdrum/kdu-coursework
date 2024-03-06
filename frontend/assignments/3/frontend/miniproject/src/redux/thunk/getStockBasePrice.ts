import { createAsyncThunk } from "@reduxjs/toolkit";

export const getStockBasePrice = createAsyncThunk(
    "getStockBasePrice", async () => {
        try {
            const response = await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/stocks.json");
            if (!response.ok) {
                throw new Error("Failed to fetch stocks");
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error("Error fetching products:", error);
            throw error;
        }
    }
);
