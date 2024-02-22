
import { useState } from 'react';
import './App.css';
import {Todo} from './components/todo/TodoList';
import { v4 as uuidv4 } from 'uuid';


function App() {
  const [todoList, setList]  = useState([
    {
      id :  uuidv4(),
      text : "Hands on"
    }
  ]);
  return (
    <Todo todoList = {todoList} setList = {setList} />
  );
}

export default App;