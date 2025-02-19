import "./Filter.scss"

interface IFilterList{
    filterList : string[],
    setFilterList : React.Dispatch<React.SetStateAction<string[]>>
}

export function Filter({filterList, setFilterList}:IFilterList){

    function deleteFromFilterList(item: string) {
        console.log(item);
        setFilterList(prevList => prevList.filter(filterItem => filterItem !== item));
    }
    

    return (
        <div className="filter" >
            <div className="filter-text">Filters</div>
            <div className="filter-list">
                {
                    filterList.map((item)=>{
                        return (
                            <button onClick={() => deleteFromFilterList(item)} className="filter-item" key={item}>{item} &#x2715;</button>
                        );
                    })
                }
            </div>
        </div>
    );
}
