import { ApiQuotes } from "../types/quotes-types";
import "./Quotes.scss";

interface QuoteProps {
    quote: ApiQuotes;
    filterList : string[],
    setFilterList : React.Dispatch<React.SetStateAction<string[]>>
}

export function Quote({ quote, filterList, setFilterList }: QuoteProps) {

    function addToFilterList(item: string) {
        if (!filterList.includes(item)) { 
            setFilterList(prevList => [...prevList, item]);
        }
    }

    return (
        <div className="quote-div">
            <h1>{quote.content}</h1>
            <p className="author" >~{quote.author}</p>
            <p className="date">{quote.dateAdded}</p>

            <div className="quotes-genre">
                {quote.tags.map((q) => {
                    return (
                        <button onClick={()=>addToFilterList(q)} className="genre" key={q}>
                            {q}
                        </button>
                    )
                })}
            </div>
        </div>
    );
}