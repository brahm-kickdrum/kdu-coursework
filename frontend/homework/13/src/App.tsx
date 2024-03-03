import { BrowserRouter, Route, Routes } from "react-router-dom"
import { Homepage } from "./components/HomePage"
import { ProductListProvider } from "./contexts/ProductListProvider"  // Import the ProductListProvider here
import { Product } from "./components/Product"
import { SearchProvider } from "./contexts/SearchQueryProvider"
import { FilterProvider } from "./contexts/FilterProvider"
import { SortProvider } from "./contexts/SortProvider"

function App() {
  return (
    <div>
      <BrowserRouter>
        <FilterProvider>
          <SortProvider>
            <SearchProvider>
              <ProductListProvider> 
                <Routes>
                  <Route path="/" element={<Homepage />} />
                  <Route path="/:id" element={<Product />} />
                </Routes>
              </ProductListProvider>
            </SearchProvider>
          </SortProvider>
        </FilterProvider>
      </BrowserRouter>
    </div>
  )
}

export default App
