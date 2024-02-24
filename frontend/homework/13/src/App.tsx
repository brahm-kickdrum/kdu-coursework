import { BrowserRouter, Route, Routes } from "react-router-dom"
import { Homepage } from "./components/HomePage"
import { ProductListProvider } from "./contexts/ProductListProvider"  // Import the ProductListProvider here
import { Product } from "./components/Product"
import { SearchProvider } from "./contexts/SearchQueryProvider"

function App() {
  return (
    <div>
      <BrowserRouter>
        <SearchProvider>
          <ProductListProvider>  {/* Provide the ProductListProvider here */}
            <Routes>
              <Route path="/" element={<Homepage />} />
              <Route path="/:id" element={<Product />} />
            </Routes>
          </ProductListProvider>
        </SearchProvider>
      </BrowserRouter>
    </div>
  )
}

export default App
