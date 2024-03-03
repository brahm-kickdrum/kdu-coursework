import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { DrawerAppBar } from './components/dashboard/NavBar';
import { WatchList } from './components/dashboard/WatchList';
import { StockList } from './components/dashboard/StockList';
import DashboardNavBar from './components/dashboard/DashboardNavBar';
import {CompanyStock} from './components/stockPage/CompanyStock';


function App() {
  return (
    <BrowserRouter>
      <DrawerAppBar />

      <Routes>
        <Route path="/" element={
          <>
            <DashboardNavBar />
            <StockList />
          </>
        } />
        <Route path="/watchlist" element={
          <>
            <DashboardNavBar />
            <WatchList />
          </>
        } />
        <Route path="/company-stock/:stockName" element={<CompanyStock />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
