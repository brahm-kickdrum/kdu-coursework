import { useSelector } from 'react-redux';
import { RootState } from '../../redux/store';
import { IUserTransaction } from '../../redux/UserTransactionsSlice';
import { createUseStyles } from 'react-jss';

export function History() {
    const style = createUseStyles({
        historyText: {
            fontSize: "1.3rem",
            padding: "0 0 1rem 0"
        },
        historyList: {
            padding: "0 1rem 0 0 ",
            height: "32vh",
            overflowY: "auto",
            "&::-webkit-scrollbar": {
                width: "8px",
            },
            "&::-webkit-scrollbar-track": {
                background: "#f1f1f1",
            },
            "&::-webkit-scrollbar-thumb": {
                background: "#888",
                borderRadius: "5px",
            },
            "&::-webkit-scrollbar-thumb:hover": {
                background: "#555",
            },
        },
        stockDetails: {
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            fontSize: "1.1rem",
            border: "1px solid black",
            padding: "0.8rem",
            margin: "0 0 1.1rem  0",
            borderRadius: "1rem"
        },
        stockQuantity: {
            fontSize: "1.3rem",
            fontWeight: "400"
        },
        buy: {
            color: "green",
            fontSize: "1.3rem",
        },
        sell: {
            color: "red",
            fontSize: "1.3rem",
        }
    });

    const styles = style();

    const userTransactionList = useSelector((state: RootState) => state.userTransactionList.transactionList);

    const formatTimestamp = (timestamp: string) => {
        const date = new Date(timestamp);
        const year = date.getFullYear();
        const month = ('0' + (date.getMonth() + 1)).slice(-2);
        const day = ('0' + date.getDate()).slice(-2);
        const hour = ('0' + date.getHours()).slice(-2);
        const minute = ('0' + date.getMinutes()).slice(-2);
        return `${day}-${month}-${year} ${" "} ${hour}:${minute} IST`;
    };

    return (
        <div>
            <p className={styles.historyText}>History</p>
            <ul className={styles.historyList}>
                {userTransactionList.map((transaction: IUserTransaction) => (
                    <li key={transaction.stock_name} className={styles.stockDetails}>
                        <div>
                            <div className={styles.stockQuantity}>
                                {transaction.quantity} stocks
                            </div>
                            <div>
                                <div>{formatTimestamp(transaction.timestamp)}</div>
                            </div>
                        </div>
                        <div className={transaction.type === "Buy" ? styles.buy : styles.sell}>
                            {transaction.type}
                        </div>
                    </li>
                ))}
            </ul>
        </div>

    );
};

