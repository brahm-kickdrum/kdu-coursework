import "./Seach.scss"
import { IHeader } from "../Header";

export function Search({searchBar, setSearchBar}:IHeader){
    
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