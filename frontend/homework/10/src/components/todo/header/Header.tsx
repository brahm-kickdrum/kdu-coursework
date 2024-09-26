import { Search } from "./search/Search";

import './Header.scss'

export interface IHeader{
    searchBar : string,
    setSearchBar : React.Dispatch<React.SetStateAction<string>>
}

export function Header({searchBar, setSearchBar}:IHeader) {
    return (
        <div className="header">
            <h1>Item Lister</h1>
            <Search searchBar={searchBar} setSearchBar={setSearchBar} />
        </div>
    );
}
