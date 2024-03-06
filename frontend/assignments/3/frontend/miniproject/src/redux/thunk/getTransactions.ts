import { createAsyncThunk } from "@reduxjs/toolkit";

export const getTransactions = createAsyncThunk(
    "getTransactions", async () => {
        try {
            const response = await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/portfolio-transactions.json");
            if (!response.ok) {
                throw new Error("Failed to fetch transaction");
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error("Error fetching products:", error);
            throw error;
        }
    }
);
