import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { RootState } from "../../redux/store";
import { ITransaction, TransactionStatus } from "../../redux/TransactionsSlice";
import { createUseStyles } from "react-jss";
import { CircularIndeterminate } from "../Loader";
import { Filter } from "./Filter";

export const TransactionList: React.FC = () => {
    const style = createUseStyles({

        transactionSection: {
            padding: "2rem 5vw",
            display: "flex",
            justifyContent: "space-between"
        },
        transactionListSection: {
            fontSize: "1.3rem",
            width: "60vw",
        },
        transactionItem: {
            display: "flex",
            borderBottom: "1px solid black",
            width: "100%",
            padding: "1.25rem 0",
            opacity: 1,
            "&.unchecked": {
                opacity: 0.5, 
            }
        },
        transaction: {
            display: "flex",
            alignItems: "center",
            width: "100%"
        },
        transactionItemName: {
            display: "flex",
            width: "50%"
        },
        transactionItemDetails: {
            display: "flex",
            width: "50%",
            alignItems: "center"
        },
        transactionItemPrice: {
            width: "80%",
            textAlign: "center"
        },
        transactionItemTime: {
            width: "20%",
            textAlign: "right"
        },
        stockName: {
            width: "80%"
        },
        stockSymbol: {
            width: "20%",
            textAlign: "center"

        },
        dot: {
            width: "0.75rem",
            height: "0.75rem",
            borderRadius: "50%",
            margin: "1rem"
        },
        greenDot: {
            backgroundColor: "green"
        },
        redDot: {
            backgroundColor: "red"
        },
        dateHeader: {
            marginTop: "1rem",
            borderBottom: "1px dashed #919192",
            color: "#919192",
            padding: "1.5rem 0 1rem"
        },
        "@media (mini-width: 600px && max-width: 900px)": {
            transaction: {
                display: "flex",
                alignItems: "center",
                width: "100%",
                flexDirection: "column"
            },
            transactionItemName: {
                width: "100%",
                backgroundColor: 'yellow'
            },
            transactionItemDetails: {
                display: "flex",
                width: "100%",
                alignItems: "center"
            },
            transactionItemPrice: {
                width: "80%",
                textAlign: "left"
            },
            transactionItemTime: {
                width: "20%",
            },
        },
        "@media ( max-width: 600px)": {
            transactionSection: {
                padding: "2rem 5vw",
                display: "flex",
                justifyContent: "space-between",
                flexDirection: "column",
                alignItems: "center"
            },
            transactionListSection: {
                fontSize: "1.3rem",
                width: "85vw",
            },
            transaction: {
                display: "flex",
                alignItems: "center",
                width: "100%",
                flexDirection: "column"
            },
            transactionItemName: {
                width: "100%",
                backgroundColor: 'yellow'
            },
            transactionItemDetails: {
                display: "flex",
                width: "100%",
                alignItems: "center",
                justifyContent: "space-between"
            },
            transactionItemPrice: {
                width: "80%",
                textAlign: "left"
            },

        }
    });
    const styles = style();

    const [searchInput, setSearchInput] = useState('');

    const [startDate, setStartDate] = useState<Date | null>(null);
    const [endDate, setEndDate] = useState<Date | null>(null);

    const transactionList = useSelector((state: RootState) => state.transactionList.transactionList);
    const status = useSelector((state: RootState) => state.transactionList.status);
    const error = useSelector((state: RootState) => state.transactionList.error);

    const [groupedTransactionList, setGroupedTransactionList] = useState<{ [date: string]: ITransaction[] }>({});
    const [filteredTransactionList, setFilteredTransactionList] = useState<{ [date: string]: ITransaction[] }>({});

    const [showPassed, setShowPassed] = useState(true);
    const [showFailed, setShowFailed] = useState(true);

    const [checkedStockNames, setCheckedStockNames] = useState<string[]>([]);

    useEffect(() => {
        const sortedTransactions = [...transactionList].sort((a, b) => {
            return new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime();
        });

        const groupedTransactions: { [date: string]: ITransaction[] } = {};

        sortedTransactions.forEach(transaction => {
            const date = transaction.timestamp.split('T')[0];
            if (!groupedTransactions[date]) {
                groupedTransactions[date] = [];
            }
            groupedTransactions[date].push(transaction);
        });

        setGroupedTransactionList(groupedTransactions);
    }, [transactionList]);

    useEffect(() => {
        const filteredTransactions: { [date: string]: ITransaction[] } = {};

        Object.keys(groupedTransactionList).forEach(date => {
            const filteredList = groupedTransactionList[date].filter(transaction =>
                transaction.stock_name.toLowerCase().includes(searchInput.toLowerCase()) &&
                (startDate === null || new Date(transaction.timestamp) >= startDate) &&
                (endDate === null || new Date(transaction.timestamp) <= endDate) &&
                ((showPassed && transaction.status === 'Passed') || (showFailed && transaction.status === 'Failed'))
            );
            if (filteredList.length > 0) {
                filteredTransactions[date] = filteredList;
            }
        });

        setFilteredTransactionList(filteredTransactions);
    }, [searchInput, startDate, endDate, groupedTransactionList, showPassed, showFailed]);



    if (status === TransactionStatus.Pending) {
        return (
            <div className={styles.transactionSection}>
                <CircularIndeterminate />
            </div>
        );
    }

    if (status === TransactionStatus.Error) {
        return <div className={styles.transactionSection}>Error: {error}</div>;
    }

    return (
        <div className={styles.transactionSection}>
            <Filter searchInput={searchInput} setSearchInput={setSearchInput} startDate={startDate} setStartDate={setStartDate} endDate={endDate} setEndDate={setEndDate}
            showPassed={showPassed} setShowPassed={setShowPassed} showFailed={showFailed} setShowFailed={setShowFailed} checkedStockNames={checkedStockNames} setCheckedStockNames={setCheckedStockNames} />

            <div className={styles.transactionListSection}>
                {Object.keys(filteredTransactionList).map(date => (
                    <div key={date}>
                        <div className={styles.dateHeader}>{date}</div>
                        <ul>
                            {filteredTransactionList[date]?.map((transaction, index) => (
                                <li key={index} className={`${styles.transactionItem} ${checkedStockNames.length === 0 || checkedStockNames.includes(transaction.stock_name) ? '' : 'unchecked'}`}>
                                
                                    <div className={styles.transaction}>
                                        <div className={styles.transactionItemName}>
                                            <div className={styles.stockName}>{transaction.stock_name}</div>
                                            <div className={styles.stockSymbol}>{transaction.stock_symbol}</div>
                                        </div>
                                        <div className={styles.transactionItemDetails}>
                                            <div className={styles.transactionItemPrice}>₹{transaction.transaction_price}</div>
                                            <div className={styles.transactionItemTime}>
                                                {transaction.timestamp.split('T')[1].split(':')[0] + ':' + transaction.timestamp.split('T')[1].split(':')[1]}
                                            </div>
                                            <div className={`${styles.dot} ${transaction.status === "Passed" ? styles.greenDot : styles.redDot}`} />
                                        </div>
                                    </div>
                                </li>
                            ))}
                        </ul>
                    </div>
                ))}
            </div>
        </div>
    );
};