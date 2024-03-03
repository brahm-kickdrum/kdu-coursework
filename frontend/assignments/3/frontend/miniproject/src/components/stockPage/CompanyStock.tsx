import { FormControl, MenuItem, Select } from '@mui/material';
import { createUseStyles } from 'react-jss';
import { useParams, useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { RootState } from '../../redux/store';
import { SelectChangeEvent } from '@mui/material/Select';
import ChartComponent from './Graph';
import '../../../public/up.png'

export function CompanyStock() {
	const style = createUseStyles({
		stocksSection: {
			margin: "3rem 5rem",
			width: "70vw",
			// border: "black solid 1px",
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
			width: "20rem",
			justifyContent: "space-around"
		},
		price: {
			display: "flex",
			alignItems: "center",
		},
		priceValue: {

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
			padding: "1.25rem",
			width: "7rem",
			textAlign: "center",
			border: "1px solid #2f9e44"
		},
		sell: {
			fontSize: "1.3rem",
			backgroundColor: "#ffc9c9",
			color: "#e03131",
			padding: "1.25rem",
			width: "7rem",
			textAlign: "center",
			border: "1px solid #e03131"
		},
		graph: {
			width: "70vw"
		}
	});

	const { stockName } = useParams<{ stockName: string }>();
	const navigate = useNavigate();
	const styles = style();

	const stockBasePriceList = useSelector((state: RootState) => state.stockList.stockBasePriceList);
	const selectedStockItem = stockBasePriceList.find(stockItem => stockItem.stock_name === stockName);
	const basePrice = selectedStockItem ? selectedStockItem.base_price : '';
	const handleChange = (event: SelectChangeEvent<string>) => {
		const selectedCompany = event.target.value;
		navigate(`/company-stock/${selectedCompany}`);
	};

	return (
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
						<div className={styles.priceValue}>
							{basePrice}
						</div>
						<div>
							<img src="up.png" alt="up" />
							{/* <img src="crossed.png" alt="up" /> */}
							{/* &#8593;
						&#8595; */}
						</div>
					</div>
					<div>
						3.00%
					</div>
				</div>
				<input type="text" placeholder='Enter QTY' className={styles.quantitySection} />
				<div className={styles.buy}>
					Buy
				</div>
				<div className={styles.sell}>
					Sell
				</div>
			</div>
			<div className= {styles.graph}>

				<ChartComponent />
			</div>
		</div>

	);
}
