import { createUseStyles } from "react-jss";
import SEARCH from "../../../public/search.png";
import { useSelector } from "react-redux";
import { RootState } from "../../redux/store";

interface IFilter {
    searchInput: string,
    setSearchInput: React.Dispatch<React.SetStateAction<string>>,
    startDate: Date | null,
    setStartDate: React.Dispatch<React.SetStateAction<Date | null>>,
    endDate: Date | null,
    setEndDate: React.Dispatch<React.SetStateAction<Date | null>>,
    showPassed: boolean,
    setShowPassed: React.Dispatch<React.SetStateAction<boolean>>,
    showFailed: boolean,
    setShowFailed: React.Dispatch<React.SetStateAction<boolean>>,
    checkedStockNames: string[],
    setCheckedStockNames: React.Dispatch<React.SetStateAction<string[]>>
}



export function Filter({ searchInput, setSearchInput, startDate, setStartDate, endDate, setEndDate, showPassed, setShowPassed, showFailed, setShowFailed, checkedStockNames, setCheckedStockNames }: IFilter) {
    const style = createUseStyles({
        filterSection: {
            width: "25vw",
            position: "sticky",
            top: "9rem",
            margin: "3rem 0",
            height: "35rem",
            border: "1px solid black",
            borderRadius: "2rem"
        },
        filterBar: {
            display: "flex",
            borderBottom: "1px solid black",
            padding: "1rem",
            fontSize: "1.3rem",
            justifyContent: "space-between"
        },
        search: {
            borderBottom: "1px solid black"
        },
        searchBar: {
            display: "flex",
            alignItems: "center",
            border: "1px solid black",
            height: "2.5rem",
            margin: "1rem",
            borderRadius: "0.5rem",
            fontFamily: '"Poppins", sans-serif'
        },
        searchIcon: {
            width: "1.25rem",
            margin: "0 0.75rem"
        },
        searchInput: {
            border: "none",
            outline: "none",
            fontSize: "1rem",
            width: "80%"
        },
        dates: {
            borderBottom: "1px solid black",
            display: "flex",
            justifyContent: "space-evenly"
        },
        calander: {
            width: "45%",
            margin: "1rem 0",
            height: "2rem",
            fontSize: "1rem",
            borderRadius: "0.5rem"
        },
        passedFailed: {
            padding: "0.5rem 1rem",
            fontSize: "1.1rem",
            borderBottom: "1px black solid"
        },
        itemsMap: {
            margin: "0.5rem 1rem",
            fontSize: "1.1rem",
            maxHeight: "16rem",
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
        clearAllButton: {
            fontSize: "1.3rem",
            backgroundColor: "white",
            border: "none",
            color: "#1976D2"
        },
        "@media ( max-width: 600px)": {
            filterSection: {
                width: "85vw",
                position: "static",
                top: "9rem",
                margin: "3rem 0",
                height: "35rem",
                border: "1px solid black",
                borderRadius: "2rem"
            },

        }
    });

    const handleEndDateChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const selectedEndDate = new Date(e.target.value);
        if (startDate !== null && selectedEndDate < startDate) {
            setEndDate(startDate);
        } else {
            setEndDate(selectedEndDate);
        }
    };

    const handlePassedChange = () => {
        setShowPassed(!showPassed);
    };

    const handleFailedChange = () => {
        setShowFailed(!showFailed);
    };

    const handleCheckboxChange = (stockName: string) => {
        if (checkedStockNames.includes(stockName)) {
            setCheckedStockNames(prev => prev.filter(name => name !== stockName));
        } else {
            setCheckedStockNames(prev => [...prev, stockName]);
        }
    };

    const handleClearAll = () => {
        setSearchInput('');
        setStartDate(null);
        setEndDate(null);
        setShowPassed(true);
        setShowFailed(true);
        setCheckedStockNames([]);
    };

    const styles = style();

    const stockBasePriceList = useSelector((state: RootState) => state.stockList.stockBasePriceList);

    return (
        <div className={styles.filterSection}>
            <div className={styles.filterBar}>
                <div>Filters</div>
                <button className={styles.clearAllButton} onClick={handleClearAll}>Clear All</button>
            </div>
            <div className={styles.search}>
                <div className={styles.searchBar}>
                    <img src={SEARCH} alt="search " className={styles.searchIcon} />
                    <input
                        type="text"
                        placeholder="Search for a Stock"
                        className={styles.searchInput}
                        value={searchInput}
                        onChange={(e) => setSearchInput(e.target.value)}
                    />

                </div>
            </div>
            <div className={styles.dates}>
                <input
                    className={styles.calander}
                    type="date"
                    placeholder="Start Date"
                    value={startDate ? startDate.toISOString().slice(0, 10) : ''}
                    onChange={(e) => setStartDate(new Date(e.target.value))}
                />
                <input
                    className={styles.calander}
                    type="date"
                    value={endDate ? endDate.toISOString().slice(0, 10) : ''}
                    onChange={handleEndDateChange}
                />
            </div>
            <div className={styles.passedFailed}>
                <div>
                    <input
                        type="checkbox"
                        name="failed"
                        checked={showFailed}
                        onChange={handleFailedChange}
                    />
                    <label htmlFor="failed">Failed</label>
                </div>
                <div>
                    <input
                        type="checkbox"
                        name="passed"
                        checked={showPassed}
                        onChange={handlePassedChange}
                    />
                    <label htmlFor="passed">Passed</label>
                </div>

            </div>
            <div className={styles.itemsMap}>
                {stockBasePriceList.map((stockItem) => (
                    <div key={stockItem.stock_name}>
                        <input
                            type="checkbox"
                            id={stockItem.stock_name}
                            name={stockItem.stock_name}
                            checked={checkedStockNames.includes(stockItem.stock_name)}
                            onChange={() => handleCheckboxChange(stockItem.stock_name)}
                        />
                        <label htmlFor={stockItem.stock_name}>{stockItem.stock_name}</label>
                    </div>
                ))}
            </div>
        </div>
    );
}