import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../../redux/store";
import { getStockBasePrice } from "../../redux/thunk/getStockBasePrice";
import { useEffect, useState } from "react";
import { createUseStyles } from "react-jss";
import { Box, Pagination, Stack } from "@mui/material";
import { IStockBasePrice } from "../../redux/StockBasePriceSlice";
import { addToWatchList, removeFromWatchList } from "../../redux/WatchListSlice";
import {CircularIndeterminate} from "../Loader";
import { Link } from "react-router-dom";

export function StockList() {
    const style = createUseStyles({
        stockListSection: {
            padding: "0 3%",
            margin: "1.5rem 15% 0",
            border: "solid 0.25rem #5B6065",
            borderRadius: "2rem"
        },
        listItemHearder: {
            borderBottom: "solid 0.25rem #5B6065",
        },
        listItem: {
            display: "flex",
            justifyContent: "space-between",
            fontSize: "1.2rem",
            padding: "1.5rem 0",
            borderBottom: "1px black solid",
            color: "black"
        },
        basePriceAndWatchList: {
            display: "flex",
            justifyContent: "space-between",
            width: "35%"
            // width: "15rem"
        },

        company: {
            color: 'black'
        },

        basePrice: {
            width: "60%",
            textAlign: "center"
        },
        watchList: {
            backgroundColor: "white",
            border: "none",
            display: "flex",
            justifyContent: "center",
            width: "40%"
        },
        paginationContainer: {
            display: 'flex',
            justifyContent: 'center',
            padding: "1.5rem",
            alignItems: "center"
        },
        tickImage: {
            width: "2rem"
        },
        "@media (max-width: 700px)": {
            stockListSection: {
                margin: "1.5rem 5% 0",
                border: "solid 0.25rem #5B6065",
                borderRadius: "2rem",
            },
        }
    });

    const reduxDispatch: AppDispatch = useDispatch();
    const stockBasePriceList = useSelector((state: RootState) => state.stockList.stockBasePriceList);
    const status = useSelector((state: RootState) => state.stockList.status);
    const watchList = useSelector((state: RootState) => state.watchList.watchlist);
    const styles = style();

    useEffect(() => {
        reduxDispatch(getStockBasePrice());
    }, []);

    const [page, setPage] = useState(1);
    const itemsPerPage = 7;
    const totalPages = Math.ceil(stockBasePriceList.length / itemsPerPage);

    const [hoveredButton, setHoveredButton] = useState<string | null>(null);

    const handleMouseEnter = (buttonId: string) => {
        setHoveredButton(buttonId);
    };

    const handleMouseLeave = () => {
        setHoveredButton(null);
    };

    const handleChangePage = (event: React.ChangeEvent<unknown>, newPage: number) => {
        setPage(newPage);
    };

    const isInWatchList = (stockItem: IStockBasePrice) => {
        return watchList.some(item => item.stock_name === stockItem.stock_name);
    };

    const handleAddToWatchlist = (stockItem: IStockBasePrice) => {
        reduxDispatch(addToWatchList(stockItem));
    };

    const handleRemoveFromWatchlist = (stockItem: IStockBasePrice) => {
        reduxDispatch(removeFromWatchList(stockItem.stock_name));
    };


    return (
        <Box >
            {status === "pending" ?
                (<CircularIndeterminate />) :
                <div className={styles.stockListSection}>
                    <ul>
                        <li className={[styles.listItem, styles.listItemHearder].join(' ')}>
                            <div>
                                Company
                            </div>
                            <div className={styles.basePriceAndWatchList}>
                                <div className={styles.basePrice}>
                                    Base Price
                                </div>
                                <div className={styles.watchList}>
                                    Watch List
                                </div>
                            </div>
                        </li>
                        {stockBasePriceList.slice((page - 1) * itemsPerPage, page * itemsPerPage).map((stockItem) => (
                            <li className={styles.listItem} key={stockItem.stock_name}>
                                <Link to={`/company-stock/${stockItem.stock_name}`} className={styles.company}>
                                    {stockItem.stock_name}
                                </Link>
                                <div className={styles.basePriceAndWatchList}>
                                    <div className={styles.basePrice}>
                                        &#x20B9;{stockItem.base_price}
                                    </div>
                                    <button
                                        className={styles.watchList}
                                        onMouseEnter={() => handleMouseEnter(stockItem.stock_name)}
                                        onMouseLeave={handleMouseLeave}
                                        onClick={() => isInWatchList(stockItem) ? handleRemoveFromWatchlist(stockItem) : handleAddToWatchlist(stockItem)}
                                    >
                                        {isInWatchList(stockItem) ? (
                                            <img className={styles.tickImage}
                                                src={hoveredButton === stockItem.stock_name ? "crossed.png" : "tick.png"}
                                                alt="tick"
                                            />
                                        ) : (
                                            <img src="add.png" alt="add" />
                                        )}
                                    </button>
                                </div>
                            </li>
                        ))}
                    </ul>
                    <div className={styles.paginationContainer}>
                        <Stack spacing={2}>
                            <Pagination
                                count={totalPages}
                                color="primary"
                                page={page}
                                onChange={handleChangePage}
                                size="large" />
                        </Stack>
                    </div>
                </div>
            }
        </Box>
    );
}