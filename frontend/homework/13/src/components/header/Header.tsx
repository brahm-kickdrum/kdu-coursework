import { Filter } from "./filter/Filter";
import { SearchBar } from "./seachbar/SearchBar";
import { Sort } from "./sort/Sort";

export function Header() {
    return ( 
        <div>
            <SearchBar />
            <div>
                <Filter />
                <Sort />
            </div>
        </div>
    );
}
