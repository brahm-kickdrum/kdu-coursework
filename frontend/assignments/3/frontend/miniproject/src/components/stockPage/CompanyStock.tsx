import { FormControl, MenuItem, Select } from '@mui/material';
import { createUseStyles } from 'react-jss';
import { useParams, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../redux/store';
import { SelectChangeEvent } from '@mui/material/Select';
import ChartComponent from './Graph';
import UP from '../../../public/up.png';
import DOWN from '../../../public/down.png';
import { useState } from 'react';
import { Status, addTransaction } from '../../redux/TransactionsSlice';
import { Type, addUserTransaction } from '../../redux/UserTransactionsSlice';
import { History } from './History';

export function CompanyStock() {
	const style = createUseStyles({
		stockpage: {
			display: "flex"
		},
		stocksSection: {
			margin: "3rem 5rem",
			width: "65vw",
			display: "flex",
			alignItems: "center",
			justifyContent: "space-between"

		},
		companyName: {
			width: "27rem",
			fontSize: "1.3rem"
		},
		stockData: {
			display: 'flex',
			alignItems: "center",
		},
		stockSymbol: {
			fontSize: "1.3rem",
			width: "4rem",
			backgroundColor: "#1976D2",
			textAlign: "center",
			padding: "0.5rem 0"
		},
		stockName: {
			fontSize: "1.3rem",
			padding: "0.4em",
			width: "15rem"
		},
		priceSection: {
			display: "flex",
			fontSize: "1.3rem",
			alignItems: "center",
			border: "1px solid #757575",
			padding: "1.25rem",
			width: "16rem",
			justifyContent: "space-between"
		},
		price: {
			display: "flex",
			alignItems: "center",
		},
		priceValue: {
			width: "3rem",
			textAlign: "right"
		},
		quantitySection: {
			fontSize: "1.3rem",
			padding: "1.4rem",
			width: "12rem"
		},
		buy: {
			fontSize: "1.3rem",
			backgroundColor: "#b2f2bb",
			color: "#2f9e44",
			padding: "1.45rem",
			width: "7rem",
			textAlign: "center",
			border: "1px solid #2f9e44"
		},
		sell: {
			fontSize: "1.3rem",
			backgroundColor: "#ffc9c9",
			color: "#e03131",
			padding: "1.45rem",
			width: "7rem",
			textAlign: "center",
			border: "1px solid #e03131"
		},
		graph: {
			width: "65vw",
			margin: "0 5rem"
		},
		upDownImage: {
			width: "1.8rem"
		},
		percentage: {
			width: "4rem",
			fontSize: "1rem",
			textAlign: "center"

		},
		historySection: {
			width: "35vw",
			margin: "3rem 5rem 0 0",
			// height: "35vh",
			display: "flex",
			flexDirection: "column",
			justifyContent: "space-between"
		},
		history: {
			border: "solid 1px black",
			height: "41vh",
			padding: "1.25rem"
		},
		logs: {
			border: "solid 1px black",
			height: "33vh",
			padding: "1.5rem"
		}
	});

	const { stockName } = useParams<{ stockName: string }>();
	const navigate = useNavigate();
	const styles = style();

	const dispatch = useDispatch();

	const [wallet, setWallet] = useState<number>(5000);
	const [quantity, setQuantity] = useState<number | null>(null);

	const stockBasePriceList = useSelector((state: RootState) => state.stockList.stockBasePriceList);
	const selectedStockItem = stockBasePriceList.find(stockItem => stockItem.stock_name === stockName);
	const basePrice = selectedStockItem ? selectedStockItem.base_price : '';
	const [currentValue, setCurrentValue] = useState<number>(parseInt(String(basePrice)));
	const [percentageChange, setPercentageChange] = useState<number>(0);

	const handleChange = (event: SelectChangeEvent<string>) => {
		const selectedCompany = event.target.value;
		navigate(`/company-stock/${selectedCompany}`);
	};

	const handleBuy = () => {
		if (!selectedStockItem) {
			console.error('Selected stock item is undefined');
			return;
		}
		if (!quantity) {
			console.error('Enter quantity before buying');
			return;
		}
		const totalCost = currentValue * quantity;
		if (totalCost <= wallet) {
			dispatch(addUserTransaction({
				stock_name: selectedStockItem.stock_name,
				stock_symbol: selectedStockItem.stock_symbol,
				transaction_price: currentValue,
				timestamp: new Date().toISOString(),
				status: Status.Passed,
				quantity: quantity,
				type: Type.Buy
			}));
			dispatch(addTransaction({
				stock_name: selectedStockItem.stock_name,
				stock_symbol: selectedStockItem.stock_symbol,
				transaction_price: currentValue,
				timestamp: new Date().toISOString(),
				status: Status.Passed
			}));
			setWallet(wallet - totalCost);
			setQuantity(null);
			console.log("Transaction successful")
			console.log(wallet)
		} else {
			console.log("Insufficient funds");

		}
	};

	const handleSell = () => {
		if (!selectedStockItem) {
			console.error('Selected stock item is undefined');
			return;
		}
		if (!quantity) {
			console.error('Enter quantity before selling');
			return;
		}
		const totalPrice = currentValue * quantity;
		setWallet(wallet + totalPrice);

		dispatch(addUserTransaction({
			stock_name: selectedStockItem.stock_name,
			stock_symbol: selectedStockItem.stock_symbol,
			transaction_price: currentValue,
			timestamp: new Date().toISOString(),
			status: Status.Passed,
			quantity: quantity,
			type: Type.Sell
		}));

		dispatch(addTransaction({
			stock_name: selectedStockItem.stock_name,
			stock_symbol: selectedStockItem.stock_symbol,
			transaction_price: currentValue,
			timestamp: new Date().toISOString(),
			status: Status.Passed
		}));

		setQuantity(0);
		console.log("Sell transaction successful");
		console.log(wallet);
	};

	return (
		<div className={styles.stockpage}>
			<div>
				<div className={styles.stocksSection}>
					<div >
						<FormControl className={styles.companyName}>
							<Select
								value={stockName}
								onChange={handleChange}
								MenuProps={{
									PaperProps: {
										style: {
											maxHeight: 300,
										},
									},
								}}
							>
								{stockBasePriceList.map((stockItem) => (
									<MenuItem key={stockItem.stock_name} value={stockItem.stock_name}>
										<div className={styles.stockData}>

											<div className={styles.stockSymbol}>
												{stockItem.stock_symbol}
											</div>
											<div className={styles.stockName}>
												{stockItem.stock_name}
											</div>
										</div>
									</MenuItem>
								))}
							</Select>
						</FormControl>
					</div>
					<div className={styles.priceSection}>
						<div>
							Price
						</div>
						<div className={styles.price}>
							<div className={styles.priceValue} style={{ color: percentageChange >= 0 ? '#2f9e44' : '#e03131' }}>
								{currentValue}
							</div>
							<img src={percentageChange >= 0 ? UP : DOWN} alt="change" className={styles.upDownImage} />
						</div>

						<div className={styles.percentage}>
							{percentageChange}%
						</div>
					</div>
					<input
						type="number"
						placeholder="Enter QTY"
						className={styles.quantitySection}
						value={quantity ?? ''}
						onChange={(e) => setQuantity(parseInt(e.target.value))}
					/>
					<button className={styles.buy} onClick={handleBuy}>
						Buy
					</button>
					<button className={styles.sell} onClick={handleSell}>
						Sell
					</button>
				</div>
				<div className={styles.graph}>
					<ChartComponent
						setCurrentValue={setCurrentValue}
						setPercentageChange={setPercentageChange}
					/>
				</div>
			</div>
			<div className={styles.historySection}>
				<div className={styles.history}>

					<History />
				</div>
				<div className={styles.logs}>
				</div>
			</div>
		</div>

	);
}


