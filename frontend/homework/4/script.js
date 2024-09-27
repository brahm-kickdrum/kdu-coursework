function addToTodoList(event){
    const list = document.getElementById("todo-list");
    let element = document.createElement("li");
    element.classList.add("list-element");
    
    // Create checkbox
    let checkBox = document.createElement("input");
    checkBox.type = "checkbox";
    element.appendChild(checkBox);
    
    // Create text from input field
    const textBox = document.getElementById("task").value;
    let textNode = document.createTextNode(textBox);
    element.appendChild(textNode);
    
    // Create delete button
    let deleteButton = document.createElement("button");
    deleteButton.textContent = "delete";
    deleteButton.addEventListener("click", function() {
        list.removeChild(element); // Remove the li element when delete button is clicked
    });
    element.appendChild(deleteButton);
    
    list.appendChild(element); // Append the li element to the ul
}

// Add event listener to the add button
const addButton = document.getElementById("button");
addButton.addEventListener("click", addToTodoList);
