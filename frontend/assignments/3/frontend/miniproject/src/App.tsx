// import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import { DrawerAppBar } from './components/dashboard/NavBar';
// import { WatchList } from './components/dashboard/WatchList';
// import { StockList } from './components/dashboard/StockList';
// import DashboardNavBar from './components/dashboard/DashboardNavBar';
// import { CompanyStock } from './components/stockPage/CompanyStock';
// import { TransactionList } from './components/transactionPage/Transaction';
// import { useEffect } from 'react';
// import { getTransactions } from './redux/thunk/getTransactions';
// import { useDispatch } from 'react-redux';
// import { AppDispatch } from './redux/store';


// function App() {
//   const dispatch = useDispatch<AppDispatch>();
//   useEffect(() => {
//     dispatch(getTransactions());
//   }, []);
//   return (
//     <BrowserRouter>
//       <DrawerAppBar />

//       <Routes>
//         <Route path="/" element={
//           <>
//             <DashboardNavBar />
//             <StockList />
//           </>
//         } />
//         <Route path="/watchlist" element={
//           <>
//             <DashboardNavBar />
//             <WatchList />
//           </>
//         } />
//         <Route path="/company-stock/:stockName" element={<CompanyStock />} />
//         <Route path="/My PortFolio" element={<TransactionList />} />
//       </Routes>
//     </BrowserRouter>
//   );
// }

// export default App;

import { Suspense, useEffect } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { DrawerAppBar } from './components/dashboard/NavBar';
import { WatchList } from './components/dashboard/WatchList';
import { StockList } from './components/dashboard/StockList';
import DashboardNavBar from './components/dashboard/DashboardNavBar';
import { CompanyStock } from './components/stockPage/CompanyStock';
import { TransactionList } from './components/transactionPage/Transaction';
import { getTransactions } from './redux/thunk/getTransactions';
import { useDispatch } from 'react-redux';
import { AppDispatch } from './redux/store';

function App() {
  const dispatch = useDispatch<AppDispatch>();

  useEffect(() => {
    dispatch(getTransactions());
  }, []);

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
        <Route path="/My PortFolio" element={
          <Suspense fallback={<div>Loading...</div>}>
            <TransactionList />
          </Suspense>
        } />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
