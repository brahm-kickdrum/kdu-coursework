import { Filter } from "./filter/Filter";
import { SearchBar } from "./seachbar/SearchBar";
import { Sort } from "./sort/Sort";

export function Header() {

    const header: React.CSSProperties = {
        display: "flex",
        alignItems: "center"
    }

    const filterSection: React.CSSProperties = {
        display: "flex",
        alignItems: "center"
    }
 
    return ( 
        <div style={header}>
            <SearchBar />
            <div style={filterSection}>
                <Filter />
                <Sort />
            </div>
        </div>
    );
}
