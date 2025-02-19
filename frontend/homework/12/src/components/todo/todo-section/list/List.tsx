import { ListItem } from "./list-items/ListItem";
import "./List.scss";
import { ITodoItem } from '../../../../interfaces/ITodoItem';
import { useContext } from "react";
import { ISearchBarContext, SearchBarContext } from "../../SearchBarProvider";
import { ITodoListContext, TodoListContext } from '../../../../TodoListProvider';

export function List() {
    const { todoList, setTodoList } = useContext<ITodoListContext>(TodoListContext);
    const { searchBar} = useContext<ISearchBarContext>(SearchBarContext);
    const handleRemoveItem = (id: string) => {
        const updatedList = todoList.filter(item => item.id !== id);
        setTodoList(updatedList);
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
