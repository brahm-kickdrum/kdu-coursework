import { ListItem } from "./list-items/ListItem";
import "./List.scss";
import { ITodoItem } from "../TodoSection";

export interface IList {
    todoList: ITodoItem[],
    setList: React.Dispatch<React.SetStateAction<ITodoItem[]>>,
    searchBar: string
}

export function List({ todoList, setList, searchBar }: IList) {
    const handleRemoveItem = (id: string) => {
        const updatedList = todoList.filter(item => item.id !== id);
        setList(updatedList);
    };

    const filteredList = todoList.filter(item =>
        item.text.toLowerCase().includes(searchBar.toLowerCase())
    );

    return (
        
        <ul id="list">
            {filteredList.length > 0 ? (
                filteredList.map((item: ITodoItem) => (
                    <ListItem key={item.id} text={item.text} id={item.id} onRemove={handleRemoveItem} />
                ))
            ) : (
                <div className="no-task-found">{searchBar ? "No such tasks" : "Add tasks..."}</div>
            )}  
        </ul>
    )


}
