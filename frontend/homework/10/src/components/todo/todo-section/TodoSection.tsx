import { useState } from 'react';
import './TodoSection.scss';
import { List } from "./list/List";
import { TodoInput } from "./todo-input/TodoInput";
import { IList } from './list/List';

export interface ITodoItem{
    id : string,
    text : string
}

export interface ITodoList{
    todoList : ITodoItem[],
    setList : React.Dispatch<React.SetStateAction<ITodoItem[]>>,
}

export function TodoSection({todoList, setList, searchBar} : IList){
    const [todoInput, setTodoInput] = useState("");
    return (
        <div className="todo-section">
            <h2>Add Items</h2>
            <TodoInput todoInput={todoInput} setTodoInput={setTodoInput} todoList = {todoList} setList = {setList}/>
            <List todoList = {todoList} setList = {setList} searchBar={searchBar}/>
           </div>
    );
}