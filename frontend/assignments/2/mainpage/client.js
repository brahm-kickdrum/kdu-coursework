const socket = io("http://localhost:3001");

// Getting references to HTML elements
const messageInput = document.getElementById("msg_input");
const sendButton = document.getElementById("send_message");
const messageOutput = document.getElementById("messages-div");

// Function to add a message to the message output area
function addMessage(from, message){
    // Creating a div element to hold the message box
    const div = document.createElement('div');
    div.classList.add("message-box");

    if(from === "You"){
        div.classList.add("right");
    }
    else{
        div.classList.add('left');
    }

    // Creating a paragraph element to display the message
    const element = document.createElement('p');
    element.innerText = message;
    element.className = "message";
    div.appendChild(element);
    // Appending the message box to the message output area
    messageOutput.appendChild(div);
}



// Event listener for the send button click
sendButton.addEventListener("click", () => {
    // Getting the message from the input field
    const message = messageInput.value;
    // Getting the username from the session storage
    const username = sessionStorage.getItem("username");
    // Emitting the message and username to the server
    socket.emit("message", { username, message });
    // Adding the message to the message output area with "You" as the sender
    addMessage("You", message);
    // Clearing the message input field
    messageInput.value = "";
});


// Event listener for receiving new messages from the server
// Event listener for receiving new messages from the server
socket.on("new-message", payload => {
    // Adding the received message to the message output area
    addMessage(payload.username, payload.message);
});

