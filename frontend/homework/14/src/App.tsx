import { BrowserRouter, Route, Link, Routes } from 'react-router-dom';
import MutableValueComponent from './components/MutableValue';
import ScrollToTopComponent from './components/ScrollToTop';
import FormComponent from './components/Focus';
import TimerComponent from './components/Timer';

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/mutable">Mutable Value</Link>
            </li>
            <li>
              <Link to="/scroll">Scroll To Top</Link>
            </li>
            <li>
              <Link to="/form">Focus on Form Field</Link>
            </li>
            <li>
              <Link to="/timer">Timer</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/mutable" element={<MutableValueComponent />} />
          <Route path="/scroll" element={<ScrollToTopComponent />} />
          <Route path="/form" element={<FormComponent />} />
          <Route path="/timer" element={<TimerComponent />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;
