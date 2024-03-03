import { useContext } from 'react';
import { ITodoListContext, TodoListContext } from '../../../../TodoListProvider';
import { ITodoInputContext, TodoInputContext } from '../TodoInputProvider';
import "./TodoInput.scss";
import { v4 as uuidv4 } from 'uuid'; 


export function TodoInput(){
    const { todoList, setTodoList } = useContext<ITodoListContext>(TodoListContext);
    const { todoInput, setTodoInput} = useContext<ITodoInputContext>(TodoInputContext);


    function changeHandler(event: any) {
        setTodoInput(event.target.value)
        console.log(event.target.value);
    }

    function submitHandler(event : any){
        if(todoInput.trim()!==""){

            const newItem = {
                id: uuidv4(), 
                text: todoInput
            };
            setTodoList([...todoList, newItem]);
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