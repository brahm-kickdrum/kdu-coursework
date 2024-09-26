import "./TodoInput.scss";
import { v4 as uuidv4 } from 'uuid'; 

import { ITodoItem } from "../TodoSection";

interface ITodoInput{
    todoInput : string,
    setTodoInput : React.Dispatch<React.SetStateAction<string>>,
    todoList : ITodoItem[],
    setList : React.Dispatch<React.SetStateAction<ITodoItem[]>>
}

export function TodoInput({todoInput, setTodoInput, todoList, setList}: ITodoInput){

    function changeHandler(event: any) {
        setTodoInput(event.target.value)
        console.log(event.target.value);
    }

    function submitHandler(event : any){
        if(todoInput.trim()!=""){

            const newItem = {
                id: uuidv4(), 
                text: todoInput
            };
            setList([...todoList, newItem]);
            setTodoInput('');
        }
    }

       return (
        <div className="todo">
            <input 
            className="todo-input" 
            type="text" 
            value={todoInput}
            onChange={(e) => changeHandler(e)}
            />
            <button onClick={submitHandler} className="submit">Submit</button>
        </div>
    );
}