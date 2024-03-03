import { useState, useEffect } from "react";
import { ApiQuotes } from "./types/quotes-types";
import { Quote } from "./components/Quotes";
import "./App.scss";
import { Filter } from "./components/Filter";

function App() {

  const [allQuotes, setAllQuotes] = useState<ApiQuotes[]>([]);

  const [filterQuotes, setFilterQuotes] = useState<ApiQuotes[]>([]);

  const [filterList, setFilterList] = useState<string[]>([]);


  useEffect(() => {
    if (filterList.length === 0) {
      setFilterQuotes(allQuotes);
    } else {
      const filteredQuotes = allQuotes.filter(quote => {
        return quote.tags.some(tag => filterList.includes(tag));
      });
      setFilterQuotes(filteredQuotes);
    }
  }, [filterList, allQuotes]);

  useEffect(() => {
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => response.json())
      .then((data: ApiQuotes[]) => {
        console.log(data);
        setAllQuotes(data);
      })
  }, []);

  const addQuote = () => {
    fetch("https://api.quotable.io/quotes/random?limit=1")
      .then((response) => response.json())
      .then((data: ApiQuotes[]) => {
        setAllQuotes([data[0], ...allQuotes]);
      });
  };

  return (

    <div className="quote-app">
      <button className="new-quote" onClick={addQuote}>NEW QUOTE</button>
      <Filter filterList={filterList} setFilterList={setFilterList} />
      <div className="quote-list">
        {
          filterQuotes.map((quote) => {
            return <Quote key={quote._id} quote={quote} filterList={filterList} setFilterList={setFilterList} />
          })
        }
      </div>
    </div>


  );
}

export default App;
