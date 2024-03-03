
import DashboardNavBar from "./DashboardNavBar"
import { DrawerAppBar } from "./NavBar"
import { StockList } from "./StockList"
import { WatchList } from "./WatchList"

export function Dashboard() {
  
  return (
    <>

      <DrawerAppBar />
      <DashboardNavBar />
      <WatchList />
      <StockList/>    
    </>
  )
}


