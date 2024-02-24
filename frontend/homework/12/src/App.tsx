import './App.css';
import { Todo } from './components/todo/TodoList';
import { TodoListProvider } from './TodoListProvider';

function App() {
  

  return (
    <TodoListProvider>
      <Todo />
    </TodoListProvider>
  
  );
}

export default App;