import { useState } from "react";
import {Header} from "./header/Header";
import { TodoSection ,ITodoList} from "./todo-section/TodoSection";

export function Todo({todoList, setList} : ITodoList){
    const [searchBar, setSearchBar] = useState("");
    return(
        <div className="todo-list">
            <Header searchBar={searchBar} setSearchBar={setSearchBar} />
            <TodoSection todoList = {todoList} setList = {setList} searchBar={searchBar}/>
        </div>
    );
}