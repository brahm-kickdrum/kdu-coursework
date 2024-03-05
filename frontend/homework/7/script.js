const socket = io("http://localhost:3000");

const messageInput = document.getElementById("msg_input");
const sendButton = document.getElementById("send_message");
const messageOutput = document.getElementById("messages");

function addMessage(from, message){
    const div = document.createElement('div');
    div.className = "message-box";

    if(from === "You"){
        imgUrl = "images/woman.png"
    }
    else{
        imgUrl = "images/man.png"
    }
    const img = document.createElement('img');
    img.src = imgUrl;
    img.className = "icon";
    div.appendChild(img);

    const element = document.createElement('p');
    element.innerText = message;
    element.className = "message";
    div.appendChild(element);
    messageOutput.appendChild(div);
}


sendButton.addEventListener("click", () =>{
    const message = messageInput.value;
    socket.emit("message", message);
    addMessage("You", message);
    messageInput.value = "";
});

socket.on("new-message", message =>{
    addMessage("User", message);
})