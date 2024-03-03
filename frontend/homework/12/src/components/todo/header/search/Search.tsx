import "./Seach.scss";
import { SearchBarContext } from "../../SearchBarProvider";
import { useContext } from "react";

export function Search(){
    
    const { searchBar, setSearchBar } = useContext(SearchBarContext);

    function searchHandler(event : any){
        setSearchBar(event.target.value);
        console.log(event.target.value);
    }
    
    return (
        <input 
        type="text" 
        id="search" 
        placeholder="Search Items..."
        value={searchBar}
        onChange={(e) => searchHandler(e)}
        />
    );
}
