import React, { createContext, useState } from 'react';


export interface ITodoInputContext {
    todoInput: string;
    setTodoInput: React.Dispatch<React.SetStateAction<string>>;
}

export const TodoInputContext = createContext<ITodoInputContext>({
    todoInput: "",
    setTodoInput: () => { }
});

export interface ITodoInputProviderProps {
    children: React.ReactNode;
}

export const TodoInputProvider = ({ children }: ITodoInputProviderProps) => {
    const [todoInput, setTodoInput] = useState("");

    return (
        <TodoInputContext.Provider value={{ todoInput, setTodoInput }}>
            {children}
        </TodoInputContext.Provider>
    );
};
